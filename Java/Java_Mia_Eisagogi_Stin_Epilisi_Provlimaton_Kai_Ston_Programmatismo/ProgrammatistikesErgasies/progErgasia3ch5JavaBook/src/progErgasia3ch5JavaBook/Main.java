/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: we read grades and we make a diagram on the screen
 */

package progErgasia3ch5JavaBook;

public class Main 
{

	public static void main(String[] args) 
	{
		Course c1 = new Course();
		
		c1.readData();
		
		c1.printDiagram();
		
		c1.getAmountOfStudentsWithThisGrade('F');
		c1.getAmountOfStudentsWithThisGrade('E');
		c1.setAmountViaGrade('A', 10);
		System.out.println(c1.getTotalStudents());
		c1.printDiagram();
	}

}
