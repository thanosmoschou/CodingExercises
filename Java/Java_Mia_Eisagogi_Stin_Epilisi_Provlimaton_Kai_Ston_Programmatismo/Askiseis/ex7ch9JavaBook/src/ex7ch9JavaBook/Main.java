/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: understanding exceptions
 */

package ex7ch9JavaBook;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		SongCard card1 = new SongCard(10);
		SongCard card2 = new SongCard(2);
		String decision;
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			try
			{	
				//card1.buyASong();
				//System.out.println("Songs remaining for card 1: " + card1.songsRemaining());
				card1.activate();
				//card1.activate();
				//card2.buyASong();
				card2.activate();
				card1.buyASong();
				System.out.println("Songs remaining for card 1: " + card1.songsRemaining());
				card2.buyASong();
				card2.buyASong();
				System.out.println("Songs remaining for card 2: " + card2.songsRemaining());
				card2.buyASong();
			}
			catch(AlreadyActivatedException e)
			{
				System.out.println(e.getMessage());
			}
			catch(NotActivatedCardException e)
			{
				System.out.println(e.getMessage());
			}
			catch(OutOfSongsException e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{				
				System.out.println("Continue Y/N ? ");
				decision = in.nextLine();	
			}
			
			if(decision.equalsIgnoreCase("N"))
				break;
		}
	}
}
