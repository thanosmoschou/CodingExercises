#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	//Variable declaration
	long fpa4,fpa8,fpa18;
	double sin_fpa;

	//Prompt messages-Input
	printf("Dwse tis synolikes eispraxeis gia FPA 0.04:");
	fpa4=GetLong();
	printf("Dwse tis synolikes eispraxeis gia FPA 0.08:");
	fpa8=GetLong();
	printf("Dwse tis synolikes eispraxeis gia FPA 0.18:");
	fpa18=GetLong();

	//Computation process
	sin_fpa=0.04*fpa4+0.08*fpa8 +0.18*fpa18;

	//Output
	printf("To synoliko poso FPA einai:%g",sin_fpa);

	return 0;
}
