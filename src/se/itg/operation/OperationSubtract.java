package se.itg.operation;

import se.itg.parse.Bracket;

public class OperationSubtract extends Operation {

	public OperationSubtract() {
		super("-");
	}
	
	public double execute(double x) {
		System.err.println("You can't do this, plzz stahwp " + toString());
		return 0;
	}

	public double execute(double x, double y) {
		return x - y;
	}
	
	public boolean keyMatches(int index, char[] chars) {
		if (index - 1 >= 0){
			return super.keyMatches(index, chars) && Bracket.VALID_DOUBLE_CHARS.contains(String.valueOf(chars[index - 1])); 
		}
		return false;
	}
}