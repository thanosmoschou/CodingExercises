/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: gui with java
 */

package ex10ch15JavaBook;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyFrame extends JFrame
{
	int totalVal = 0, sumOfVal = 0, average = 0;
	
	private JPanel panel = new JPanel();
	
	private JLabel label = new JLabel("Total values: " + totalVal + " Sum: " + sumOfVal + " Average: " + average);
	
	//when i create a text area and then make a scroll pane passing to the constructor the text area
	//i have to add to the panel the scrollpane and not the text area. But when i want to add something to 
	//the text area i use the textArea attribute and not the jsrollpane
	
	private JTextArea textArea = new JTextArea("Some values.", 5, 30);
	private JScrollPane scroll = new JScrollPane(textArea);
	
	public MyFrame()
	{
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.add(label);
		panel.add(scroll);
		
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Display");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new MyFrame2(this);
	}

	
	public void updateLabel()
	{
		label.setText("Total values: " + totalVal + " Sum: " + sumOfVal + " Average: " + average);
	}
	
	public void updateTextArea(String aValue)
	{
		textArea.setText(textArea.getText() + System.lineSeparator() + aValue);
	}
	
	public int getTotalVal() 
	{
		return totalVal;
	}

	public void setTotalVal(int totalVal)
	{
		this.totalVal = totalVal;
	}

	public int getSumOfVal() 
	{
		return sumOfVal;
	}

	public void setSumOfVal(int sumOfVal)
	{
		this.sumOfVal = sumOfVal;
	}

	public int getAverage() 
	{
		return average;
	}

	public void setAverage(int average) 
	{
		this.average = average;
	}

	
}
