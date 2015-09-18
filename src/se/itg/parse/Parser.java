package se.itg.parse;

public class Parser {	
	private Bracket topBracket;
	private String initialData;
	
	public Parser(String data){
		initialData = data;
		topBracket = new Bracket(data);
		topBracket.calculate();
	}
	
	public String getOriginal() {
		return initialData;
	}
	
	public static void main(String[] args) {
		System.out.println(new Parser("6*(2.0+(3.5-6.4))-7+4.0*(6.8-6.0)"));
	}
	
	public Bracket getTopBracket() {
		return topBracket;
	}
}	