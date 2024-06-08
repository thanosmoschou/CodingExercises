#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	//Var. Declaration
	int imer_erg;
	long imer_amoib;
	double posost_dor, doro;

	//Prompt messages-Input
	printf("Dwse tis hmeres ergasias tou etous:");
	imer_erg=GetInteger();

	printf("Dwse  thn hmerhsia amoibh:");
	imer_amoib=GetLong();

	printf("Dwse to pososto tou dwroy:");
	posost_dor=GetReal();

	//Computation
	doro= (imer_erg*imer_amoib)*posost_dor;

	//Output
	printf("To dwro einai : %g",doro);
	return 0;
}

