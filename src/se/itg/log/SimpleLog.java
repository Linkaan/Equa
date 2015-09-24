package se.itg.log;

import java.io.OutputStream;
import java.io.PrintStream;

public class SimpleLog implements LogInterface {

	static int logLevel = LOG_LEVEL.LOG_LEVEL_DEBUG.level;
	static PrintStream outStream = null;
	static SimpleLog instance = null;
	static {
		instance = new SimpleLog();
	}
	
	public void LogSetLevel(int level) {
		logLevel = level;
	}
	
	public int LogGetLevel() {
		return logLevel;
	}
	
	public void LogSetStream(OutputStream stream) {
		outStream = new PrintStream(stream);
	}
	
	public void LogHex(int msgLogLevel, byte[] data, int len) {
		int i;
		
		if (msgLogLevel < logLevel) {
			return;
		}
		
		for (i = 0; i < len; i++) {
			LogMsg(msgLogLevel, "%02x", data[i]);
		}
	}
	
	public void LogMsg(int msgLogLevel, String format, Object... args) {
		if (outStream == null) {
			outStream = System.out;
		}
		
		if (msgLogLevel >= logLevel) {
			outStream.printf(format, args);
		}
	}
	
	public void LogDebug(String format, Object... args) {
		LogMsg(LOG_LEVEL.LOG_LEVEL_DEBUG.level, format, args);
	}
	
	public void LogInfo(String format, Object... args) {
		LogMsg(LOG_LEVEL.LOG_LEVEL_INFO.level, format, args);
	}
	
	public void LogWarn(String format, Object... args) {
		LogMsg(LOG_LEVEL.LOG_LEVEL_WARN.level, format, args);
	}
	
	public void LogError(String format, Object... args) {
		LogMsg(LOG_LEVEL.LOG_LEVEL_ERROR.level, format, args);
	}
	
	public void LogFatal(String format, Object... args) {
		LogMsg(LOG_LEVEL.LOG_LEVEL_FATAL.level, format, args);
	}
	
	public static LogInterface getLogger() {
		if (instance == null) {
			instance = new SimpleLog();
		}
		
		return instance;	
	}
}
