/*
 * Author: Thanos Moschou
 * Date: 02/2023
 * Description: Exams
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//---------Provider and subscribers-------------
		Provider newEnergy = new Provider("New Energy");
		Subscriber sub1 = new Subscriber("Papadopoulos", 9840);
		GreenSubscriber greenSub1 = new GreenSubscriber("Nikolaou", 10340, "Katerini");
		
		//---------Provider and subscribers-------------
		Provider powerTech = new Provider("Power Tech");
		Subscriber sub2 = new Subscriber("Hliadis", 10800);
		GreenSubscriber greenSub2 = new GreenSubscriber("Georgiou", 9730, "Thessaloniki");
		
		//---------Provider and subscribers-------------
		Provider greenAndClean = new Provider("Green and Clean");
		Subscriber sub3 = new Subscriber("Symeonidis", 11210);
		GreenSubscriber greenSub3 = new GreenSubscriber("Mitroudis", 7890, "Veroia");
		
		//---------ArrayList of Providers-------------
		ArrayList<Provider> providers = new ArrayList<>();
		providers.add(newEnergy);
		providers.add(powerTech);
		providers.add(greenAndClean);
		
		//---------Adding subscribers to providers-------------
		newEnergy.addSubscriber(sub1);
		newEnergy.addSubscriber(greenSub1);
		powerTech.addSubscriber(sub2);
		powerTech.addSubscriber(greenSub2);
		greenAndClean.addSubscriber(sub3);
		greenAndClean.addSubscriber(greenSub3);
		
		//---------Adding panels to greenSubscribers-------------
		SolarPanel panel1 = new SolarPanel("SunPower", 500);
		SolarPanel panel2 = new SolarPanel("SunPower", 500);
		SolarPanel panel3 = new SolarPanel("Panasonic", 550);
		SolarPanel panel4 = new SolarPanel("Panasonic", 550);
		SolarPanel panel5 = new SolarPanel("RECSolar", 520);
		SolarPanel panel6 = new SolarPanel("RECSolar", 520);

		greenSub1.addPanel(panel1);
		greenSub1.addPanel(panel2);
		greenSub2.addPanel(panel3);
		greenSub2.addPanel(panel4);
		greenSub3.addPanel(panel5);
		greenSub3.addPanel(panel6);
		
		//--------Calculate earnings for each company-------------
		for(Provider p : providers)
			System.out.println(p.getName() + ", Earnings: " + p.calculateProfit());
	
		EarningsCalculator frame = new EarningsCalculator(providers);
	}

	public static ArrayList<String[]> readFile(String fileName) {
		
		ArrayList<String[]> results = new ArrayList<String[]>();

		try {
			FileReader fileIn = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fileIn);
			
			String line;

			while( (line = in.readLine()) != null) {
				String[] parts = line.split(",");
				results.add(parts);
			}
		
			in.close();
			fileIn.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		
		return results;		
	}

}
