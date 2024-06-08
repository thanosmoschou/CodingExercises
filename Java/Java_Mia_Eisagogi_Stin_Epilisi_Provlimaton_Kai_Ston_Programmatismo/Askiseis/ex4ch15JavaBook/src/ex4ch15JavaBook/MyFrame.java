/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: gui exercises
 */

package ex4ch15JavaBook;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame
{
	private int timesIconfied = 0;
	private JPanel myPanel = new JPanel();
	
	private JLabel myLabel = new JLabel("Times this window iconfied: " + timesIconfied);
	private JButton but1 = new JButton("This doesn\'t do anything");
	private JButton but2 = new JButton("This doesn\'t do anything");
	private JButton but3 = new JButton("This doesn\'t do anything");

	
	public MyFrame()
	{
		myPanel.add(but1);
		myPanel.add(but2);
		myPanel.add(but3);
		myPanel.add(myLabel);
		
		this.setContentPane(myPanel);
		this.addWindowListener(new WindowDestroyer()); //add a listener to my window
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("A random title");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	
	class WindowDestroyer extends WindowAdapter
	{
		
		public void windowActivated(WindowEvent e)
		{
			System.out.println("This window is activated.");
			myPanel.setBackground(Color.WHITE);
			validate();
		}
		
		public void windowDeactivated(WindowEvent e)
		{
			System.out.println("This window is deactivated.");
			myPanel.setBackground(Color.GRAY);
			validate();
		}
		
		
		public void windowIconified(WindowEvent e)
		{
			timesIconfied++;
			//System.out.println("Times this window iconfied: " + timesIconfied);
			myLabel.setText("Times this window iconfied: " + timesIconfied);
			validate();
		}
		
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
}
