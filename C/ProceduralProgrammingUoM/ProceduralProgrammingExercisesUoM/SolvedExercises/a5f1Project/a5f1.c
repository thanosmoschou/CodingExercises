#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	//Variable Declaration
	int working_hours;
	long antimoisthia;
	double pososto_kratisewn, akathar_apod,poso_krat,kath_apod;

    //Prompt messages-Input
	printf("Dwse ton arithmo twn wrwn:");
	working_hours=GetInteger();

	printf("Dwse thn wriaia antimoisthia:");
	antimoisthia=GetLong();

	printf("Dwse to pososto twn krathsewn:");
	pososto_kratisewn=GetReal();

	//Computation
	kath_apod= working_hours*antimoisthia;
	poso_krat= kath_apod * pososto_kratisewn;
	akathar_apod= kath_apod+poso_krat;

	//Output
	printf("Oi akatharistes apodoxes einai:%g\n",akathar_apod);
	printf("Oi krathseis einai:%g\n",poso_krat);
	printf("Oi kathares apodoxes einai:%g\n",kath_apod);

	return 0;
}
