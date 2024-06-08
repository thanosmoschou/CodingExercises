#include<stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	long ar_epistol_es,ar_epistol_ex;
	double kostos;

	//Prompt messages-Input
	printf("Dwse ton arithmo epistolwn eswterikou:");
	ar_epistol_es=GetLong();
	printf("Dwse ton aritmho epistolwn tou exwterikou:");
	ar_epistol_ex=GetLong();

	//Computation process
	kostos= 0.3*ar_epistol_es+0.8*ar_epistol_ex;

	//Output
	printf("To synoliko kostos apostolhs einai: %g",kostos);

	return 0;
}
