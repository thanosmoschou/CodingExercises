/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: revision exercise in java
 */

package rev6;

import java.util.ArrayList;

public class Ship 
{
	private ArrayList<Container> containers = new ArrayList<>();
	private int capacity;
	private String name;
	
	public Ship(int capacity, String aName)
	{
		this.capacity = capacity;
		this.name = aName;
	}

	
	public void addContainer(Container aContainer)
	{
		if(containers.size() < capacity)
		{
			containers.add(aContainer);
			System.out.println("Container added successfylly.");
		}
		else
			System.out.println("Sorry the ship is full.");
	}
	
	
	public double calculateTotalCharge()
	{
		double total = 0;
		
		for(Container c : containers)
			total += c.calculateCharge();
		
		return total;
	}
	
	
	public ArrayList<Container> getContainers()
	{
		return containers;
	}

	
	public int getCapacity()
	{
		return capacity;
	}
	
	
	public String getName()
	{
		return name;
	}
	
}
