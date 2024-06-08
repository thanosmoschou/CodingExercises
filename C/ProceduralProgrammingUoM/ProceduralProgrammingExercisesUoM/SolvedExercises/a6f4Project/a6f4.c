#include <stdio.h>
#include <math.h>
#include "simpio.h"
#include "genlib.h"

//Function declaration
int MAX(int n1,int n2);
int MIN(int n1,int n2);


int main()
{
	int x,y;

	//Input
	printf("Dwse 2 arithmous..Dwse ton 1o: ");
	x=GetInteger();

	printf("Dwse ton 2o: ");
	y=GetInteger();

	//Computation & Output
	printf("MAX: %d\n", MAX(x,y));
	printf("MIN: %d", MIN(x,y));

	return 0;
}

int MAX(int n1, int n2)
{
	if(n1>n2)
	{
		return n1;
	}
	return n2; //Den vazo else if giati an n1>n2 exo return ara feugei apo thn sunartisi..an den isxuei n1>n2 tha epistrepsei n2
}

int MIN(int n1, int n2)
{
	if(n1<n2)
	{
		return n1;
	}
	return n2; //Gia ton idio logo
}

