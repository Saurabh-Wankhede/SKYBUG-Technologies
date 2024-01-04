import java.util.Scanner;

public class Atm {

	private BankAccount bankAccount;

	public Atm(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void displayMenu() {

		System.out.println("ATM Menu :");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw ");
		System.out.println("4. Exit");
	}

	public void performTransaction(int choice, Scanner scanner) {

		switch (choice) {
		case 1:
			checkBalance();
			break;

		case 2:
			deposit(scanner);
			break;
		case 3:
			withdraw(scanner);
			break;
		case 4:
			System.out.println("Exiting ATM. Thank You...!");
			System.exit(0);
			break;

		default:
			System.out.println("Invalid choice. Please Choose a vaild option..");

		}
	}

	private void checkBalance() {
		System.out.println("Current Balance :- " + bankAccount.getBalance());
	}

	private void deposit(Scanner scanner) {
		System.out.println("Enter deposit amount :-");
		double depositAmount = scanner.nextDouble();
		bankAccount.deposit(depositAmount);
		System.out.println("Deposit successful. Current Balance : " + bankAccount.getBalance());

	}

	private void withdraw(Scanner scanner) {

		System.out.println("Enter withdrawal amount :- ");
		double withdrawalAmount = scanner.nextDouble();

		if (bankAccount.withdraw(withdrawalAmount)) {
			System.out.println("Withdrawal successful. Current Balance : " + bankAccount.getBalance());
		}
	}
}
