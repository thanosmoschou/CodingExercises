/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: simulation of a hotel service for rooms
 */

package ex6ch6JavaBook;

public class RoomOccupancy 
{
	private int numberInRoom;
	private static int totalNumber = 0;
	
	public RoomOccupancy()
	{
		numberInRoom = 0;
	}
	
	
	public void addOneToRoom()
	{
		numberInRoom++;
		totalNumber++;
	}
	
	
	public void removeOneFromRoom()
	{
		if(numberInRoom > 0)
		{
			numberInRoom--;
			totalNumber--;
		}
		else
			System.out.println("No one in this room...");
		
	}
	
	
	public int getNumber()
	{
		return numberInRoom;
	}
	
	
	public static int getTotal()
	{
		return totalNumber;
	}
	
}
