import java.util.Scanner;

public class AtmInterface {

	public static void main(String[] args) {

//		Initialize a bank account with an initial balance
		BankAccount userAccount = new BankAccount(1000);

//		Initialize the ATM with the user Bank Account 

		Atm atm = new Atm(userAccount);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			atm.displayMenu();

			System.out.println("Enter Your Choice :");
			int choice = scanner.nextInt();

//			validate user input its correct or Not
			if (choice < 1 || choice > 4) {
				System.out.println("Invalid choice. Please choose a valid option..");
				continue;
			}

			atm.performTransaction(choice, scanner);

		}
	}
}
