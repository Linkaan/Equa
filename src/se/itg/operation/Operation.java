package se.itg.operation;

public abstract class Operation {
	private String key;
	
	public Operation(String key){
		this.key = key;
	}
	
	public abstract double execute(double x);
	
	public abstract double execute(double x, double y);
	
	public String getKey() {
		return key;
	}
	
	public String toString() {
		return this.getClass().getName();
	}
	
	public boolean keyMatches(int index, char[] chars){
		char[] keyChars = key.toCharArray();
		
		if (index + keyChars.length > chars.length - 1)	return false;
		
		for (int i = 0; i < keyChars.length; i++){
			if (!(keyChars[i] == chars[index + i])){
				return false;
			}
		}
		return true;
	}
}
