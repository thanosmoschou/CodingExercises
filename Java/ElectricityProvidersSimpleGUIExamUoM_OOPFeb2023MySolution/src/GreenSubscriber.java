import java.util.ArrayList;

/*
 * Author: Thanos Moschou
 * Date: 02/2023
 * Description: Exams
 */


public class GreenSubscriber extends Subscriber 
{
	private ArrayList<SolarPanel> panels = new ArrayList<>();
	private String location;
	
	
	public GreenSubscriber(String name, double hours, String location)
	{
		super(name, hours);
		this.location = location;
	}

	
	public void addPanel(SolarPanel aPanel)
	{
		panels.add(aPanel);
		System.out.println("Panel added successfully to the green subscriber");
	}
	

	public double calculateNetEnergy()
	{
		double panelEnergy = 0;
		
		for(SolarPanel s : panels)
			panelEnergy += s.getYearConsumption();
		
		return super.calculateNetEnergy() - panelEnergy;
	}
	
	
	public String getLocation()
	{
		return this.location;
	}
	
}
