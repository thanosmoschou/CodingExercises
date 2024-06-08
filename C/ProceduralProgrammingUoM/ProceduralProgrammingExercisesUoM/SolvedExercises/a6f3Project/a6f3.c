#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int f0,f1,fib,N;

	//Input
	printf("Dwse plithos N oron gia akolouthia fibonacci:");
	N=GetInteger();

	for(int i=0;i<N;i++)
	{
		if(i==0)
		{
			f0=0;
			fib=0;
		}
		else if(i==1)
		{
			f0=0;
			f1=1;
			fib=f0+f1;
			printf("%d\n",f1);
		}
		else
		{
			f0=f1;
			f1=fib;
			fib=f0+f1;
		}
		printf("%d\n",fib);

	}
	return 0;
}
