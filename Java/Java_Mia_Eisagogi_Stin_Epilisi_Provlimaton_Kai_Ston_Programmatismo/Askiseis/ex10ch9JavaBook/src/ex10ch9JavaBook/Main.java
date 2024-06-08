/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception handling exercises
 */

package ex10ch9JavaBook;

public class Main 
{

	public static void main(String[] args)
	{
		RoomCounter room1 = new RoomCounter(2);
		
		room1.addPerson();
		System.out.println("Total people in the room: " + room1.getPerson());
		room1.removePerson();
		System.out.println("Total people in the room: " + room1.getPerson());
		room1.removePerson();
		room1.removePerson();
		System.out.println("Total people in the room: " + room1.getPerson());
		room1.removePerson();
		System.out.println("Total people in the room: " + room1.getPerson());
	}

}
