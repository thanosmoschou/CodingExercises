#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#include <math.h>


int main()
{
	//Var. declar.
	int height,weight;

	//Prompt messages-Input
	printf("Dwse to baros:");
	weight=GetInteger();

	//Computation process
	height=ceil((1.1*weight+65)*1.2+7.0);

	//Output
	printf("To ypsos einai: %d",height);

	return 0;
}
