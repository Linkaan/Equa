package se.itg.parse;

import java.util.ArrayList;

public class Bracket {
	public static final String ID_ID = "ID";
	
	private ArrayList<Bracket> brackets;
	private String data;
	
	public Bracket(String data){
		this.data = "";
		int nextID = 0;
		brackets = new ArrayList<Bracket>();
		
		String nextBracket = "";
		boolean inBracket = false;
		int bracketsCount = 0;
		
		for (char c : data.toCharArray()){
			if (c == '(') {
				if (bracketsCount == 0){
					inBracket = true;
				}
				bracketsCount++;
			}
			else if (c == ')'){
				bracketsCount--;
				if (bracketsCount == 0){
					inBracket = false;
					data.replace('(' + nextBracket + ')', ID_ID + nextID);
					brackets.add(new Bracket(nextBracket));
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
}
