#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


//Function declaration
bool Valid_Date(int day, int month, int year);
long Read_and_Calculate(int current_year);

int main()
{

	int cur_year;

	printf("Current year:");
	cur_year=GetInteger();

	printf("SYNOLO FPA: %ld",Read_and_Calculate(cur_year));

	return 0;
}



//Function definition
bool Valid_Date(int day, int month, int year)
{
	int days;

	if(month ==1 || month ==3 || month ==5 || month ==7 || month ==8 || month ==10 || month ==12)
	{
			days=31;

			if(day<=days)
			{
				return TRUE;
			}

			return FALSE; //Den vazo else giati sto proto return pou tha vrei feugei apo tin sunartisi ara den thelo oute break
	}
	else if(month ==4 || month ==6 || month ==9 || month ==11)
	{
			days=30;

			if(day<=days)
			{
				return TRUE;
			}
			return FALSE;

	}
	else if (month==2)
	{
			days=28;

			if ((year%4==0 && year%100!=0) || year%400==0)
			{
				days=29;
			}

			if(day<=days)
			{
				return TRUE;
			}
			return FALSE;
	}
	else
	{
		return FALSE;
	}

}


long Read_and_Calculate(int current_year)
{
		int day,year,month;
		long sum_fpa=0,fpa;

		while (TRUE)
		{
			printf("Day:");
			day=GetInteger();
			if(day== -1)
			{
				break;
			}

			printf("Month:");
			month=GetInteger();

			printf("Year:");
			year=GetInteger();

			printf("FPA:");
			fpa=GetLong();

			if(Valid_Date(day,month,year)) //Check if date is valid and then calculate fpa
			{

				if (year==current_year) //I want year to be equal with current year in order to sum fpa
				{
						sum_fpa+=fpa;
				}
				/*else
				{
					printf("Fpa will not be counted due to invalid year\n");
				}*/

			}
			/*else
			{
				printf("Invalid Date..Fpa will not be counted.\n");
			}*/


		}

		return sum_fpa;
}
