package student;
import java.io.*;
import java.util.ArrayList;

public class StudentWriter {
	// write students to file
	public static void writeStudents(ArrayList<Student> students, String fileName) throws IOException {
		FileOutputStream fout = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeInt(students.size());
		for (Student student : students) {
			out.writeObject(student);
		}
		
		out.close();
		fout.close();
	}
	
	// prompter to make students
	public static Student makeStudent(BufferedReader br) throws IOException {
		int stdID = -1;
		String firstName = null;
		String lastName = null;
		ArrayList<String> courses = new ArrayList<String>();
			
		while (stdID < 0) {
			try {
				System.out.print("Please enter student number: ");
				stdID = Integer.parseInt(br.readLine());
				if (stdID < 0) System.out.println("Number must be greater than zero.");
			} catch (NumberFormatException e) {
				System.out.println("Number is invalid.");
			} 
		}
		
		System.out.print("Please enter first name: ");
		firstName = br.readLine();
		
		System.out.print("Please enter last name: ");
		lastName = br.readLine();
		
		System.out.print("Please enter a course: ");
		courses.add(br.readLine());
		
		String yesNo = "Y";
		while (yesNo.toUpperCase().equals("Y")) {
			System.out.print("Would you like to enter another course? (Y or N): ");
			yesNo = getYesNo(br);
			if (yesNo.toUpperCase().equals("Y")) {
				System.out.print("Please enter a course: ");
				courses.add(br.readLine());
			}
		}
				
		return new Student(stdID, firstName, lastName, courses);
	}
	
	// HELPER FUNCTIONS
	// returns if string is a valid Y or N or (y or n)
	public static boolean validYesNo(String s) {
		s = s.toUpperCase();
		return (s.equals("Y") || s.equals("N")) ? true : false;
	}
	
	// Loops until user input a valid Y or N
	public static String getYesNo(BufferedReader br) throws IOException {
		String s;
		s = br.readLine();
		while (!validYesNo(s)) {
			System.out.print("Please enter Y or N: ");
			s = br.readLine();
		}
		
		return s;
	}
}

