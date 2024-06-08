/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: grades with enum. I am not fluent with enum yet...
 */

package progErgasia5ch6JavaBook;

public class Main 
{
	enum LetterGrade
	{
		A("+"), B("-"), C(" "), D("+"), E(" "), F("+");
		
		private String exten; //it can have + or - or nothing
		private boolean canPass;
		
		private LetterGrade(String aString)
		{
			exten = aString;
			canPass = true;
		}
		
		
		public boolean isPassing()
		{
			switch(this.toString())
			{
				case "A":
				case "B":
				case "C":
					if(exten == "+" || exten == "-" || exten == " ")
						canPass = true;
					break;
				case "D":
				case "E":
				case "F":
					if(exten == "+" || exten == "-" || exten == " ")
						canPass = false;			
					break;
			}
			
			return canPass;
		}
		
		
		public String getString()
		{
			return this.toString() + exten;
		}
	}
	
	
	public static void main(String[] args)
	{		
		for(LetterGrade gr : LetterGrade.values() )
		{
			System.out.println("CAN PASS ? " + gr.isPassing());
			System.out.println(gr.getString());
		}
	}
}
