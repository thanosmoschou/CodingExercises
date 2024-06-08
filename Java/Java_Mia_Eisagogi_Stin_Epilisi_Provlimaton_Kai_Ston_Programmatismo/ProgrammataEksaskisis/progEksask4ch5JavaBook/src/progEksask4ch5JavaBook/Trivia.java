/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: simple trivia with check if user gives correct answer
 */

package progEksask4ch5JavaBook;

public class Trivia 
{
	private String myQuestion;
	private String correctAnswer;
	
	
	public Trivia(String aQuestion, String aCorrectAnswer)
	{
		this.myQuestion = aQuestion;
		this.correctAnswer = aCorrectAnswer;
	}
	
	
	public boolean checkIfIsCorrect(String anAnswer)
	{
		return correctAnswer.equalsIgnoreCase(anAnswer);
	}
	
	
	public String getQuestion()
	{
		return myQuestion;
	}
	
	
	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
	
	
	public void setQuestion(String aQuestion, String anAnswer)
	{
		myQuestion = aQuestion;
		setCorrectAnswer(anAnswer);
	}
	
	//this only must be visible inside the class because i do not want anyone to change the correct answer and
	//not change the question without changing the correct answer...as a result i call this inside my setQuestion method
	private void setCorrectAnswer(String anAnswer)
	{
		correctAnswer = anAnswer;
	}
}
