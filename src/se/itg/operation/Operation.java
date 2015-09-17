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
}
