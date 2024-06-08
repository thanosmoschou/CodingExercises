#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int num_coff,rest10,rest20,rest50,rest1,rest2,remain ,resta;
	double kostos;

	printf("Dwse kafedes: ");
	num_coff=GetInteger();
	kostos= num_coff*70;

	if (kostos<=500)
	{
		resta=500-kostos;

		rest2=resta/200;
		remain=resta%200;

		rest1=remain/100;
		remain=remain%100;

		rest50=remain/50;
		remain=remain%50;

		rest20=remain/20;
		remain=remain%20;

		rest10=remain/10;


		printf("Resta\n");
		printf("Kermata 2E:%d\n",rest2);
		printf("Kermata 1E:%d\n",rest1);
		printf("Kermata 50L:%d\n",rest50);
		printf("Kermata 20L:%d\n",rest20);
		printf("Kermata 10L:%d\n",rest10);

	}
	else
	{
		printf("den ftanoun ta xrhmata gia tosous kafedes");
	}

	return 0;
}
