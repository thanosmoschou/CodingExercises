#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


//Function declaration
void PromptMessages(void);
bool Valid_Date(int day, int month, int year);


int main()
{
	int day,month,year;

	//Input
	PromptMessages();
	printf("Give the day:");
	day=GetInteger();

	printf("Give the month:");
	month=GetInteger();

	printf("Give the year:");
	year=GetInteger();

	//Output
	printf("%d", Valid_Date(day,month,year));


	return 0;
}

//Functions definition

void PromptMessages(void)
{
	printf("Give the date (day/month/year) of a year and the program will heck if this date belongs to the entered year...(TRUE/FALSE, (0/1)\n");
	printf("All information must be numbers...\n");
}

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
