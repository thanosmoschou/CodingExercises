/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

public class Truck extends Vehicle
{
	private double ofelimoFortio;
	private double dinatotitaRymoulkisis;
	
	public Truck(String aCompany, int someCylinders, Person anOwner, double enaOfelimo, double rimoulk)
	{
		super(aCompany, someCylinders, anOwner);
		this.ofelimoFortio = enaOfelimo;
		this.dinatotitaRymoulkisis = rimoulk;	
	}

	public double getOfelimoFortio()
	{
		return ofelimoFortio;
	}

	public void setOfelimoFortio(double ofelimoFortio)
	{
		this.ofelimoFortio = ofelimoFortio;
	}

	public double getDinatotitaRymoulkisis()
	{
		return dinatotitaRymoulkisis;
	}

	public void setDinatotitaRymoulkisis(double dinatotitaRymoulkisis) 
	{
		this.dinatotitaRymoulkisis = dinatotitaRymoulkisis;
	}
	
	public boolean equals(Vehicle p2)
	{
		//check if the vehicles have the same owner
		return this.getOwner().getName().equalsIgnoreCase(p2.getOwner().getName());
	}
	
}
