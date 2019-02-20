package student;
import java.io.*;
import java.util.ArrayList;

public class StudentReader {
	// reads a binary file and returns an array of students on the file
	public static ArrayList<Student> readStudents(String fileName) throws ClassNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			FileInputStream fin = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fin);

			int size = in.readInt();
			// get students
			for (int i = 0; i < size; ++i) {
				
				students.add((Student)in.readObject());
			}
					
			// close streams
			in.close();
			fin.close();
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}
		
		return students;
	}
}
