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
	
	/*
	 * Creates the bracket object and recursively builds the three structure
	 */
	
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
	
	/*
	 * Calculates the value of the input
	 */
	
	public double calculate() {
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
					double value = 0;
					String from = "";
					int replaceIndex = i;
					if (o.getParametersCount() == 1){
						double right = findDouble(i + 1, chars, 1);
						value = o.execute(right);
						from = o.getKey() + right; 
					}
					else if (o.getParametersCount() == 2){
						double right = findDouble(i + 1, chars, 1);
						double left = findDouble(i - 1, chars, -1);
						value = o.execute(left, right);
						from = left + o.getKey() + right;
						replaceIndex -= String.valueOf(left).length();
					}
					else {
						System.err.println("The operation " + o.toString() + " does not have 1 or 2 parameters, that's wrong");
					}
					i += String.valueOf(value).length();
					dataCopy = indexReplace(replaceIndex, from, String.valueOf(value), dataCopy);
					
				}
			}
		}
		return Double.parseDouble(dataCopy);
	}
	
	/*
	 * replaces a 
	 */
	
	private String indexReplace(int index, String from, String to, String base){
		String result = base.substring(0,index) + to + base.substring(index + from.length(), base.length());
		return result;
	}
	
	/*
	 * Finds a double at the specified index
	 */
	
	private double findDouble(int index, char[] chars, int dir){
		StringBuilder sb = new StringBuilder("");
		int firstIndex = index;
		
		while (canCarryOnReading(index, chars, dir, firstIndex)){
			sb.append(chars[index]);
			index += dir;
		}
		
		if (dir < 0){
			sb.reverse();
		}
		return Double.parseDouble(sb.toString());
	}
	
	/*
	 * Help findDouble determine if to carry on reading the char[]
	 */
	
	private boolean canCarryOnReading(int index, char[] chars, int dir, int firstIndex){
		if (!(index >= 0 && index < chars.length)) {
			return false;
		}
		if (chars[index] == '-'){
			if (index + dir >= 0 && index + dir < chars.length){
				if (dir == -1){
					return !VALID_DOUBLE_CHARS.contains(String.valueOf(chars[index + dir]));
				}
				else {
					return index == firstIndex;
				}			
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
	
	/*
	 * Finds a ID of another bracket
	 */
	
	private int getIdAt(int index){
		StringBuilder sb = new StringBuilder("");
		char[] chars = data.toCharArray();
		
		while (chars[index] != ']'){
			sb.append(chars[index]);
			index++;
		}
		return Integer.parseInt(sb.toString());
	}
	
	/*
	 * Returs this has any children
	 */
	
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
