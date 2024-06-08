import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Comparable<Hotel>, Serializable
{
	private String name;
	private ArrayList<Reservation> reservations = new ArrayList<>();
	
	
	public Hotel(String aName)
	{
		this.name = aName;
	}
	
	
	public void addReservation(Reservation aReserv)
	{
		reservations.add(aReserv);
		System.out.println("Reservation in hotel: " + name + " is added successfully!");
	}
	
	
	public double calculateTotalCost()
	{
		double total = 0;
		
		for(Reservation r : reservations)
			total += r.calculateCost();
		
		return total;
	}
	
	
	public String getName()
	{
		return name;
	}


	@Override
	public int compareTo(Hotel o)
	{
		return this.getName().compareTo(o.getName());
	}
}
