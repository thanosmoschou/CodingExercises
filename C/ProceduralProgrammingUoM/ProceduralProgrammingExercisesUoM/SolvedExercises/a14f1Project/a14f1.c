#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int varos,ypsos,age;
	double BMR;

	//Prompt messages
	printf("Dwse to varos se kila:");
	varos=GetInteger();

	printf("Dwse to upsos se cm:");
	ypsos=GetInteger();

	printf("Dwse thn Ilikia se xronia:");
	age=GetInteger();

	//Computation process
	BMR=655+(9.6*varos)+(1.8*ypsos)-(4.7*age);

	//Output
	printf("To BMR sou einai:%g",BMR);


	return 0;
}
