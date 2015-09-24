package se.itg.log;

public class Logger {
	
	private static LoggerLevel currentLoggerLevel = LoggerLevel.DEBUG;
	
	public static void setLevel(LoggerLevel level){
		Logger.currentLoggerLevel = level;
	}
	
	public static void error(String msg){
		if(currentLoggerLevel.level >= LoggerLevel.ERROR.level){
			log("ERROR", msg);		
		}
	}
	
	public static void warning(String msg){
		if(currentLoggerLevel.level >= LoggerLevel.WARNING.level){
			log("WARNING", msg);		
		}
	}
	
	public static void debug(String msg){
		if(currentLoggerLevel.level >= LoggerLevel.DEBUG.level){
			log("DEBUG", msg);		
		}
	}
	
	private static void log(String tag, String msg){
		System.out.println(tag + ": " + msg);
	}
	
	public static enum LoggerLevel{
		NONE(0), ERROR(1), WARNING(2), DEBUG(3);
		
		LoggerLevel(int level){
			this.level = level;
		}
		
		private int level;
	}

}
