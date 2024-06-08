/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: gui with java
 */

package ex10ch15JavaBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame2 extends JFrame implements ActionListener
{
	private MyFrame otherFrame = null;
	
	private JPanel panel = new JPanel();
	
	private JTextArea textArea = new JTextArea("Enter values here", 3, 30);
	private JButton enterButton = new JButton("Enter");
	
	public MyFrame2(MyFrame aFrame)
	{
		otherFrame = aFrame;
		
		enterButton.addActionListener(this);
		
		panel.add(textArea);
		panel.add(enterButton);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Data Entry");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String input = textArea.getText();
		
		otherFrame.updateTextArea(input);
		
		int total, average, sum, current;
		
		current = Integer.parseInt(input);
		total = otherFrame.getTotalVal();
		average = otherFrame.getAverage();
		sum = otherFrame.getSumOfVal();
		
		total++;
		sum += current;
		average = sum / total;
		
		otherFrame.setTotalVal(total);
		otherFrame.setAverage(average);
		otherFrame.setSumOfVal(sum);
		
		otherFrame.updateLabel();
		
	}

}
