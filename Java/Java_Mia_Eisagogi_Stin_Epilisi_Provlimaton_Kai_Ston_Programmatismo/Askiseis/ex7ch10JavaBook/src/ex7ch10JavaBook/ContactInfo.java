/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: file handling in java
 */

package ex7ch10JavaBook;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactInfo
{
	private String name;
	private String workPhoneNumber;
	private String homePhoneNumber;
	private String cellphoneNumber;
	private String email;
	private String homeAddress;
	
	public ContactInfo(String aString) throws InvalidFormatException
	{
		//assume that string has data with the following format:
		//name workPhoneNumber homePhoneNumber cellphoneNumber email homeAddress
		String[] data = aString.split(" ");
		
		if(data.length != 6)
			throw new InvalidFormatException();
		
		this.name = data[0];
		this.workPhoneNumber = data[1];
		this.homePhoneNumber = data[2];
		this.cellphoneNumber = data[3];
		this.email = data[4];
		this.homeAddress = data[5];
	}
	
	
	public String toString()
	{
		if(name == null)
			this.name = "Name not given";
		
		if(workPhoneNumber == null)
			this.workPhoneNumber = "Not work phone number given";
		
		if(homePhoneNumber == null)
			this.homePhoneNumber = "Not home number given";
		
		if(cellphoneNumber == null)
			this.cellphoneNumber = "Not cell phone number given";
		
		if(email == null)
			this.email = "Not email given";
		
		if(homeAddress == null)
			this.homeAddress = "Not home address given";
		
		
		return (name + "\n" + workPhoneNumber + "\n" + homePhoneNumber + "\n" + cellphoneNumber + "\n" + email + "\n" + homeAddress + "\n");
	}
	
	
	public void addThisPersonToArrayList(ArrayList<ContactInfo> people)
	{
		people.add(this);
		System.out.println("Insert is completed.\n");
	}
	
	
	public static void removeThisPersonToArrayList(ArrayList<ContactInfo> people, String aName)
	{
		//search the arraylist to find the object that the method is called from. If exists remove it
		for(ContactInfo c : people)
		{
			if(c.getName().equalsIgnoreCase(aName))
			{
				if(people.remove(c))
				{
					System.out.println("Object is removed\n");
					return;
				}
			}
		}
		
		//if we reach this point the value is not found
		System.out.println("This person is not in the list.\n");
	}

	
	public static void changeInfo(String aName, ArrayList<ContactInfo> people)
	{	
		ContactInfo anObject = null;
		Scanner in = new Scanner(System.in);
		int selection;
		
		//find the person with the given name
		for(ContactInfo c : people)
		{
			if(c.getName().equalsIgnoreCase(aName))
			{
				anObject = c;
				break;
			}
		}
		
		if(anObject == null)
		{
			System.out.println("Person not found...\n");
			return;
		}
		
		System.out.println("Please select what you want to change from this person:");
		System.out.println("1. Name");
		System.out.println("2. Work Phone Number.");
		System.out.println("3. Home Phone Number.");
		System.out.println("4. Cell Phone Number.");
		System.out.println("5. Email");
		System.out.println("6. Home Address");
		
		//valididy check
		while(true)
		{
			selection = in.nextInt();
			
			if(selection < 1 || selection > 6)
				System.out.println("Please enter valid data...\n");
			else
				break;
		}
		
		in.nextLine(); //clear the stream
		
		switch(selection)
		{
			case 1:
				String newName;
				System.out.println("Old Name: " + anObject.getName() + "\nEnter the new name: ");
				newName = in.nextLine();
				anObject.setName(newName);
				System.out.println("Name is changed successfully.\n");
				break;
			case 2:
				String newWorkPhone;
				System.out.println("Old Work Phone number: " + anObject.getWorkPhoneNumber() + "\nEnter the new work phone number: ");
				newWorkPhone = in.nextLine();
				anObject.setWorkPhoneNumber(newWorkPhone);
				System.out.println("Work phone number is changed successfully.\n");
				break;
			case 3:
				String newHomePhone;
				System.out.println("Old Home Phone number: " + anObject.getHomePhoneNumber() + "\nEnter the new home phone number: ");
				newHomePhone = in.nextLine();
				anObject.setHomePhoneNumber(newHomePhone);
				System.out.println("Home phone number is changed successfully.\n");
				break;
			case 4:
				String newCellPhone;
				System.out.println("Old Cell Phone number: " + anObject.getCellphoneNumber() + "\nEnter the new Cell phone number: ");
				newCellPhone = in.nextLine();
				anObject.setCellphoneNumber(newCellPhone);
				System.out.println("Cell phone number is changed successfully.\n");
				break;
			case 5:
				String newEmail;
				System.out.println("Old email: " + anObject.getEmail() + "\nEnter the new email: ");
				newEmail = in.nextLine();
				anObject.setEmail(newEmail);
				System.out.println("Email is changed successfully.\n");
				break;
			default:
				String newHomeAddress;
				System.out.println("Old Home Address " + anObject.getHomeAddress() + "\nEnter the new Home Address: ");
				newHomeAddress = in.nextLine();
				anObject.setHomeAddress(newHomeAddress);
				System.out.println("Home Address is changed successfully.\n");					
		}

	}

	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public String getWorkPhoneNumber() 
	{
		return workPhoneNumber;
	}


	public void setWorkPhoneNumber(String workPhoneNumber)
	{
		this.workPhoneNumber = workPhoneNumber;
	}


	public String getHomePhoneNumber() 
	{
		return homePhoneNumber;
	}


	public void setHomePhoneNumber(String homePhoneNumber) 
	{
		this.homePhoneNumber = homePhoneNumber;
	}


	public String getCellphoneNumber() 
	{
		return cellphoneNumber;
	}


	public void setCellphoneNumber(String cellphoneNumber) 
	{
		this.cellphoneNumber = cellphoneNumber;
	}


	public String getEmail() 
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}


	public String getHomeAddress() 
	{
		return homeAddress;
	}


	public void setHomeAddress(String homeAddress) 
	{
		this.homeAddress = homeAddress;
	}
}
