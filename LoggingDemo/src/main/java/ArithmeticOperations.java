
public class ArithmeticOperations {
int firstNum;
int secondNum;
int total;
public ArithmeticOperations(int firstNum, int secondNum) {
	super();
	this.firstNum = firstNum;
	this.secondNum = secondNum;
}
public void addNumbers() {
	total = firstNum + secondNum;
	SingletonLogger.getInstance().getUserLogger().info("Added number of " + firstNum + " and " + secondNum + " is " + total);
}
public void subtractNumbers() {
	total = firstNum - secondNum;
	SingletonLogger.getInstance().getUserLogger().info("Subtracted number of " + firstNum + " and " + secondNum + " is " + total);
}
public void multiplyNumbers() {
	total = firstNum * secondNum;
	SingletonLogger.getInstance().getUserLogger().info("Multiplied number of " + firstNum + " and " + secondNum + " is " + total);
}
public void divideNumbers() {
	if(secondNum == 0) {
		SingletonLogger.getInstance().getSystemLogger().error("Divide by zero is not possible");
	}else {
		total = firstNum / secondNum;
		SingletonLogger.getInstance().getUserLogger().info("Divided number of " + firstNum + " and " + secondNum + " is " + total);
	}
	
	}
public int getFirstNum() {
	return firstNum;
}
public void setFirstNum(int firstNum) {
	this.firstNum = firstNum;
}
public int getSecondNum() {
	return secondNum;
}
public void setSecondNum(int secondNum) {
	this.secondNum = secondNum;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}

}
