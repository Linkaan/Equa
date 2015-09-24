package se.itg.app.tester;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import se.itg.log.LogInterface.LOG_LEVEL;
import se.itg.log.SimpleLog;

public class Tester {
	public static String input = "2^2^22^2^2";
	
	public static void test(){
		Boolean output= TesterMath.TesterMath(input);
		System.out.println(output);
		
	}
	public static void main(String[] args){
		/**
		OutputStream os;
		try {
			os = new FileOutputStream("./Equa.log", true);
			SimpleLog.getLogger().LogSetStream(os);
		} catch (IOException e) {
			// opps
		}
		byte[] data = new byte[] {(byte)0xff, (byte)0xfe, (byte)0xfd, (byte)0xfc, (byte)0xfb, (byte)0xfa};
		SimpleLog.getLogger().LogHex(LOG_LEVEL.LOG_LEVEL_DEBUG.level, data, data.length);
		*/
		Tester.test();
		
	}
}
