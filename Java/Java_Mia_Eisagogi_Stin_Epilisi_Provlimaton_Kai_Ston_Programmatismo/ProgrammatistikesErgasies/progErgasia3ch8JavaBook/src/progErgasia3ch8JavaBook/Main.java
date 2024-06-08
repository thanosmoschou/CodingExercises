/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

package progErgasia3ch8JavaBook;

public class Main 
{
	public static void main(String[] args) 
	{
		Patient pat1 = new Patient("John Alex", "sfd2343");
		Patient pat2 = new Patient("Max Halland", "safks23");
		
		Doctor doc1 = new Doctor("Dr George Cut", "Gynaikologist", 40.5);
		Doctor doc2 = new Doctor("Dr Katherina White", "Pathologist", 35);
		
		Billing bil1 = new Billing(pat1, doc2);
		
		System.out.println("Is patient\'s 1 name the same as patient\'s 2? " + pat1.hasSameName(pat2));
		pat2.setId("daf2343");
		System.out.println("Patient 2 name: " + pat2.getName());
		System.out.println("Patient 1 id: " + pat1.getId());
		System.out.println("Doctor 1 name: " + doc1.getName());
		System.out.println("Doctor 2 type: " + doc2.getDoctorType());
		
		doc1.setDoctorType("Onychologist");
		System.out.println("Doctor 2 name: " + doc2.getName());
		System.out.println("Doctor 1 new type: " + doc1.getDoctorType());
		System.out.println("Doctor 2 pay per visit: " + doc2.getPayPerVisit());
		doc2.setPayPerVisit(60);
		System.out.println("Doctor 2 new pay per visit: " + doc2.getPayPerVisit());
		System.out.println("Is doctor 2 an pathologist? " + doc2.equals("pathologist"));
		System.out.println("is doctor 1 an Gynaikologist? " + doc1.equals("Gynaikologist"));	
		
		System.out.println("Is doctor 1 in the billing? " + bil1.equals(doc1));
		System.out.println("is doctor 2 in the billing? " + bil1.equals(doc2));
		
		bil1.setMyDoctor(doc1);
		System.out.println("Is doctor 2 in the billing now ? " + bil1.equals(doc2));
		System.out.println("Is doctor 1 in the billing? " + bil1.equals(doc1));
		
		System.out.println("Is patient 1 in the billing? " + bil1.equals(pat1));
		bil1.setMyPatient(pat2);
		System.out.println("Is patient 1 in the billing? " + bil1.equals(pat1));

	}

}
