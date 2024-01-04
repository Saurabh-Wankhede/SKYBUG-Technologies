import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

	static final int QUESTION_DURATION_SECONDS = 10;
	static int score = 0;
	static int currentQuestionIndex = 0;
	static Timer timer;

	static String[] questions = { 
								" Which component is used to compile, debug and exeute the java program ?",
								" What is the entry point of a Program in java ?",
								" Which of the following are not java modifier ?",
								" Which of the following are not java keyword ?",
								" Which of the following is not an OOPS concept in java ?" 
	};

	static String[][] options = { 
								{ "a) JRE", "b) JDK", "c) JVM", "d) None" },
								{ "a) main()method", "b) first line of code ", "c) last line of code", "d) static method" },
								{ "a) public", "b) private", "c) friendly", "d) transient"},
								{ "a) Double", "b) switch", "c) then", "d) instanceof" },
								{ "a) Poloymorphism", "b) Inheritance", "c) Encapsulation", "d) Compiliation" }
	};
	
	static String[] correctAnswer = { "b", "a", "c", "c", "d" };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welecom to the Quiz !..");

//Start the quiz
		System.out.println("                ########-----INSTRUCTION FOR THE GAME  ------####### ");
		
		System.out.println();
		System.out.println("                [-----Time Limite to answer the question is 15 seconds-----]");
		
		System.out.println("                   [-----You have only 15 seconds to give a answer-----]");
		
		
		for (int i = 0; i < questions.length; i++) {
				currentQuestion(i, scanner);
		}

//Display the final score 

		System.out.println("\nQuiz Completed ! Your Final Score :" + score);
		System.out.println("Correct Answers : " + score + "/" + questions.length);
		System.out.println("Incorrect Answers : " + (questions.length - score));
		scanner.close();

	}

	public static void currentQuestion(int questionIndex, Scanner scanner) {

		System.out.println("\nQuetion " + (questionIndex + 1) + ": " + questions[questionIndex]);
		
		for (String i : options[questionIndex]) {

			System.out.println(i);
		}

		StartTimer(questionIndex, scanner);
	}

	public static void StartTimer(int questionIndex, Scanner scanner) {

		timer = new Timer();
		timer.schedule(new TimerTask() {

			int remainingSceconds = QUESTION_DURATION_SECONDS;

			@Override
			public void run() {

				if (remainingSceconds == 0) {
					System.out.println();
					System.out.println("Time's Up !");
					System.out.println("--------------------------------------");
					hadleAnswer("", questionIndex, scanner);
				}

				remainingSceconds--;
			}
		}, 0, 1500);

		String userAnswer = scanner.nextLine();
		hadleAnswer(userAnswer.toLowerCase(), questionIndex, scanner);
	}

	public static void hadleAnswer(String userAnswer, int questionIndex, Scanner scanner) {

		timer.cancel();

		if (userAnswer.equals(correctAnswer[questionIndex])) {

			System.out.println("Correct !");
			score++;
		} else {
			System.out.println("Incorrect ! The correct answer is " + correctAnswer[questionIndex]);
		}

		System.out.println("You current score :" + score);

	}

}
