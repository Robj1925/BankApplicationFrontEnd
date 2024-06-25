
public class ArithmeticOperations {
	int firstNumber;
	int secondNumber;
	int total;
	public ArithmeticOperations(int firstNumber, int secondNumber) {
		super();
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	public  void addNumber() {
		total = firstNumber + secondNumber;
	}
	public void subtractNumbers() {
		total = firstNumber - secondNumber;
	}
	public void multipleNumbers() {
		total = firstNumber * secondNumber;
	}
	public void divideNumbers() {
		total = firstNumber / secondNumber;
	}

}
