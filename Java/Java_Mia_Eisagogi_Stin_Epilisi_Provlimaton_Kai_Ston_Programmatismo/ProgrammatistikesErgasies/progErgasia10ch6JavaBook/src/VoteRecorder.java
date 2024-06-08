/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: vote recorder
 */

import java.util.Scanner;

public class VoteRecorder 
{
	private static String nameCandidatePresident1;
	private static String nameCandidatePresident2;
	private static String nameCandidateVicePresident1;
	private static String nameCandidateVicePresident2;
	
	private static int votesCandidatePresident1;
	private static int votesCandidatePresident2;
	private static int votesCandidateVicePresident1;
	private static int votesCandidateVicePresident2;
	
	private int myVoteForPresident; //it can have values of 0, 1, 2
	private int myVoteForVicePresident; //it can have values of 0, 1, 2
	
	private int counterForSettingName = 0;
	
	
	public VoteRecorder()
	{
		if(counterForSettingName == 0)
		{
			nameCandidatePresident1 = "John Smith";
			nameCandidatePresident2 = "Alexander Jordan";
			nameCandidateVicePresident1 = "George Michael";
			nameCandidateVicePresident2 = "Sam Jones";
			
			votesCandidatePresident1 = 0;
			votesCandidatePresident2 = 0;
			votesCandidateVicePresident1 = 0;
			votesCandidateVicePresident2 = 0;
			
			counterForSettingName++;
		}
		
		myVoteForPresident = 0;
		myVoteForVicePresident = 0;
		
	}

	
	public static void setCandidatesPresident(String pres1, String pres2)
	{
		nameCandidatePresident1 = pres1;
		nameCandidatePresident2 = pres2;
		resetVotes(1);
	}
	
	
	public static void setCandidatesVicePresident(String vice1, String vice2)
	{
		nameCandidateVicePresident1 = vice1;
		nameCandidateVicePresident2 = vice2;
		resetVotes(2);
	}
	
	
	public static void resetVotes(int presOrVice) //presOrVice = 1 if i have normal president and 2 when i have vice
	{
		if(presOrVice == 1)
		{
			votesCandidatePresident1 = 0;
			votesCandidatePresident2 = 0;
		}
		else if(presOrVice == 2)
		{
			votesCandidateVicePresident1 = 0;
			votesCandidateVicePresident2 = 0;
		}
	}
	
	
	public static String getCurrentVotePresident()
	{
		return nameCandidatePresident1 + " = " + votesCandidatePresident1 + "\n" + nameCandidatePresident2 + " = " + votesCandidatePresident2;
	}
	
	
	public static String getCurrentVoteVicePresident()
	{
		return nameCandidateVicePresident1 + " = " + votesCandidateVicePresident1 + "\n" + nameCandidateVicePresident2 + " = " + votesCandidateVicePresident2;
	}
	
	
	public static void getAndConfirmVotes(VoteRecorder r1)
	{
		int vote;
		boolean decision;
		
		vote = r1.getAVote(nameCandidatePresident1, nameCandidatePresident2);
		decision = r1.confirmVotes(1, vote); //1 for president
		
		if(decision)
		{
			if(vote == 0)
			{
				System.out.println("No choice for president selected.");
			}
			else if(vote == 1)
			{
				System.out.println("This user voted: " + nameCandidatePresident1 + " for president");
				r1.recordVotes(nameCandidatePresident1);		
			}
			else if(vote == 2)
			{
				System.out.println("This user voted: " + nameCandidatePresident2 + " for president");
				r1.recordVotes(nameCandidatePresident2);
			}
			
			r1.myVoteForPresident = vote;
		}
		else
			System.out.println("User cancelled his/her vote for president.");
		
		
		//------------------------------
		
		vote = r1.getAVote(nameCandidateVicePresident1, nameCandidateVicePresident2);
		decision = r1.confirmVotes(2, vote); //2 for vice president
		
		if(decision)
		{
			if(vote == 0)
			{
				System.out.println("No choice for vice president selected.");
			}
			else if(vote == 1)
			{
				System.out.println("This user voted: " + nameCandidateVicePresident1 + " for vice president");
				r1.recordVotes(nameCandidateVicePresident1);
			}
			else if(vote == 2)
			{
				System.out.println("This user voted: " + nameCandidateVicePresident2 + " for vice president");
				r1.recordVotes(nameCandidateVicePresident2);
			}
			
			r1.myVoteForVicePresident = vote;
		}
		else
			System.out.println("User cancelled his/her vote for vice president.");
		
	}
	
	
	private int getAVote(String name1, String name2)
	{
		int vote;
		Scanner in = new Scanner(System.in);
		
		System.out.println(name1 + " or " + name2 + " (0 for no selection, 1 for the 1st name, 2 for the 2nd name)? ");
		while(true)
		{
			vote = in.nextInt();
			if(vote != 0 && vote != 1 && vote != 2)
				System.out.println("Invalid selection");
			else
				break;
		}
		
		return vote;
	}
	
	
	public int getVotes(int selection)
	{
		if(selection == 1)
			return myVoteForPresident;
		else if(selection == 2)
			return myVoteForVicePresident;
		else
		{
			System.out.println("Invalid data...");
			return 0;
		}
	}
	
	
	private boolean confirmVotes(int selection, int vote)
	{
		System.out.println("Your votes are: ");
		
		if(selection == 1)
		{
			if(vote == 1)
			{
				System.out.println("For president: " + nameCandidatePresident1);
			}
			else if(vote == 2)
			{
				System.out.println("For president: " + nameCandidatePresident2);
			}
			else //myVoteForPresident = 0
				System.out.println("No selection for president");
		}
		else if(selection == 2)
		{
			if(vote == 1)
			{
				System.out.println("For Vice president: " + nameCandidateVicePresident1);
			}
			else if(vote == 2)
			{
				System.out.println("For Vice president: " + nameCandidateVicePresident2);
			}
			else //myVoteForPresident = 0
				System.out.println("No selection for  Vice president");
		}		
		
		System.out.print("Are you ok with your selections(Yes/No)? ");
		String decision;
		Scanner keyboard = new Scanner(System.in);
		
		decision = keyboard.nextLine();
		
		if(decision.equalsIgnoreCase("Yes"))
			return true;
		
		return false;
	}
	
	
	private void recordVotes(String aName)
	{
		if(aName.equalsIgnoreCase(nameCandidatePresident1))
			votesCandidatePresident1++;
		else if(aName.equalsIgnoreCase(nameCandidatePresident2))
			votesCandidatePresident2++;
		else if(aName.equalsIgnoreCase(nameCandidateVicePresident1))
			votesCandidateVicePresident1++;
		else if(aName.equalsIgnoreCase(nameCandidateVicePresident2))
			votesCandidateVicePresident2++;
		else
			System.out.println("Invalid candidate.");
	}
}
