package se.itg.parse;

import java.util.ArrayList;

import se.itg.operation.*;

public class Bracket {
	public static final String ID_ID = "ID";
	public static final Operation[] operations = {new OperationMultiply(), 
		new OperationDivide(), new OperationAdd(), new OperationSubtract()};

	private ArrayList<Bracket> brackets;
	private String data;
	
	
	
	public Bracket(String data){
		this.data = "";
		int nextID = 0;
		brackets = new ArrayList<Bracket>();
		
		String nextBracket = "";
		boolean inBracket = false;
		int bracketsCount = 0;
		
		char[] chars = data.toCharArray();
		
		for (int i = 0; i < chars.length; i++){
			char c = chars[i];
			if (c == '(') {
				if (bracketsCount == 0){
					inBracket = true;
				}
				else {
					nextBracket += c;
				}
				bracketsCount++;
			}
			else if (c == ')'){
				bracketsCount--;
				if (bracketsCount == 0){
					inBracket = false;
					data = data.replace('(' + nextBracket + ')', ID_ID + "[" + nextID + "]");
					this.data += ID_ID + "[" + nextID + "]";
					brackets.add(new Bracket(nextBracket));
					nextID++;
					nextBracket = "";
				}
				else {
					nextBracket += c;
				}
			}
			else if (inBracket){
				nextBracket += c;
			}
			else {
				this.data += c;
			}
		}
	}
	
	public double calculate() {
		double result = 0;
		String dataCopy = data;
		boolean idStage1 = false;
		char[] chars = data.toCharArray();
		
		for (int i = 0; i < chars.length; i++){
			char c = chars[i];
			if (c == 'I') {
				idStage1 = true;
			}
			if (idStage1 && c == 'D'){
				int idIndex = getIdAt(i);
				dataCopy = dataCopy.replace("ID[" +  + "]", "");
			}
		}
		
		return result;
	}
	
	private int getIdAt(int index){
		return 0;
	}
	
	public boolean hasChildren() {
		return brackets.size() != 0;
	}
	
	public String toString() {
		if (hasChildren()){
			return data + " " + brackets.toString();
		}
		return data;
	}
}
