// WORKSHOP 4

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import student.*;

public class Task1 {
	public static void read() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			students = StudentReader.readStudents("students.dat");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}
		
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
	
	public static void write() {
		ArrayList<Student> students = new ArrayList<Student>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String yesNo = "Y";
			
			while (yesNo.toUpperCase().equals("Y")) {
				Student student = StudentWriter.makeStudent(br);
				students.add(student);
				System.out.print("Would you like to add another student? (Y or N): ");
				yesNo = StudentWriter.getYesNo(br);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nCurrent students: ");
		for (Student student : students) {
			System.out.println(student.toString());
		}
		
		try {
			StudentWriter.writeStudents(students, "students.dat");
			System.out.println("Students written to students.dat!");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void promptEnterKey() {
        System.out.println("Press ENTER to continue...");
        Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
    }
	
	public static void main(String[] args) {
		System.out.println("---> Part 1 : Create a list of students <---");
		write();
		
		System.out.println();
		promptEnterKey();
		System.out.println("---> Part 2 : Read list of students from file <---");
		read();
	}
}
