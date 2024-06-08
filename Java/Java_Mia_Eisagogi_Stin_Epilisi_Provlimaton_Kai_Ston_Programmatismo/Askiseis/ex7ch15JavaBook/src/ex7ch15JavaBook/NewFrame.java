/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java gui exercises
 */

package ex7ch15JavaBook;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class NewFrame extends JFrame implements WindowListener
{
	private MyFrame myWindow = null;
	
	public NewFrame(MyFrame aFrame, String aMessage)
	{
		this.myWindow = aFrame;
		
		this.addWindowListener(this);
		
		this.setVisible(true);
		this.setTitle(aMessage);
		this.setSize(300, 300);
	}

	
	//i want to use only the windowclosing method and this is why i leave all the other method bodies empty
	
	@Override
	public void windowOpened(WindowEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) 
	{
		myWindow.setTextAreaMessage(getTitle());
		this.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
