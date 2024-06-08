/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: revision exercise in java
 */

package rev6;

public class Bulk extends Container
{
	private double weight;

	public Bulk(String code, String destination, double weight) 
	{
		super(code, destination);
		this.weight = weight;
	}

	
	@Override
	public double calculateCharge() 
	{
		return 10 * weight;
	}
	
	
	public double getWeight() 
	{
		return weight;
	}
	
}
