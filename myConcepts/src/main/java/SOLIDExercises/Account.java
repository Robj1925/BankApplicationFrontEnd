package SOLIDExercises;

public class Account {
	private int accountNumber;

	private String accountName;

	private double balance; 

	private double PIN;
	

	public Account(int accountNumber, String accountName, double balance, double pIN) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		PIN = pIN;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPIN() {
		return PIN;
	}

	public void setPIN(double pIN) {
		PIN = pIN;
	}
	

}
