package se.itg.app.tester;
import se.itg.log.Logger;
import se.itg.parse.*;

public class Tester {
	public static String input = "2^2^22^2^2";
	
	public static void test(){
		Boolean output= TesterMath.TesterMath(input);
		System.out.println(output);
		
	}
	public static void main(String[] args){
		Tester.test();
		
	}
}
