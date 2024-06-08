#include<stdio.h>
#include "genlib.h"
#include "simpio.h"

//Function declaration
int add(int x,int y);
int sub(int x,int y);
int mult(int x,int y);
int divd(int x, int y);

int main()
{
	int x,y;

	printf("Dwse ton 1o arithmo: ");
	x=GetInteger();

	printf("Dwse ton 2o arithmo: ");
	y=GetInteger();

	printf("add: %d\n",add(x,y));
	printf("sub: %d\n",sub(x,y));
	printf("mult: %d\n",mult(x,y));
	printf("divd: %d\n",divd(x,y));
	printf("exp1: %d\n",mult(add(x,y), sub(y, divd(x,y))));
	printf("exp2: %d\n",divd(sub(mult(x, y), x), add(x, y)));


	return 0;
}

int add(int x,int y)
{
	return x+y;
}

int sub(int x,int y)
{
	return x-y;
}

int mult(int x,int y)
{
	return x*y;
}

int divd(int x,int y)
{
	return x/y;
}
