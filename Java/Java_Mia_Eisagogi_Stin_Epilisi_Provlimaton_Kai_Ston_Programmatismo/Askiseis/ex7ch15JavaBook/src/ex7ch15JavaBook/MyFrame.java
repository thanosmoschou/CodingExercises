/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java gui exercises
 */

package ex7ch15JavaBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener
{
	//1 create the panel
	private JPanel myPanel = new JPanel();
	
	//2 create the components
	private JTextField textField = new JTextField("Enter something here", 20);
	private JTextArea textArea = new JTextArea("Some message will be included here", 5, 40);
	private JButton button = new JButton("Click me");
	
	public MyFrame()
	{
		//3 add action listeners to the buttons
		button.addActionListener(this);
		
		//4 add the components to the panel
		myPanel.add(textField);
		myPanel.add(textArea);
		myPanel.add(button);
		
		//5 add the panel to the window
		this.setContentPane(myPanel);
		
		//6 make the settings to the window
		this.setVisible(true);
		this.setSize(600, 300);
		this.setTitle("A random title");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public String getTextFieldMessage() 
	{
		return textField.getText();
	}


	public void setTextAreaMessage(String aMessage) 
	{
		textArea.setText(aMessage);
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new NewFrame(this, getTextFieldMessage());	
	}
		
}
