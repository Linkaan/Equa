package se.itg.parse;

import java.util.ArrayList;

import se.itg.operation.*;

public class Bracket {
	public static final String ID_ID = "ID";
	public static final String VALID_DOUBLE_CHARS = "0123456789.";
	public static final Operation[] OPERATIONS = {
		new OperationPower(), 
		new OperationMultiply(), 
		new OperationDivide(), 
		new OperationAdd(), 
		new OperationSubtract()
		};

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
		double result = 0.1;
		String dataCopy = data;
		
		if (hasChildren()){
			boolean idStage1 = false;
			char[] chars = data.toCharArray();
			
			for (int i = 0; i < chars.length; i++){
				char c = chars[i];
				if (c == 'I') {
					idStage1 = true;
				}
				if (idStage1 && c == 'D'){
					int idIndex = getIdAt(i + 2);
					dataCopy = dataCopy.replace("ID[" + idIndex + "]", String.valueOf(brackets.get(idIndex).calculate()));
					idStage1 = false;
				}
			}
		}
		
		for (Operation o : OPERATIONS){
			char[] chars = dataCopy.toCharArray();
			for (int i = 0; i < chars.length; i++){
				if (o.keyMatches(i, chars)) {
					System.out.println(findDouble(i - 1, chars, -1) + " " + o.getKey() + " " + findDouble(i + 1, chars, 1));
				}
			}
		}
		
		return result;
	}
	
	private double findDouble(int index, char[] chars, int dir){
		StringBuilder sb = new StringBuilder("");
		
		while (canCarryOnReading(index, chars, dir)){
			sb.append(chars[index]);
			index += dir;
			
		}
		if (dir < 0){
			sb.reverse();
		}
		
		return Double.parseDouble(sb.toString());
	}
	
	private boolean canCarryOnReading(int index, char[] chars, int dir){
		if (!(index >= 0 && index < chars.length)) {
			return false;
		}
		if (chars[index] == '-'){
			if (index + dir >= 0 && index + dir < chars.length){
				return !VALID_DOUBLE_CHARS.contains(String.valueOf(chars[index + dir]));
			}
			else if (index == 0){
				return true;
			}
		}
		if (!VALID_DOUBLE_CHARS.contains(String.valueOf(chars[index]))){
			return false;
		}
		return true;
	}
	
	private int getIdAt(int index){
		StringBuilder sb = new StringBuilder("");
		char[] chars = data.toCharArray();
		
		while (chars[index] != ']'){
			sb.append(chars[index]);
			index++;
		}
		return Integer.parseInt(sb.toString());
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
