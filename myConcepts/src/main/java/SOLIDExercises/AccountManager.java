package SOLIDExercises;

public class AccountManager {
	private Account account;
	private boolean hasOverdraft; 

	private boolean hasInterestPayment; 

	private boolean hasInterestCharge;

	public AccountManager(Account account, boolean hasOverdraft, boolean hasInterestPayment,
			boolean hasInterestCharge) {
		super();
		this.account = account;
		this.hasOverdraft = hasOverdraft;
		this.hasInterestPayment = hasInterestPayment;
		this.hasInterestCharge = hasInterestCharge;
	}
	
}
