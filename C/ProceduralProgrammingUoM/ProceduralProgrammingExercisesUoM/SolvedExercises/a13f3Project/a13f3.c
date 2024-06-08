#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int N;
	float sum;
	printf("Dwse orio:");
	N=GetInteger();

	for(float i=1;i<=N;i++)
	{
		sum+=1/i;
	}
	printf("To athroisma einai:%.2f",sum);
	return 0;
}
