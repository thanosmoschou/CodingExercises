#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#include <math.h>


//Function declaration
int calc(int n1, int n2, int n3);


int main()
{
	int n,result=0,i,j,k

	;

	//Input
	printf("Dwse n:");
	n=GetInteger();

	for(i=1; i<=3; i++)
	{
		for(j=1;j<=n;j++)
		{
			for(k=1;k<=n; k++)
			{
				result+= calc(i,j,k);
			}
		}

	}

	printf("Result: %d",result);



	return 0;
}


//Function definition
int calc(int n1, int n2, int n3)
{
	if(n1==1)
	{
		return n2+n3;
	}
	else if(n1==2)
	{
		return n2-n3;
	}
	else if (n1==3)
	{
		int mo;
		mo=(n2+n3)/2;
		return floor(mo);
	}
	else
	{
		return 0;
	}



}
