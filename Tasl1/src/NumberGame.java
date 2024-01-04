import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int minRange = 1;
		int maxRange = 100;
		int MaxAttempts = 10;
		int totalAttempts = 0;
		int roundWon = 0;

		System.out.println("Welecome to the Number Guessing Game !");
		System.out.println("____________________________________________________");
		boolean itration = true;

		while (itration) {

			int genrateNumber = random.nextInt(minRange, maxRange);
			boolean guessCorrect = false;

			System.out.println("\nGuess a number between " + minRange + " and " + maxRange);

			for (int attempts = 1; attempts <= MaxAttempts; attempts++) {

				System.out.println("Attempt " + attempts + " Enter Your guess Number :- ");
				int userGuess = scanner.nextInt();
				System.out.println("--------------------------------------------------------------------");

				if (userGuess == genrateNumber) {

					guessCorrect = true;

					totalAttempts += attempts;
					roundWon++;

					System.out.println("Conguratulations ! You guess the correct number in " + attempts + " attempts.");
					System.out.println("--------------------------------------------------------------------");
					System.out.println("The Number is " + genrateNumber + " you guess Correctly ");

					break;
				} else if (userGuess < genrateNumber) {
					System.out.println("Too low ! try again");
				} else {
					System.out.println("Too high ! try again");
				}
			}

			if (!guessCorrect) {

				System.out.println("Sorry , You we run out of attempts .the correct number was " + genrateNumber);
			}

			System.out.println("Do you want to play again (yes/no)");
			String playAgain = scanner.next().toLowerCase();

			if (!playAgain.equals("yes")) {
				break;
			}
		}
		System.out.println("\n Game Over You " + roundWon + " round and took an avrage of " + (totalAttempts / roundWon)
				+ " attempts per round");
		scanner.close();
	}
}
