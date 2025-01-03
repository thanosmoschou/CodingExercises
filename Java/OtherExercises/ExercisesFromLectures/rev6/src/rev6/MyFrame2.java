/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: revision exercise in java
 */

package rev6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame
{
	private ArrayList<Ship> ships = null;
	
	private JPanel panel = new JPanel();
	
	private JTextField codeField = new JTextField("Add the code of the container");
	private JTextField destinationField = new JTextField("Add the destination of the container");
	private JTextField weightField = new JTextField("Add the weight of the container");
	private JTextField powerField = new JTextField("Add the power of the refridgerator here");
	private JButton createBulkButton = new JButton("Create Bulk");
	private JButton createRefridgerator = new JButton("Create Refridgerator");
	private JList<String> shipList = new JList<>();

	
	public MyFrame2(ArrayList<Ship> someShips)
	{
		this.ships = someShips;
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		for(Ship s : ships)
			model.addElement(s.getName());
		
		shipList.setModel(model);
		
		ButtonListener listener = new ButtonListener();
		createBulkButton.addActionListener(listener);
		createRefridgerator.addActionListener(listener);
		
		panel.add(shipList);
		panel.add(codeField);
		panel.add(destinationField);
		panel.add(weightField);
		panel.add(powerField);
		panel.add(createBulkButton);
		panel.add(createRefridgerator);
		
		this.setContentPane(panel);
		
		
		this.setVisible(true);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String shipName = shipList.getSelectedValue();
			String code = codeField.getText();
			String destination = destinationField.getText();
			Container createdCont = null;
			Ship selectedShip = null;
			
			for(Ship s : ships)
			{
				if(s.getName().equals(shipName))
				{
					selectedShip = s;
					break;
				}
			}
			
			
			if(e.getActionCommand().equals("Create Bulk"))
			{
				String weightAsAText = weightField.getText();
				double weight = Double.parseDouble(weightAsAText);
				
				createdCont = new Bulk(code, destination, weight);
			}
			else
			{
				String powerAsAText = powerField.getText();
				double power = Double.parseDouble(powerAsAText);
				
				createdCont = new Refridgerator(code, destination, power);
			}
			
			if(selectedShip != null)
			{
				selectedShip.addContainer(createdCont);
				System.out.println("Total charge for ship: " + shipName + " " + selectedShip.calculateTotalCharge());
			}
			
		}
		
	}
	
	
}
