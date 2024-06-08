/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: vote recorder
 */


public class Main 
{

	public static void main(String[] args) 
	{
		VoteRecorder user = new VoteRecorder();
		
		System.out.println("***President Candidates***");
		System.out.println(VoteRecorder.getCurrentVotePresident());
		
		System.out.println("***Vice President Candidates***");
		System.out.println(VoteRecorder.getCurrentVoteVicePresident());
		
		System.out.println("--------------------");
		
		VoteRecorder.getAndConfirmVotes(user);
		System.out.println("User voted selection: " + user.getVotes(1) + " for president and selection: " + user.getVotes(2) + " for vice president.");
	
		System.out.println("--------------------");
		
		System.out.println("***President Candidates***");
		System.out.println(VoteRecorder.getCurrentVotePresident());
		
		System.out.println("***Vice President Candidates***");
		System.out.println(VoteRecorder.getCurrentVoteVicePresident());
		
		System.out.println("--------------------");
		
		VoteRecorder.setCandidatesPresident("John Alex", "Maria Wilson");
		System.out.println("***President Candidates***");
		System.out.println(VoteRecorder.getCurrentVotePresident());
		
		VoteRecorder.setCandidatesPresident("Maria Alex", "Eric Wilson");
		System.out.println("***Vice President Candidates***");
		System.out.println(VoteRecorder.getCurrentVoteVicePresident());
		
		System.out.println("User\'s selection for vice president: " + user.getVotes(2));
	
	
	
	}

}
