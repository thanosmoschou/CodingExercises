/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: make sure that the message is shown only with the creation of the first element.
 */

package progEksask5ch6JavaBook;

public class Vehicle 
{
	private static boolean warning = false;
	
	public Vehicle()
	{
		if(!warning)
		{
			System.out.println("You should not operate this vehicle under the influence of alcohol.");
			warning = true;
		}
	}
}
