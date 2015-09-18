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
	
	public Bracket getTopBracket() {
		return topBracket;
	}
	
	public static void main(String[] args) {
		System.out.println(new Parser("6.0*(-3.0+5.0)-(5.0-7.0)"));
	}
}	