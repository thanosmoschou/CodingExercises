/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Login page and some text fields for each user. GUI with Java
 */

package ex5ch15JavaBook;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginPageFrame extends JFrame implements ActionListener
{
	private CardLayout switchPage = new CardLayout();
	private JPanel myPanel = new JPanel(switchPage);
	private JPanel loginPanel = new JPanel();
	
	//private JLabel welcomeLabel = new JLabel("WELCOME TO THE APP!");
	
	private JLabel usernamePromptLabel = new JLabel("Enter your name here");
	private JTextField usernameField = new JTextField(30);
	
	private JLabel passwordPromptLabel = new JLabel("Enter your password here");
	private JPasswordField passwordField = new JPasswordField(30);
	
	private JButton loginButton = new JButton("Login!");
	private JLabel informMessageLabel = new JLabel(); //only when credentials are wrong
	
	//all the objects of the components from the user pages..i put them here because i want to handle the events later
	private JPanel bobPagePanel = new JPanel();
	private JLabel titleLabelForBob = new JLabel("Welcome BOB!!");
	private JTextField fieldOfBobPage = new JTextField("Type anything and press the Copy Button to copy it to the text area", 40);
	private JTextArea areaOfBobPage = new JTextArea("Message will be copied here!", 5, 40);
	private JButton copyButton = new JButton("Copy");
	
	private JPanel fredPagePanel = new JPanel();
	private JLabel titleLabelForFred = new JLabel("Welcome FRED!!");
	private JButton changeToGreenButton = new JButton("Green");
	private JButton changeToRedButton = new JButton("Red");
			
	private JButton returnToLoginPageButton = new JButton("Return to Login Page");


	public LoginPageFrame()
	{		
		//listener for the login button
		//ButtonListener myListener = new ButtonListener();
		loginButton.addActionListener(this);
		
		//add the components to the panels
		//loginPanel.add(welcomeLabel);
		loginPanel.add(usernamePromptLabel);
		loginPanel.add(usernameField);
		loginPanel.add(passwordPromptLabel);
		loginPanel.add(passwordField);
		loginPanel.add(loginButton);
		loginPanel.add(informMessageLabel);
		
		loginPanel.setBackground(Color.PINK);
		loginPanel.add(new JLabel(new ImageIcon("insta.png")));
		
		myPanel.add("start", loginPanel);
		
		this.setContentPane(myPanel);
		
		this.setVisible(true);
		this.setTitle("WELCOME TO THE APP");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public String toString(char[] input)
	{
		String returnMessage = "";
		
		for(char c : input)
			returnMessage += c;
		
		return returnMessage;
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getActionCommand().equals("Login!"))
		{
			String username = usernameField.getText();
			
			char[] retPassword = passwordField.getPassword(); 
			String password = toString(retPassword);
			
			if(username.equals("Bob") && password.equals("mubby"))
			{
				String inform = ""; //i want to disappear the Wrong Credentials message from my login page because the login is successful
				informMessageLabel.setText(inform);
				
				//add the components to bob page
				copyButton.addActionListener(this);
				returnToLoginPageButton.addActionListener(this);
				
				bobPagePanel.add(titleLabelForBob);
				bobPagePanel.add(fieldOfBobPage);
				bobPagePanel.add(areaOfBobPage);
				bobPagePanel.add(copyButton);
				bobPagePanel.add(returnToLoginPageButton);
				
				bobPagePanel.setBackground(Color.cyan);
				
				myPanel.add("bob", bobPagePanel);
				switchPage.show(myPanel, "bob");
				
			}
			else if(username.equals("Fred") && password.equals("goolag"))
			{
				String inform = "";
				informMessageLabel.setText(inform);
				
				//add the components to fred page
				changeToGreenButton.addActionListener(this);;
				changeToRedButton.addActionListener(this);
				
				fredPagePanel.add(changeToGreenButton);
				fredPagePanel.add(changeToRedButton);
				fredPagePanel.add(returnToLoginPageButton);
				
				myPanel.add("fred", fredPagePanel);
				switchPage.show(myPanel, "fred");
			}
			else
			{
				String inform = "Wrong Credentials";
				informMessageLabel.setText(inform);
			}
				
		}
		
		
		//handle the events of the buttons from each user page
		if(e.getActionCommand().equals("Copy"))
		{
			String textFromField = fieldOfBobPage.getText();
			areaOfBobPage.setText(textFromField);
		}
		
		
		if(e.getActionCommand().equals("Green"))
			fredPagePanel.setBackground(Color.GREEN);
		else if(e.getActionCommand().equals("Red"))
			fredPagePanel.setBackground(Color.RED);
		
		
		if(e.getActionCommand().equals("Return to Login Page"))
			switchPage.show(myPanel, "start");
		
	}
		
}
