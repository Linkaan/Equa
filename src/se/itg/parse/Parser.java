package se.itg.parse;

public class Parser {	
	private Bracket topBracket;
	private String initialData;
	
	public Parser(String data){
		initialData = data;
		topBracket = new Bracket(data);
	}
	
	public static String parseString(String input){
		StringBuilder value = new StringBuilder("");
		int closedBrackets = 0;
		char[] chars = input.toCharArray();
		
		
		for (int i = 0; i < chars.length; i++){
			if (chars[i] == '('){
				//count brackets if 0 then all opened brackets are closed
				closedBrackets++;
				//add multiply after bracket
				if (i > 0 && charInString(Bracket.VALID_DOUBLE_CHARS, chars[i - 1])){
					value.append('*');
				}
			}
			if (chars[i] == ')'){
				closedBrackets--;
			}
			//remove spaces and replace , with .
			if (chars[i] != ' '){
				if (chars[i] == ','){
					value.append('.');
				}
				else {
					value.append(chars[i]);
				}
			}
		}
		
		chars = value.toString().toCharArray();
		value = new StringBuilder("");
		for (int i = 0; i < chars.length; i++){
			value.append(chars[i]);
			// transform all numbers into doubles aka adding .0 to the end of all ints
			if (i + 1 < chars.length && charInString(Bracket.VALID_DOUBLE_CHARS, chars[i]) && !charInString(Bracket.VALID_DOUBLE_CHARS, chars[i + 1])){
				String foundNumber = "";
				for (int k = i; k >= 0; k--){
					if (!charInString(Bracket.VALID_DOUBLE_CHARS, chars[k])){
						break;
					}
					foundNumber += chars[k];
				}
				if (!charInString(foundNumber, '.')){
					value.append(".0");
				}
			}
		}
		
		if (closedBrackets != 0){
			//TO-DO print error
		}
		return value.toString();
	}
	
	public static boolean charInString(String s, char search){
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
		return new Bracket(parseString(input)).calculate();
	}
	
	//debug main
	public static void main(String[] args) {
		//System.out.println(calculate("3.0+4.0+5.0"));
		System.out.println(calculate("6,0(4 + 6)-(5-5)"));
	}
}	