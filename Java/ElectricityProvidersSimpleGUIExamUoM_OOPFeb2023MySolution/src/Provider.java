/*
 * Author: Thanos Moschou
 * Date: 02/2023
 * Description: Exams
 */


import java.util.ArrayList;

public class Provider 
{
	private String name;
	private ArrayList<Subscriber> subscribers = new ArrayList<>();
	
	public Provider(String name) 
	{
		this.name = name;
	}

	
	public void addSubscriber(Subscriber aSub)
	{
		subscribers.add(aSub);
		System.out.println("Subscriber added successfully to the provider.");
	}
	
	
	public double calculateTotalNetEnergy()
	{
		double total = 0;
		
		for(Subscriber s : subscribers)
			total += s.calculateNetEnergy();
		
		return total;
	}
	
	
	public double calculateProfit()
	{
		double total = 0;
		ArrayList<String[]> dataFromFile = Main.readFile("EnergyPrices.txt");
		
		for(int i = 0; i < dataFromFile.size(); i++)
		{
			String[] data = dataFromFile.get(i);
			if(data[0].equals(this.name))
			{
				total = this.calculateTotalNetEnergy() * Double.parseDouble(data[1]);
				break;
			}
		}
		
		return total;
	}
	
	
	public String getName() 
	{
		return name;
	}
}
