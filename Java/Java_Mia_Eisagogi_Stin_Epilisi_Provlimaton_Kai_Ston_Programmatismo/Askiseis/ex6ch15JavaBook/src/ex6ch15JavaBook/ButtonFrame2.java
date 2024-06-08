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

public class ButtonFrame2 extends JFrame
{
	private JPanel panel = new JPanel();
	
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	
	public ButtonFrame2()
	{
		ButtonListener3 listener = new ButtonListener3();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		
		panel.add(button1);
		panel.add(button2);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(300, 300);
		this.setTitle("A random title");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class ButtonListener3 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("1"))
				panel.setBackground(Color.BLACK);
			else
				panel.setBackground(Color.WHITE);
			
		}
		
	}
}
