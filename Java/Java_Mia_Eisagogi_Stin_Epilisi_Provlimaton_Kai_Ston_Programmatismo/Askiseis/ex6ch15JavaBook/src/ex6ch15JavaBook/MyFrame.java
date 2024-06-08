/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java gui
 */

package ex6ch15JavaBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame
{
	//1. Create the panel 
	private JPanel myPanel = new JPanel();
	
	//2. Create the components
	private JButton button1 = new JButton("Click me");
	private JButton button2 = new JButton("No click me");
	
	public MyFrame()
	{
		//3. Add action listeners to the buttons
		ButtonListener listener = new ButtonListener();
		
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		
		//4. add the components to the panel
		myPanel.add(button1);
		myPanel.add(button2);
		
		//5. add the panel to the window
		this.setContentPane(myPanel);
		
		//6. make some settings to the window
		this.setVisible(true);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("A random title");
	
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Click me"))
				new ButtonFrame1();
			else
				new ButtonFrame2();		
		}
		
	}
}
