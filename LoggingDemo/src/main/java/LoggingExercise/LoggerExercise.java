package LoggingExercise;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerExercise {
	private static Logger logger = LogManager.getLogger(LoggerExercise.class);
	public static void main(String[] args) {
		try {
			new LoggerExercise().returnTaxableRate("erge");
		} catch (NotANumberException e) {
			e.printStackTrace();
		}
	}

	public double returnTaxableRate(String salaryString) throws NotANumberException {
		int num;
		if (salaryString.matches("\\d+")) {
			num = Integer.parseInt(salaryString);
			
		} else {
			logger.fatal("Passed in String must be a number: " + salaryString);
			throw new NotANumberException("Needs to be a number");
		}
		
		if (Integer.parseInt(salaryString) < 0) {
			logger.error("Number cannot be zero: " + salaryString);
		} 
		if (Integer.parseInt(salaryString) == 0) {
			logger.error("Number cannot be zero: " + salaryString);
		} 
		
		num = Integer.parseInt(salaryString);
		
		if (num  > 500000 || num < 1) {
			logger.info("Number has to be in between 500000 and 1: " + num);
		}
		
		if (num >= 10000000000d) {
            logger.debug("Large salary amount: " + num);
        }
		
		return num * 0.20;

	}
}
