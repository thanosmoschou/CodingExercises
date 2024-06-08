/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: GUI exercises
 */

package ex1ch15JavaBook;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class MyFrame extends JFrame
{
	private int myNumber;
	
	//1. Create my panel
	private JPanel panel = new JPanel();
	
	//2. Create the components
	private JTextArea area = new JTextArea("Please enter your message here", 4, 30);
	private JScrollPane scroll = new JScrollPane(area);
	private JButton numberButton = new JButton("New Number");
	private JButton newLineButton = new JButton("New Line");
	
	
	public MyFrame()
	{
		
		myNumber = 0;
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBorder(new EtchedBorder(Color.BLUE, Color.CYAN));
		
		//3. add the components to the panel
		panel.add(scroll);
		panel.add(newLineButton);
		panel.add(numberButton);
		
		
		//4. add action listener to the buttons.
		ButtonListener buttonListener = new ButtonListener();
		
		newLineButton.addActionListener(buttonListener);
		numberButton.addActionListener(buttonListener);
		
		//5 .add the panel to the window
		this.setContentPane(panel);
		
		//6. Do the necessary things for the window
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("My Frame" );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("New Number"))
			{
				myNumber++;
				area.setText(Integer.toString(myNumber));
			}
			else
			{
				String currentText = area.getText();
				currentText += "\n";
				
				area.setText(currentText);
			}	
		}
	}
	
}
