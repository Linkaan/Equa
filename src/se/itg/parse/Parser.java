package se.itg.parse;

public class Parser {	
	private Bracket topBracket;
	private String initialData;
	
	public Parser(String data){
		initialData = data;
		topBracket = new Bracket(data);
	}
	
	public String parseString(String input){
		//add multiply after bracket
		String value = "";
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++){
			if (chars[i] == '('){
				if (i > 0 && charInString(Bracket.VALID_DOUBLE_CHARS, chars[i - 1])){
					value += '*';
				}
			}
			value += chars[i];
		}
		
		return value;
	}
	
	public boolean charInString(String s, char search){
		for (char c : s.toCharArray()){
			if (search == c){
				return true;
			}
		}
		return false;
	}
	
	public String getOriginal() {
		return initialData;
	}
	
	public Bracket getTopBracket() {
		return topBracket;
	}
	
	public static double calculate(String input) {
		return new Bracket(input).calculate();
	}
	
	public static void main(String[] args) {
		Parser p = new Parser("6.0*(-3.0+5.0)-(5.0-7.0)^2.0");
		System.out.println(p.parseString("6(4 + 6)-(5-5)"));
	}
}	