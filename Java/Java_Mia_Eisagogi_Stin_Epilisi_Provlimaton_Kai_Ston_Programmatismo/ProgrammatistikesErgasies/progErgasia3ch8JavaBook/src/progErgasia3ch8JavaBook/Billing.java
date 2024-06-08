/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

package progErgasia3ch8JavaBook;

public class Billing 
{
	private Patient myPatient;
	private Doctor myDoctor;
	
	public Billing(Patient aPatient, Doctor aDoctor)
	{
		myPatient = aPatient;
		myDoctor = aDoctor;
	}
	
	
	public boolean equals(Doctor aDoctor)
	{
		return myDoctor == aDoctor;
	}
	
	
	public boolean equals(Patient aPatient)
	{
		return myPatient == aPatient;
	}


	public Patient getMyPatient() {
		return myPatient;
	}


	public void setMyPatient(Patient myPatient) {
		this.myPatient = myPatient;
	}


	public Doctor getMyDoctor() 
	{
		return myDoctor;
	}


	public void setMyDoctor(Doctor myDoctor) 
	{
		this.myDoctor = myDoctor;
	}
	
	
	
}
