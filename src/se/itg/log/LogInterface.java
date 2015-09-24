package se.itg.log;

import java.io.OutputStream;

public interface LogInterface {
	
	public enum LOG_LEVEL {
	  LOG_LEVEL_OFF(0),
	  LOG_LEVEL_DEBUG(1),
	  LOG_LEVEL_INFO(2),
	  LOG_LEVEL_WARN(3),
	  LOG_LEVEL_ERROR(4),
	  LOG_LEVEL_FATAL(5);
	  
	  public int level;
	  LOG_LEVEL(int level) {
		  this.level = level;
	  }
	};

	void LogSetLevel(int level);
	int  LogGetLevel();
	void LogSetStream(OutputStream stream);
	void LogHex(int msgLogLevel, byte[] data, int len);
	void LogMsg(int msgLogLevel, final String format, Object ...args);
	void LogDebug(final String format, Object ...args);
	void LogInfo(final String format, Object ...args);
	void LogWarn(final String format, Object ...args);
	void LogError(final String format, Object ...args);
	void LogFatal(final String format, Object ...args);
	
}
