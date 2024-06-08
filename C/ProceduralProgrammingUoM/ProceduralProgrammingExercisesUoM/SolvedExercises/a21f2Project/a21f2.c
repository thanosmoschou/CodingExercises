#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	//Var. declaration
	int vas_misthos,ar_paidion;
	float epidoma;

	//Input
	printf("Dwse vasiko mistho:");
	vas_misthos=GetInteger();

	printf("Dwse arithmo paidion:");
	ar_paidion=GetInteger();

	//Computation process
	if(ar_paidion==0)
	{
		epidoma=0;
	}
	else if(ar_paidion==1)
	{
		epidoma=0.04*vas_misthos;
	}
	else if(ar_paidion==2)
	{
		epidoma=0.09*vas_misthos;
	}
	else if(ar_paidion==3)
	{
		epidoma=0.15*vas_misthos;
	}
	else
	{
		epidoma=0.15*vas_misthos+0.04*vas_misthos*(ar_paidion-3);
	}

	//Output
	printf("Epidoma:%.2f",epidoma);

	return 0;
}
