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

public class MyFrame extends JFrame
{
	private ArrayList<Ship> ships = null;
	
	//1. Create the panel
	private JPanel panel = new JPanel();
	
	//2. Create the components
	private JButton calcChargBut = new JButton("Calculate Charge");
	private JButton createContainerBut = new JButton("Create Container");
	private JList<String> list = new JList<>();
	
	public MyFrame(ArrayList<Ship> someShips)
	{
		this.ships = someShips;
		DefaultListModel<String> aModel = new DefaultListModel<>();
		
		for(Ship s : ships)
			aModel.addElement(s.getName());
			
		
		list.setModel(aModel);
		
		//3. Add button listener to the buttons
		ButtonListener listener = new ButtonListener();
		calcChargBut.addActionListener(listener);
		createContainerBut.addActionListener(listener);
		
		//4. Add the components to the panel
		panel.add(list);
		panel.add(calcChargBut);
		panel.add(createContainerBut);
	
		
		//5. Add the panel to the window
		this.setContentPane(panel);
		
		//6. Make some settings to the window
		this.setVisible(true);
		this.setTitle("A random title");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Calculate Charge"))
			{
				String shipName = list.getSelectedValue();
				Ship selectedShip = null;
				
				for(Ship s : ships)
				{
					if(s.getName().equals(shipName))
					{
						selectedShip = s;
						break;
					}
				}
				
				System.out.println("Total charge: " + selectedShip.calculateTotalCharge());
			}
			else
			{
				new MyFrame2(ships);
			}
		}
		
	}
}
