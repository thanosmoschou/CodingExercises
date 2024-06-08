#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define _OPEN_SYS_ITOA_EXT

//Function declaration
void DateString(int row,int day, int month, int year, char date[]);
void SelectMonth(int month, int dim,char mon[]);


int main()
{
	int day,month,year;
	char date[10]={'\0'};


	printf("Insert Day:");
	scanf("%d", &day);
	printf("Insert Month:");
	scanf("%d", &month);
	printf("Insert Year:");
	scanf("%d", &year);
	DateString(10,day,month,year,date);
	printf("%s\n", date);

	return 0;
}


//Function definition
void DateString(int row,int day, int month, int year, char date[])
{
	char day1[3], month1[4], year1[3];

	itoa(day,day1,10);
	if(strlen(day1)<2) day1[1]='\0'; //If you didn't insert 2 digit day
	else day1[2]='\0';

	//printf("%s\n", day1);

	SelectMonth(month, 4,month1);

	//printf("%s\n", month1);

	itoa(year%100,year1,10);
	printf("%s\n", year1);

	//year1[strlen(year1)]='\0';

	/*Let's copy my date to the date char table:
	First i want to copy my 2 digits so i use strncat...
	Then i want to put a dash but where? I must put it at the end of my digits
	Let's say that the length of the digits is 2 so in the 3rd place i should put a dash...
	As a result i use strlen to count the length of the digits.The positions start from 0
	so 0,1 are the positions for my digits...and the strlen=2 shows the position to put my dash..
	In the old table day1 in the position 2 i had a \0 so if i used strlen there i would use it to find the position to terminate my string
	just because the positions start from 0 and strlen doesn't count \0 so if it says 2 my digits are 2 but in positions 0 and 1 so in
	the position 2 i put \0..
	Second i want to put my letters from my month...I should start to put my string at the end of the previous things i put in so i
	copy the 3 letters at the end of the date table
	Then i put a dash again..now strlen(day1) shows until i put the first dash and strlen(month1) shows the letters and in the old table
	month1 in the strlen(month1) position i had a \0...now i use this position in an another table to put a dash..
	After that i complete the string with the last two digits of the year and a \0.*/

	strncat(date, day1,strlen(day1));
	date[strlen(day1)]='-';
	strncat(date, month1,3);
	date[strlen(day1)+strlen(month1)+1]='-';
	strncat(date, year1,3);

}

void SelectMonth(int month, int dim,char mon[])
{

	switch(month)
	{
		/*The strings are table of characters but they don't work like number tables...you can't equate two tables with strings(f.e A=B)
		...remember the "something" is a table
		of characters and the \0 at the end...you must copy the string table you want to the other ...*/
		case 1:
			strcpy(mon, "Jan");
			break;
		case 2:
			strcpy(mon, "Feb");
			break;
		case 3:
			strcpy(mon, "Mar");
			break;
		case 4:
			strcpy(mon, "Apr");
			break;
		case 5:
			strcpy(mon, "May");
			break;
		case 6:
			strcpy(mon, "Jun");
			break;
		case 7:
			strcpy(mon, "Jul");
			break;
		case 8:
			strcpy(mon, "Aug");
			break;
		case 9:
			strcpy(mon, "Sep");
			break;
		case 10:
			strcpy(mon, "Oct");
			break;
		case 11:
			strcpy(mon, "Nov");
			break;
		case 12:
			strcpy(mon, "Dec");
			break;
	}

	//printf("%s", mon);
}
