package student;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;
	
	/* constructors */
	public Student() {
		this.stdID = -1;
		this.firstName = null;
		this.lastName = null;
		this.courses = null;
	}
	
	public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
		super();
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}
	
	/* getters and setters */
	public int getStdID() {
		return stdID;
	}
	public void setStdID(int stdID) {
		if (stdID > 0)
			this.stdID = stdID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public ArrayList<String> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	
	public String toString() {
		String str = new String("Student ID: " + stdID + "\n");
		str += ("Name: " + firstName + " " + lastName + "\n");
		str += ("Courses:\n");
		for (String course : courses) {
			str += ("    " + course + "\n");
		}
		
		return str;
	}
}