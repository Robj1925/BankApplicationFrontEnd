import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import LoggingExercise.LoggerExercise;

public class Runner {
	public static void main(String[] args) {

		Logger logger = LogManager.getLogger(Runner.class);
		ArithmeticOperations arithmeticOperations = new ArithmeticOperations(5, 0);
	arithmeticOperations.addNumbers();
	logger.info("add it together to produce: " + arithmeticOperations.getTotal());
	arithmeticOperations.divideNumbers();
	arithmeticOperations.subtractNumbers();
	arithmeticOperations.multiplyNumbers();
	}

}
