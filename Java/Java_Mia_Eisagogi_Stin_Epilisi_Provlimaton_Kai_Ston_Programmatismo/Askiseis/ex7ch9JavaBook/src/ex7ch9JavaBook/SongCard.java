/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: understanding exceptions
 */

package ex7ch9JavaBook;

public class SongCard 
{
	private int songs;
	private boolean activated;
	
	public SongCard(int someSongs)
	{
		this.songs = someSongs;
	}
	
	
	public void activate() throws AlreadyActivatedException
	{
		if(!activated)
		{
			this.activated = true;
		}
		else
			throw new AlreadyActivatedException("You cannot activate a card twice.");
	}
	
	
	public void buyASong() throws OutOfSongsException, NotActivatedCardException
	{
		if(!this.activated)
			throw new NotActivatedCardException();
		else if(songs == 0)
			throw new OutOfSongsException();
		else if(songs > 0)
			songs -= 1;
	}
	
	
	public int songsRemaining()
	{
		return this.songs;
	}
}
