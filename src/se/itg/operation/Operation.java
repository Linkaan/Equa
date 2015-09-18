package se.itg.operation;

public abstract class Operation {
	private String key;
	private int parametersCount;
	
	public Operation(String key, int parametersCount){
		this.key = key;
		this.parametersCount = parametersCount;
	}
	
	public abstract double execute(double x);
	
	public abstract double execute(double x, double y);
	
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
	
	public String getKey() {
		return key;
	}
	
	public int getParametersCount() {
		return parametersCount;
	}
	
	public String toString() {
		return this.getClass().getName();
	}
}
