/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java gui
 */

package ex6ch15JavaBook;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame1 extends JFrame
{
	//i have the steps of creating gui in MyFrame.java
	private JPanel panel = new JPanel();
	
	private JButton button = new JButton("Click");
	
	public ButtonFrame1()
	{
		button.addActionListener(new ButtonListener2());
		
		panel.setBackground(Color.RED);
		panel.add(button);
		
		this.setContentPane(panel);
			
		this.setVisible(true);
		this.setTitle("Window");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class ButtonListener2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(panel.getBackground().equals(Color.RED))
				panel.setBackground(Color.GREEN);
			else
				panel.setBackground(Color.RED);	
		}
		
	}
}
