package student.gui;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import student.*;

public class StudentGUI extends JFrame {
	private ArrayList<Student> students;
	private AddStudentGUI addStudentGUI = new AddStudentGUI(StudentGUI.this);

	public StudentGUI() {
		super("Student GUI");
		// initialize file chooser
		JFileChooser fc = new JFileChooser();
		// initialize dialog box
		JDialog dialog = new JDialog(this, true);
		
		// initialize textArea
		JTextArea textArea = new JTextArea(25,20);
        textArea.setMargin(new Insets(5,5,5,5));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
		
		// Set up menu items
        // OPEN FILE MENU ITEM
        JMenuItem openFile = new JMenuItem("Open File");
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// open dialog box
				int returnVal = fc.showOpenDialog(StudentGUI.this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
										
					try {
						// attempt to read file
						students = StudentReader.readStudents(file.getName());
						
						// clear text area
						textArea.setText("");
						
						// print students
						for (Student student : students) {
							textArea.append(student.toString() + "\n");
						}
						
						// set cursor position
						textArea.setCaretPosition(textArea.getDocument().getLength());
					} catch (ClassNotFoundException exception) {
						System.out.println("There was an issue with reading the file");
						exception.printStackTrace();
					} catch (IOException exception) {
						System.out.println("Couldn't read file: " + file.getName());
						exception.printStackTrace();
					}
				} 
			}
		});
		
		// SAVE FILE MENU ITEM
		JMenuItem saveFile = new JMenuItem("Save File");
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// open dialog box
				int returnVal = fc.showSaveDialog(StudentGUI.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					
					try {
						StudentWriter.writeStudents(students, file.getName());
						JOptionPane.showMessageDialog(dialog, "The file was saved!");
						
					} catch (IOException exception) {
						System.out.println("There was a problem saving to file: " + file.getName());
						exception.printStackTrace();
					}
					
				} 
			}
		});
		
		// ADD STUDENT MENU ITEM
		JMenuItem addStudent = new JMenuItem("Add Student");
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentGUI.newStudent();
								
				if (addStudentGUI.getStudent() != null) {
					students.add(addStudentGUI.getStudent());
					textArea.append(addStudentGUI.getStudent().toString() + "\n");
					addStudentGUI.clearStudent();
				}
			}
		});
		
		// CLEAR STUDENTS MENU ITEM
		JMenuItem clearStudents = new JMenuItem("Clear Students");
		clearStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.setCaretPosition(textArea.getDocument().getLength());
				students.clear();
			}
		});
		
		// Make menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		editMenu.add(addStudent);
		editMenu.add(clearStudents);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		
		// main panel to contain the content
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		
		// add everything to frame
		setJMenuBar(menuBar);
		add(mainPanel);
		
		// set up frame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null); // center the window
				
		// intialize student array
		students = new ArrayList<Student>();
		
		// display screen 
		setVisible(true); 
	}
}	

