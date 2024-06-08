#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int sum=0,num,n;

	printf("Dwse arithmo:");
	num=GetInteger();

	sum+=(num%10);
	n= num/10;

	while (n>0) // otan to piliko ginei 0 exo spasei teleiws ton arithmo mou
	{
		sum+=(n%10);
		n= n/10;
	}

	printf("To athroisma einai:%d",sum);

	return 0;
}
