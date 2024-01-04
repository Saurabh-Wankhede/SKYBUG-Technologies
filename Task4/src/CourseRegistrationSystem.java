import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
 
	static List<Course> courseDatabase = new ArrayList<>();
	static List<Student> studentDatabase = new ArrayList<>();

	public static void main(String[] args) {

		initializeCourses();
		
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Course Listing ");
			System.out.println("2. Student Registration ");
			System.out.println("3. Course Removal ");
			System.out.println("4. Exit ");
			
			System.out.println("Enter Your Choice :");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1: 
				displayCourseList();
				break;
				
			case 2:
				performStudentReg();
				break;
			case 3: 
				performCourseRemove();
				break;
			case 4:
				System.out.println("Exiting the system Goodbye..!");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice .Please try again..");
			}
			
		}
	}

	private static void initializeCourses() {

		courseDatabase.add(new Course("J10", "Core Java Programming", "Basic Concepts & OOPs Programming", 30,
				"Monday/wednessday/Friday - 10 AM to 11.30 AM"));
		courseDatabase.add(new Course("ADV-J11", "Advance Java Programming",
				"Advance java Concepts & Spring FrameWork ", 15, "Saturday/Sunday - 8 AM to 9.30 AM"));
	}

	private static void displayCourseList() {
		System.out.println("Course List :");

		for (Course course : courseDatabase) {
			System.out.println("Course Code : " + course.code);
			System.out.println("Title: " + course.title);
			System.out.println("Description : " + course.description);
			System.out.println("Capacity : " + course.capicity);
			System.out.println("Schedule : " + course.schedule);
			System.out.println("Available Slots : " + (course.capicity - course.registerdStudent.size()));
			System.out.println("__________________________________________________________________");

		}
	}

	private static void performStudentReg() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Student ID : ");
		String studentID = scanner.next();

		System.out.println("Enter Student name: ");
		String studentName = scanner.next();

		Student student = new Student(studentID, studentName);

		displayCourseList();

		System.out.println("Enter the course code to register : ");
		String courseCode = scanner.next();

		Course selectedCourse = findCourseByCode(courseCode);

		if (selectedCourse != null && selectedCourse.capicity > selectedCourse.registerdStudent.size()) {

			student.registeredCourese.add(selectedCourse);
			selectedCourse.registerdStudent.add(student);
			System.out.println("Registration Successfull...!");
		} else {
			System.out.println("Registration Failed. Either the course does not exist or is full .");
		}
	}

	private static void performCourseRemove() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Student ID :");
		String studentID = scanner.next();

		System.out.println("Enter the course code to remove :");
		String courseCode = scanner.next();

		Student student = findStudentByID(studentID);
		Course course = findCourseByCode(courseCode);

		if (student != null && course != null && student.registeredCourese.contains(course)) {

			student.registeredCourese.remove(course);
			course.registerdStudent.remove(student);
			System.out.println("Course removal Successfull..!");

		} else {
			System.out.println("Course removal Failed. Either the student or course is not fount in registered..!");
		}
	}

	private static Student findStudentByID(String studentID) {

		for (Student student : studentDatabase) {
			if (student.studentID.equals(studentID)) {
				return student;
			}
		}
		return null;
	}

	private static Course findCourseByCode(String courseCode) {

		for (Course course : courseDatabase) {
			if (course.code.equals(courseCode)) {
				return course;
			}
		}
		return null;
	}
}
