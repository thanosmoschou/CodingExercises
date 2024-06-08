#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include"genlib.h"
#include"simpio.h"
#define DIMENS 15
#define D1 3
#define D2 30

int main()
{
	int i,index1,index2,ctr,gr,coef;
	double finalgr;
	char Grades[DIMENS],Separ1[D2],Separ2[D1],Separ3[D1];

	printf("Please insert course info (name/coef/mark): ");
	gets(Grades);

	//Separation process..I use a table to pass the string without the '/' and i use an index every time to know where my information ends
	for(i=0; Grades[i]!='/'; i++)
	{
		Separ1[i]=Grades[i];
		index1=i; //Where the name ends in my new table
	}

	if(strlen(Separ1)<10)
	{

		ctr=0;
		for(i=index1+2; Grades[i]!='/'; i++) //index1+2 is where the new information starts in old table because i had a '/' before so i had to move 2 places after the end of the first clue
		{
			Separ2[ctr]=Grades[i];
			ctr++;
			index2=i; //Where my coef ends in my old table..Caution my coef is after the first information and its starting position is index2-index1(the index value of the second element)
		}

		ctr=0;
		for(i=index2+2; Grades[i]!='\0'; i++)
		{
			Separ3[ctr]=Grades[i];
			ctr++;

		}

		//calculation process
		coef=atoi(Separ2);
		gr=atoi(Separ3);
		finalgr=gr*(double)coef/100;

		//output
		printf("lesson: %s\n", Separ1);
		printf("coef: %2d\n", coef);
		printf("mark: %2d\n", gr);
		printf("final mark:%6.2f\n",finalgr);

	}
	else
	{
		printf("Error! Name should not be more than 9 chars\n");
	}

	return 0;
}
