#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	long weight,cost;
	double epivar,teli_apost;
	int code;

	printf("Dwse to varos:");
	weight=GetLong();

	printf("Dwse ton kwdiko ths xwras apostolhs <0,1>:");
	code=GetInteger();

	if (weight<=20)
    {
    	cost=weight*15;
    }
    else if (weight <=100)
	{
		cost=20*15 +(weight-20)*20;
	}
	else
	{
		cost=20*15+80*20+(weight-100)*25;
	}


	if (code==1)
	{
		epivar=0.15*(120+cost);
	}
	else if(code==0)
	{
		epivar=0.12*(120+cost);
	}

	teli_apost=cost+epivar+120;

	printf("To baros einai:%ld\n",weight);
	printf("H epipleon xrewsh einai:%ld\n",cost);
	printf("H epibarunsh einai: %g\n", epivar);
	printf("Ta taxydromika telh einai: %g\n", teli_apost);

	return 0;
}
