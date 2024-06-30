import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SingletonLogger {
	private static SingletonLogger singletonLog;
	private Logger userLogger = null;
	private Logger systemLogger = null;
	private SingletonLogger() {
		userLogger = LogManager.getLogger("userLogger");
		systemLogger = LogManager.getLogger("systemLogger");
	}
	public static SingletonLogger getSingletonLog() {
		return singletonLog;
	}
	public static void setSingletonLog(SingletonLogger singletonLog) {
		SingletonLogger.singletonLog = singletonLog;
	}
	public Logger getUserLogger() {
		return userLogger;
	}
	public void setUserLogger(Logger userLogger) {
		this.userLogger = userLogger;
	}
	public Logger getSystemLogger() {
		return systemLogger;
	}
	public void setSystemLogger(Logger systemLogger) {
		this.systemLogger = systemLogger;
	}
	public static SingletonLogger getInstance() {
		if(singletonLog == null) {
			singletonLog = new SingletonLogger();
		}
		return singletonLog;
	}
	
}
