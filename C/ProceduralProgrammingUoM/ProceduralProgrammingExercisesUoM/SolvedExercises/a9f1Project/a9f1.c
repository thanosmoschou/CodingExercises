#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	//Var. declaration
	long purchaseAmount;
	double rate,amount,discount;

	//Prompt messages-Input
	printf("Dwse thn axia tou emporeumatos:");
	purchaseAmount=GetLong();

	printf("Dwse to pososto ekptwshs:");
	rate=GetReal();

	//Computation process
	amount=purchaseAmount -rate*purchaseAmount;
	discount=rate*purchaseAmount;

	//Output
	printf("To poso plhrwmhs einai: %g\n",amount);
	printf("H ekptwsh einai: %g",discount);


	return 0;
}
