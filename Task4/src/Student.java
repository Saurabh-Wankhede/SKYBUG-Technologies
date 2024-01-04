import java.util.ArrayList;
import java.util.List;

public class Student {

	String studentID;
	String name;
	List<Course> registeredCourese;
	
	public Student(String studentID, String name) {
		
		this.studentID = studentID;
		this.name = name;
		this.registeredCourese = new ArrayList<>();
	}
	
	
}
