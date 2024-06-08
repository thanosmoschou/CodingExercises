#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

//Function declaration
void messages(double indic);
int computation(double heig, double weig);


int main()
{

	double height, weight, indication;

	//Input
	printf("Dwse ypsos: ");
	height=GetReal();

	if(height>0)
	{
		printf("Dwse baros: ");
		weight=GetReal();
	}


	//Computation loop
	while (height !=0 && weight !=0)
	{
		indication= computation(height,weight);
		messages(indication); //gia emfanisi minimaton

		//enimerosi sinthikis oste na min exo atermon vroxo
		printf("Dwse ypsos: ");
		height=GetReal();

		if(height<=0)
		{
			break;
		}
		else
		{
			printf("Dwse baros: ");
			weight=GetReal();
		}

	}

	return 0;
}

//Functions
int computation(double heig, double weig)
{
	return (weig/(pow(heig,2)));
}

void messages(double indic)
{
	if (indic<18.5)
	{
		printf("Lipovaris\n");
	}
	else if(indic<25)
	{
		printf("Kanonikos\n");
	}
	else if (indic<30)
	{
		printf("Ypervaros\n");
	}
	else
	{
		printf("Paxysarkos\n");
	}

}
