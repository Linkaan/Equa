package se.itg.app.tester;
import se.itg.log.Logger;
import se.itg.operation.Operation;
import se.itg.operation.OperationAdd;
import se.itg.operation.OperationDivide;
import se.itg.operation.OperationMultiply;
import se.itg.operation.OperationPower;
import se.itg.operation.OperationSubtract;

public class Tester {
	public static String input = "2>1";
	public static final Operation[] OPERATIONS = {
		new OperationPower(),
		new OperationMultiply(),
		new OperationDivide(),
		new OperationAdd(),
		new OperationSubtract(),
	};
	public static void test(){
		String temp;
		if (input.contains(">")){
			temp = "moreThan";
		}else if(input.contains("<")){
			temp = "lessThan";
		}else if(input.contains("=")){
			temp = "equals";
		}else{
			Logger.error(new IllegalArgumentException("Error msg here").toString());
			temp ="error";
			
		}
		
		String[] parts = input.split(">");
		String beforeChar = parts[0];
		String afterChar = parts[1];
		System.out.println(temp);
		System.out.println(beforeChar +" "+ afterChar);
	}
	public Boolean contains(CharSequence s){
		return true;
		
	}
	public static void main(String[] args){
		Tester.test();
	}
	
}
