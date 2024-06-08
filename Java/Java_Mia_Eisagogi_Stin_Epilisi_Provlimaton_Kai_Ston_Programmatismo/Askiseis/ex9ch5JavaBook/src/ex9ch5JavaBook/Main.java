/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: simulate a rating engine for movies
 */


package ex9ch5JavaBook;

public class Main 
{

	public static void main(String[] args)
	{
		RatingScore myMovie = new RatingScore("Bla Bla Bla");
		
		myMovie.readRatingAndComment();
		myMovie.readRatingAndComment();
		System.out.println(myMovie.getMaxComment());
		System.out.println(myMovie.getMax());
		System.out.println(myMovie.getSortDescription());

	}

}
