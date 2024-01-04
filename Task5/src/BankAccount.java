
public class BankAccount {

	private double balance;

	public BankAccount(double accountBalance) {
		this.balance = accountBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean withdraw(double amount) {

		if (amount <= balance) {

			balance -= amount;
			return true;

		} else {
			System.out.println("Insufficient fund. Withdrawal failed");
			return false;
		}
	}

}
