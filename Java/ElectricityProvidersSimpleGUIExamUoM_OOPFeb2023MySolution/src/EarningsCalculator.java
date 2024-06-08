/*
 * Author: Thanos Moschou
 * Date: 02/2023
 * Description: Exams
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EarningsCalculator extends JFrame implements ActionListener {
	
	private ArrayList<Provider> providers;
	
	private JPanel panel = new JPanel();
	private JList<String> providersList = new JList<>();
	private DefaultListModel<String> providerModel = new DefaultListModel<>();
	
	private JButton earningsButton = new JButton("Calculate Provider Earnings");
	
	private JTextField earningTextField = new JTextField("calculated earnings");
	
	
	public EarningsCalculator(ArrayList<Provider> someProv) {
		
		providers = someProv;
		
		for(Provider p : providers)
			providerModel.addElement(p.getName());
		
		providersList.setModel(providerModel);
		
		earningsButton.addActionListener(this);
		
		panel.add(providersList);
		panel.add(earningsButton);
		panel.add(earningTextField);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Earnings Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String providersName = providersList.getSelectedValue();
		Provider selectedProvider = null;
		
		for(Provider p : providers)
		{
			if(p.getName().equals(providersName))
			{
				selectedProvider = p;
				break;
			}
		}
		
		if(selectedProvider != null)
			earningTextField.setText(Double.toString(selectedProvider.calculateProfit()));
		
	}
	
}
