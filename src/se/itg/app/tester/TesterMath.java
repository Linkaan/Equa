package se.itg.app.tester;

import se.itg.log.Logger;
import se.itg.parse.Parser;

public class TesterMath {
	public static Boolean TesterMath(String input) {
		String Operation;
		String temp;
		if (input.contains(">")){
			Operation = "moreThan";
			temp = ">";
		}else if(input.contains("<")){
			Operation = "lessThan";
			temp = "<";
		}else if(input.contains("=")){
			Operation = "equal";
			temp = "=";
		}else{
			Logger.error(new IllegalArgumentException("Error msg here").toString());
			Operation ="error";
			temp = "error";
			// -1 = universial error signal
		}
		System.out.println(temp);
		//split string input into two strings. point to split at = temp(<, >, =)
		String[] parts = input.split(temp);
		String beforeChar = parts[0];
		String afterChar = parts[1];
		System.out.println(beforeChar +" "+ afterChar);
		//add together VL
		double VL = Parser.calculate(beforeChar);
		//add together HL
		double HL = Parser.calculate(afterChar);
		System.out.println(VL + " " + HL);
		Boolean ifTrue;
		//if operation == one of the cases
		if(Operation.equalsIgnoreCase("morethan")){
			ifTrue = moreThan(VL, HL);
			
		}else if(Operation.equalsIgnoreCase("lessThan")){
			ifTrue = lessThan(VL, HL);
			
		}else if(Operation.equalsIgnoreCase("equal")){
			ifTrue = Equal(VL, HL);
				
			
		//else return null
		}else{
			
			ifTrue = null;
		}
		
		return ifTrue;
	}
	//Method for testing if VL is more Than HL
	public static Boolean moreThan(double VL, double HL){
		Boolean morethan;
		if (VL > HL){
			morethan = true;
		}
		else{
			morethan = false;
		}
		return morethan;
	}
	//Method for testing if VL is less than HL
	public static Boolean lessThan(double VL, double HL){
		Boolean lessthan;
		if (VL < HL){
			lessthan = true;
			
		}else{
			lessthan = false;
			
		}
		return lessthan;
	}
	
	//Method for testing if VL equals HL
	public static Boolean Equal(double VL, double HL){
		Boolean equal;
		
		if (VL == HL){
			equal = true;
			
		}else{
			equal = false;

		}
		return equal;
		
	}
	//returns true
	public Boolean contains(CharSequence s){
		return true;
		
	}
}