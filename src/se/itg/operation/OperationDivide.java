package se.itg.operation;

public class OperationDivide extends Operation{
	
	public OperationDivide() {
		super("/");
	}

	public double execute(double x) {
		System.err.println("You can't do this, plzz stahwp " + toString());
		return 0;
	}

	public double execute(double x, double y) {
		return x/y;
	}
}