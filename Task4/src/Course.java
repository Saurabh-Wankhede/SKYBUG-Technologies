import java.util.ArrayList;
import java.util.List;

public class Course {

	String code;
	String title;
	String description;
	int capicity;
	String schedule;
	List<Student> registerdStudent;

	public Course(String code, String title, String description, int capicity, String schedule) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
		this.capicity = capicity;
		this.schedule = schedule;
		this.registerdStudent = new ArrayList<>();
	}

}
