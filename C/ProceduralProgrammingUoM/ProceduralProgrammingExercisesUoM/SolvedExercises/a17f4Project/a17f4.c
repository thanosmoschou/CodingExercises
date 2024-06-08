#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

//Function declaration
int sum(int limit);


int main()
{
	int orio;

	printf("Dwse orio:");
	orio=GetInteger();

	printf("Athr 1...%d = %d",orio, sum(orio));


	return 0;
}

//Function definition
int sum(int limit)
{
	int s=0;
	for (int i=1;i<=limit;i++)
	{
		s+=i;
	}

	return s;
}

