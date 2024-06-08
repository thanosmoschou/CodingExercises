#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

//Function declaration
void Comprehension();
void Comprehension2(int times);

int main()
{
	int limit;

	Comprehension();

	printf("Dwse orio:");
	limit=GetInteger();

	Comprehension2(limit);

	return 0;
}

void Comprehension()
{
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
	printf("katanoiste ti glossa c\n");
}

void Comprehension2(int limit)
{
	for(int i=1; i<=limit; i++)
	{
		printf("katanoiste ti glossa c\n");
	}
}
