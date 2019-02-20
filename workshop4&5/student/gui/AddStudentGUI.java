package student.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import student.*;

public class AddStudentGUI extends JDialog {
	private JTextField[] basicFields = { new JTextField(10), new JTextField(10), new JTextField(10) };
	private JPanel coursePanel = new JPanel();
	private ArrayList<JTextField> courseFields = new ArrayList<JTextField>();
	private Student student;
	private Frame parent;
	
	public AddStudentGUI(Frame parent) {
		super(parent, true);
		
		// the parent frame
		this.parent = parent;
		
		// initialize student
		student = null;
		
		// set up top panel
		String[] labels = { "Student ID:", "First Name:", "Last Name:" };
				
		// set up grid layout
		GridLayout topLayout = new GridLayout(0, 2, 5, 5);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(topLayout);
		
		// add labels and fields to panel
		for (int i = 0; i < 3; ++i) {
			topPanel.add(new JLabel(labels[i]), BorderLayout.CENTER);
			topPanel.add(basicFields[i], BorderLayout.WEST);
		}
		
		// wrap topPanel to make nice borders
		JPanel topWrapperPanel = new JPanel();
		topWrapperPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));
		topWrapperPanel.add(topPanel);
		
		// set up courses panel
		GridLayout courseLayout = new GridLayout(0, 1, 5, 5);
		coursePanel.setLayout(courseLayout);
		
		// set up array for courses fields
		courseFields.add(new JTextField(20));
		coursePanel.add(courseFields.get(0));
		
		// wrap coursePanel
		JPanel courseWrapperPanel = new JPanel();
		courseWrapperPanel.setBorder(BorderFactory.createTitledBorder("Courses: "));
		courseWrapperPanel.add(coursePanel);
		
		// add button to add additional courses
		JPanel courseButtonPanel = new JPanel();
		JButton addCourse = new JButton("Add Course");
		courseButtonPanel.add(addCourse);
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseFields.add(new JTextField(20));
				coursePanel.add(courseFields.get(courseFields.size() - 1));
				coursePanel.revalidate();
				coursePanel.repaint();
				AddStudentGUI.this.pack();
				courseFields.get(courseFields.size() - 1).requestFocus();
			}
		});
		
		// add okay / cancel buttons at the bottom
		JPanel btnPanel = new JPanel();
		JButton okayBtn = new JButton("OK");
		okayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Add verification
				try {
					student.setStdID(Integer.parseInt(basicFields[0].getText()));
					if (student.getStdID() <= 0) {
						JDialog dialog = new JDialog(AddStudentGUI.this, true);
						JOptionPane.showMessageDialog(dialog, "Student ID must be greater than zero!");
						return;
					}
					student.setFirstName(basicFields[1].getText());
					student.setLastName(basicFields[2].getText());
					
					ArrayList<String> courses = new ArrayList<String>();
					for (JTextField courseField : courseFields) {
						courses.add(courseField.getText());
					}
					student.setCourses(courses);
					
					clearAndClose();
				} catch (NumberFormatException e1) {
					JDialog dialog = new JDialog(AddStudentGUI.this, true);
					JOptionPane.showMessageDialog(dialog, "Student ID is not a number!");
				}
			}
		});
		btnPanel.add(okayBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearStudent();
				clearAndClose();
			}
		});
		btnPanel.add(cancelBtn);
		
		// set up dialog
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		add(topWrapperPanel, BorderLayout.PAGE_START);
		add(courseWrapperPanel, BorderLayout.CENTER);
		add(courseButtonPanel, BorderLayout.LINE_END);
		add(btnPanel, BorderLayout.PAGE_END);
		pack();
	}
	
	// creates a new student object and opens the dialog box to add a new student
	public void newStudent() {
		student = new Student();
		setLocationRelativeTo(parent);
		setVisible(true);
	}
	
	// student getter
	public Student getStudent() {
		return student;
	}
	
	public void clearStudent() {
		student = null;
	}

	public void clearAndClose() {
		setVisible(false);
		
		// reset text fields
		for (int i = 0; i < 3; ++i) {
			basicFields[i].setText("");
		}
		
		// reset course panel fields
		coursePanel.removeAll();
		courseFields.clear();
		courseFields.add(new JTextField(20));
		coursePanel.add(courseFields.get(0));
		coursePanel.revalidate();
		coursePanel.repaint();
		pack();
	}
}
