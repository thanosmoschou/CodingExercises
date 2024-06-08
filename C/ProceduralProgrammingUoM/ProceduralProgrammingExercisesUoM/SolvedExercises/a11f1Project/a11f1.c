#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	//Var. declar.
	long timh_tem,plhth_parag;
	double FPA,kostos;

	//Prompt messages
	printf("Dwse thn timh temaxiou:");
	timh_tem=GetLong();

	printf("Dwse to pososto FPA:");
	FPA=GetReal();

	printf("Dwse to plithos twn temaxiwn: ");
	plhth_parag=GetLong();

	//Computation process
	kostos=(timh_tem*plhth_parag)+FPA*(timh_tem*plhth_parag);
	//Output
	printf("To kostos ths paragelias einai: %g",kostos);
	return 0;
}
