import java.util.Scanner;

public class StudentGradeCalculater {

	public static void operation() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Number Of Subjects :- ");
		int numSubject = scanner.nextInt();
		int sum = 0;

		for (int i = 1; i <= numSubject; i++) {

			System.out.println("Enter the marks obtained subject " + i + " :");
			int marks = scanner.nextInt();

			while (marks > 100) {
				System.out.println("Invalid marks Enter again (below 100)");
				marks = scanner.nextInt();

			}
			sum += marks;

		}
		int averagePercentage = sum / numSubject;

		String grade = grades(averagePercentage);

		result(sum, averagePercentage, grade, numSubject);

	}

	public static String grades(int averagePercentage) {

		String grade = "F";

		if (averagePercentage >= 95 && averagePercentage <= 100) {

			grade = "A+";

		} else if (averagePercentage >= 90 && averagePercentage <= 95) {

			grade = "A";

		} else if (averagePercentage >= 80 && averagePercentage <= 90) {

			grade = "B+";

		} else if (averagePercentage >= 70 && averagePercentage <= 80) {

			grade = "B";
		} else if (averagePercentage >= 65 && averagePercentage <= 70) {

			grade = "C+";
		} else if (averagePercentage >= 60 && averagePercentage <= 65) {

			grade = "C";
		} else if (averagePercentage >= 55 && averagePercentage <= 60) {

			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}

	public static void result(int sum, int averagePercentage, String grade, int numSubject) {

		System.out.println("Total marks obtained by the student :- " + sum + " Out Of " + (numSubject * 100));

		System.out.println("Average percentage obtained by Student :- " + averagePercentage);

		System.out.println("Grade of the student :- " + grade);
	}

	public static void main(String[] args) {

		operation();

	}
}
