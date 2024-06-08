/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: simulation of a hotel service for rooms
 */

package ex6ch6JavaBook;

public class Main 
{

	public static void main(String[] args) 
	{
		RoomOccupancy myRoom1 = new RoomOccupancy();
		RoomOccupancy myRoom2 = new RoomOccupancy();

		myRoom1.addOneToRoom();
		myRoom2.removeOneFromRoom();
		
		System.out.println("People number in room 1: " + myRoom1.getNumber());
		System.out.println("People number in room 2: " + myRoom2.getNumber());
		System.out.println("Total people in this hotel: " + RoomOccupancy.getTotal());
		
		myRoom2.addOneToRoom();
		System.out.println("People number in room 2: " + myRoom2.getNumber());
		System.out.println("Total people in this hotel: " + RoomOccupancy.getTotal());


	}

}
