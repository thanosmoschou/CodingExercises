#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#include <math.h>

//Function declaration
long Kefal(int kef, double epitok, int years);

int main()
{
	//Variables
	int Eti;
	long Kefalaio;
	double Epitokio;

	//Input
	printf("Dwse to kefalaio:");
	Kefalaio=GetLong();

	printf("Dwse to epitokio: ");
	Epitokio=GetReal();

	printf("Dwse ta eth:");
	Eti=GetInteger();

	//Output
	printf("%ld", Kefal(Kefalaio,Epitokio,Eti));

	return 0;
}


//Function and computation
long Kefal(int kef, double epitok, int years)
{
	long sum=ceil(kef*(1+epitok));

	for (int i=2; i<=years; i++)
	{
		sum= ceil(sum*(1+epitok));
	}

	return sum;
}
