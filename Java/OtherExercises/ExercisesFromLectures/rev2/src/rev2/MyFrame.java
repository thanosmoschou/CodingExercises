/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: second revision exercise. Contains university and students
 */

package rev2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame
{
	private ArrayList<Course> courses;
	
	//1. Create a panel 
	private JPanel panel = new JPanel();
	
	//2. Create the components
	private JTextField studentNameField = new JTextField("Enter the name of the student", 15);
	private JTextField courseNameField = new JTextField("Enter the course name", 10);
	private JButton enrollButton = new JButton("Enroll In");
	private JButton printCourseStudentsButton = new JButton("Print Course Students");
	
	public MyFrame(ArrayList<Course> someCourses)
	{
		this.courses = someCourses;
		
		//3. Add action listeners to the buttons
		ButtonListener listener = new ButtonListener();
		enrollButton.addActionListener(listener);
		printCourseStudentsButton.addActionListener(listener);
		
		//4. Add the components to the panel
		panel.add(studentNameField);
		panel.add(enrollButton);
		panel.add(courseNameField);
		panel.add(printCourseStudentsButton);
		
		//5. Add the panel to the window
		this.setContentPane(panel);
		
		//6. Make settings to the window
		this.setVisible(true);
		this.setTitle("Student Enrollment");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	class ButtonListener implements ActionListener
	{

		public Course findCourse(String courseName)
		{
			for(Course c : courses)
			{
				if(c.getName().equals(courseName))
					return c;
			}
			
			return null;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String studentName = studentNameField.getText();
			String courseName = courseNameField.getText();
			Course selectedCourse = findCourse(courseName);
			
			Student createdStudent = null;			
			
			if(e.getActionCommand().equals("Enroll In"))
			{			
				if(selectedCourse == null)
					System.out.println("Course not found");
				else
				{
					createdStudent = new Student(studentName, selectedCourse);
					System.out.println("Student created successfully");
				}
			}
			else
			{
				if(selectedCourse == null)
					System.out.println("Course not found");
				else
				{
					ArrayList<Student> students = selectedCourse.getEnrolled();
					
					System.out.println("Students enrolled in " + courseName + " are: ");
					for(Student s : students)
						s.printInfo();
				}
			}
			
		}
		
	}
}
