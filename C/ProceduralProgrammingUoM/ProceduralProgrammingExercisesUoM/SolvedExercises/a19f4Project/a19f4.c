#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"



//Function declaration
double calcul(int limit);


int main()
{
	int orio;
	double p;
	printf("Dwse orio:");
	orio=GetInteger();

	p=2*(calcul(orio));
	printf("pi= %.6f", p);

	return 0;
}

//Function definition
double calcul(int limit)
{
	double pie=1;

	for(int i=2; i<=limit; i+=2)
	{
		pie*= (pow((double)i, 2.0))/((i-1)*(i+1));
	}

	return pie;


}
