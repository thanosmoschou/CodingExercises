//ASKHSH 12 FYLLADIO 1
#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	//Variable declaration
	int kath_metr,mikta_metr;
	float DT,DF;

	//Prompt messages
	printf("Dose kathara tm: ");
	kath_metr=GetInteger();
	printf("Dose mikta tm: ");
	mikta_metr=GetInteger();

	//Computation process
	DT=(kath_metr*1.33*61)/365;
	DF=(mikta_metr*0.13*61)/365;

	//Output Messages
	printf("DT: %.2f\n",DT);
	printf("DF: %.2f\n",DF);


	return 0;
}
