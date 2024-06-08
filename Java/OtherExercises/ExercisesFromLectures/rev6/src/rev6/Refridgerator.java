/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: revision exercise in java
 */

package rev6;

public class Refridgerator extends Container
{
	private double power;

	public Refridgerator(String code, String destination, double power) 
	{
		super(code, destination);
		this.power = power;
	}

	
	@Override
	public double calculateCharge() 
	{
		return 2000 * power;
	}

	
	public double getPower() 
	{
		return power;
	}
	
	
}
