#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


//Function declaration
int choice();
double calc(int choice, double poso);

int main()
{
	int x;
	double poso_euro;


	while(TRUE)
	{
		x=choice();

		if(x==6)
		{
			break;
		}

		printf("Dwse poso se Euro gia metatropi:");
		poso_euro=GetReal();

		switch(x)
		{
			case 1:
				printf("To poso se dollaria einai: %.2f\n",calc(x,poso_euro));
				break;
			case 2:
				printf("To poso se lires einai: %.2f\n", calc(x,poso_euro) );
				break;
			case 3:
				printf("To poso se fraga Elbetias einai: %.2f\n", calc(x,poso_euro));
				break;
			case 4:
				printf("To poso se dollaria Canada einai: %.2f\n", calc(x,poso_euro));
				break;
			case 5:
				printf("To poso se gien einai: %.2f\n", calc(x,poso_euro));
				break;
		}
	}


	return 0;
}


int choice()
{
	printf("1. Metetroph se dollaria\n");
	printf("2. Metatroph se lires\n");
	printf("3. Metatroph se fraga Elbetias\n");
	printf("4. Metatroph se dollaria Canada\n");
	printf("5. Metatroph se gien\n");
	printf("6. Exodos\n");

	printf("Dwse epilogi:");
	return GetInteger();
}

double calc(int choice, double poso)
{
	switch (choice)
	{
		case 1:
			return poso*0.89;
		case 2:
			return poso*0.618;
		case 3:
			return poso*1.5465;
		case 4:
			return poso*1.3565;
		case 5:
			return poso*109.22;
	}

}

