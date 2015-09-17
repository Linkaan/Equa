package se.itg.parse;

public class Parser {	
	private Bracket topBracket;
	private String initialData;
	
	public Parser(String data){
		initialData = data;
	}
	
	public String getOriginal() {
		return initialData;
	}
	
	public static void main(String[] args) {
		System.out.println(new Parser("6*(2.0+3.5)"));
	}
	
	
}	
