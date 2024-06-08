/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: gui with java
 */

package ex13ch15JavaBook;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class IceCreamFrame extends JFrame implements ActionListener
{
	private JPanel panel = new JPanel();
	
	private JMenu choices = new JMenu("Choices");
	private JMenu flavour = new JMenu("Flavour");
	private JMenu toppings = new JMenu("Toppings");
	private JMenu syrup = new JMenu("Syrup");
	private JMenu actions = new JMenu("Actions");
	
	private JMenuItem chocolate = new JMenuItem("Chocolate");
	private JMenuItem strawberry = new JMenuItem("Strawberry");
	private JMenuItem vanilla = new JMenuItem("Vanilla");
	
	private JMenuItem chocChips = new JMenuItem("Chocolate Chips");
	private JMenuItem sprinkles = new JMenuItem("Sprinkles");
	private JMenuItem nuts = new JMenuItem("Nuts");
	private JMenuItem peppermint = new JMenuItem("Peppermint");
	
	private JMenuItem chocSyr = new JMenuItem("Chocolate Syrup");
	private JMenuItem butterscotch = new JMenuItem("Butterscotch");
	private JMenuItem berry = new JMenuItem("Berry");
	
	private JMenuItem clear = new JMenuItem("Clear");
	private JMenuItem quit = new JMenuItem("Quit");

	private JMenuBar iceCream = new JMenuBar();
	private JMenuBar act = new JMenuBar();
	
	private JLabel orderLabel = new JLabel("Your order: ");
	
	public IceCreamFrame()
	{
		choices.add(flavour);
		choices.add(toppings);
		choices.add(syrup);
		
		actions.add(clear);
		actions.add(quit);
		
		flavour.add(chocolate);
		flavour.add(strawberry);
		flavour.add(vanilla);
		
		toppings.add(chocChips);
		toppings.add(sprinkles);
		toppings.add(nuts);
		toppings.add(peppermint);
		
		syrup.add(chocSyr);
		syrup.add(butterscotch);
		syrup.add(berry);
		
		iceCream.add(choices);
		act.add(actions);

		panel.add(iceCream);
		panel.add(act);
		panel.add(orderLabel);
		panel.setBackground(Color.CYAN);
		
		chocolate.addActionListener(this);
		strawberry.addActionListener(this);
		vanilla.addActionListener(this);
		chocChips.addActionListener(this);
		sprinkles.addActionListener(this);
		nuts.addActionListener(this);
		peppermint.addActionListener(this);
		chocSyr.addActionListener(this);
		butterscotch.addActionListener(this);
		berry.addActionListener(this);
		clear.addActionListener(this);
		quit.addActionListener(this);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Let\'s order!");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Chocolate"))
			orderLabel.setText(orderLabel.getText() + " Chocolate");
		else if(e.getActionCommand().equals("Strawberry"))
			orderLabel.setText(orderLabel.getText() + " Strawberry");
		else if(e.getActionCommand().equals("Vanilla"))
			orderLabel.setText(orderLabel.getText() + " Vanilla");
		else if(e.getActionCommand().equals("Chocolate Chips"))
			orderLabel.setText(orderLabel.getText() + " Chocolate Chips");
		else if(e.getActionCommand().equals("Sprinkles"))
			orderLabel.setText(orderLabel.getText() + " Sprinkles");
		else if(e.getActionCommand().equals("Nuts"))
			orderLabel.setText(orderLabel.getText() + " Nuts");
		else if(e.getActionCommand().equals("Peppermint"))
			orderLabel.setText(orderLabel.getText() + " Peppermint");
		else if(e.getActionCommand().equals("Chocolate Syrup"))
			orderLabel.setText(orderLabel.getText() + " Chocolate Syrup");
		else if(e.getActionCommand().equals("Butterscotch"))
			orderLabel.setText(orderLabel.getText() + " Butterscotch");
		else if(e.getActionCommand().equals("Berry"))
			orderLabel.setText(orderLabel.getText() + " Berry");
		else if(e.getActionCommand().equals("Clear"))
			orderLabel.setText("Your order: ");
		else if(e.getActionCommand().equals("Quit"))
			System.exit(0);
	}
}
