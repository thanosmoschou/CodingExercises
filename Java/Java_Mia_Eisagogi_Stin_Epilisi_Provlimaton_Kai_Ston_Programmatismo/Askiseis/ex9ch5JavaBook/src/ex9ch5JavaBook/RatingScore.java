/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: simulate a rating engine for movies
 */

package ex9ch5JavaBook;

import java.util.Scanner;

public class RatingScore 
{
	private String sortDescription;
	private int maxRating;
	private String maxComment;
	
	public RatingScore(String aSortDescription)
	{
		sortDescription = aSortDescription;
		maxRating = -1;
		maxComment = "";
	}
	
	
	public void readRatingAndComment()
	{
		Scanner keyboard = new Scanner(System.in);
		int newRate;
		
		while(true)
		{
			System.out.print("Please enter the rate within range [0-10]: ");
			newRate = keyboard.nextInt();
			keyboard.nextLine();
			
			if(newRate < 0 || newRate > 10)
				System.out.println("Invalid data...");
			else
			{
				if(newRate > maxRating)
				{
					maxRating = newRate;
					
					System.out.print("Please enter a comment: ");
					maxComment = keyboard.nextLine();
				}
				
				break;
			}
			
		}
		
	}
	
	
	public int getMax()
	{
		return maxRating;
	}
	
	
	public String getMaxComment()
	{
		return maxComment;
	}
	
	
	public String getSortDescription()
	{
		return sortDescription;
	}
}
