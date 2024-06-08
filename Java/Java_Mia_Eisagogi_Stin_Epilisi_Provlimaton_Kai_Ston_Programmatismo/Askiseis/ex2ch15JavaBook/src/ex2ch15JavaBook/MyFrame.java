/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Simulate a very simple machine where you can buy products. Part of exercises with gui in java
 */

package ex2ch15JavaBook;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame 
{
	private String price1 = "3.40";
	private String price2 = "3.90";
	private String price3 = "2.60";
	
	private int prod1TotalAmountSold = 0;
	private int prod2TotalAmountSold = 0;
	private int prod3TotalAmountSold = 0;
	
	private int currentSold1 = 0;
	private int currentSold2 = 0;
	private int currentSold3 = 0;
	
	private double totalCostAtThisPurchase = 0;

	//1. create the panel
	private JPanel myPanel = new JPanel(new GridLayout(5, 3));
	
	//2. create the components
	private ImageIcon prod1 = new ImageIcon("candy1.jpg");
	private ImageIcon prod2 = new ImageIcon("candy2.jpg");
	private ImageIcon prod3 = new ImageIcon("candy3.jpg");

	/*
	private JButton button1 = new JButton("Product 1");
	private JButton button2 = new JButton("Product 2");
	private JButton button3 = new JButton("Product 3");
	*/
	
	private JButton button1 = new JButton(prod1);
	private JButton button2 = new JButton(prod2);
	private JButton button3 = new JButton(prod3);
	
	private JButton endSaleButton = new JButton("End Sale");
	
	private JLabel prod1PriceLabel = new JLabel("Product price: " + price1);
	private JLabel prod2PriceLabel = new JLabel("Product price: " + price2);
	private JLabel prod3PriceLabel = new JLabel("Product price: " + price3);
	
	private JLabel prod1SoldAtCurrentTransactionLabel = new JLabel("Product 1 amount purchased: " + currentSold1);
	private JLabel prod2SoldAtCurrentTransactionLabel = new JLabel("Product 2 amount purchased: " + currentSold2);
	private JLabel prod3SoldAtCurrentTransactionLabel = new JLabel("Product 3 amount purchased: " + currentSold3);

	private JLabel prod1TotalSoldLabel = new JLabel("Total amount sold for product 1: " + prod1TotalAmountSold);
	private JLabel prod2TotalSoldLabel = new JLabel("Total amount sold for product 2: " + prod2TotalAmountSold);
	private JLabel prod3TotalSoldLabel = new JLabel("Total amount sold for product 3: " + prod3TotalAmountSold);
	
	private JLabel totalPriceLabel = new JLabel("Total Cost: " + totalCostAtThisPurchase);
	
	
	public MyFrame()
	{
		//when you create a button and at the constructor you assign an icon you need then to set the
		//action command for the button. 
		//You cannot put in the constructor both icon and text
		//if you want to have to the button both text and image you must add text to the 
		//constructor and use the setIcon method later. 
		//If you first assigned text to the constuctor you have the action command for event handling
		//but if you first assigned icon you then need to call the setActionCommand method to set action command
		
		button1.setActionCommand("Product 1");
		button2.setActionCommand("Product 2");
		button3.setActionCommand("Product 3");

		//3. add the components to the panel
		myPanel.add(prod1PriceLabel);
		myPanel.add(prod2PriceLabel);
		myPanel.add(prod3PriceLabel);
		myPanel.add(prod1SoldAtCurrentTransactionLabel);
		myPanel.add(prod2SoldAtCurrentTransactionLabel);
		myPanel.add(prod3SoldAtCurrentTransactionLabel);
		myPanel.add(prod1TotalSoldLabel);
		myPanel.add(prod2TotalSoldLabel);
		myPanel.add(prod3TotalSoldLabel);
		myPanel.add(button1);
		myPanel.add(button2);
		myPanel.add(button3);
		myPanel.add(endSaleButton);
		myPanel.add(totalPriceLabel);
		
		//4. add action listeners to the buttons
		ButtonListener buttonListener = new ButtonListener();
		
		button1.addActionListener(buttonListener);
		button2.addActionListener(buttonListener);
		button3.addActionListener(buttonListener);
		endSaleButton.addActionListener(buttonListener);


		//5. add the panel to the window
		this.setContentPane(myPanel);
		
		//6. make the settings for the window
		this.setVisible(true);
		this.setSize(600, 600);
		this.setTitle("Buy Your Stuff!!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getActionCommand().equals("Product 1"))
			{
				prod1TotalAmountSold++;
				currentSold1++;
				totalCostAtThisPurchase += (Double.parseDouble(price1));
			}
			else if(e.getActionCommand().equals("Product 2" ))
			{
				prod2TotalAmountSold++;
				currentSold2++;
				totalCostAtThisPurchase += (Double.parseDouble(price2));
			}
			else if(e.getActionCommand().equals("Product 3"))
			{
				prod3TotalAmountSold++;
				currentSold3++;
				totalCostAtThisPurchase += (Double.parseDouble(price3));
			}
			else
			{
				currentSold1 = 0;
				currentSold2 = 0;
				currentSold3 = 0;
				totalCostAtThisPurchase = 0;

			}
			
			//update all the labels
			prod1SoldAtCurrentTransactionLabel.setText("Product 1 amount purchased: " + currentSold1);
			prod2SoldAtCurrentTransactionLabel.setText("Product 2 amount purchased: " + currentSold2);
			prod3SoldAtCurrentTransactionLabel.setText("Product 3 amount purchased: " + currentSold3);

			prod1TotalSoldLabel.setText("Total amount sold for product 1: " + prod1TotalAmountSold);
			prod2TotalSoldLabel.setText("Total amount sold for product 2: " + prod2TotalAmountSold);
			prod3TotalSoldLabel.setText("Total amount sold for product 3: " + prod3TotalAmountSold);
			
			totalPriceLabel.setText("Total Cost: " + totalCostAtThisPurchase);
			
		}
		
	}
}
