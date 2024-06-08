#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#define DIMENSION 10


//Function declaration
void Fill(int row, int table[]);
void Calculate(int row, int table[], int *smalleqA, int *greateqB, int *insAB, int n1, int n2);
void PrintRes(int row, int table[], int smalA, int greaB,int  insAB, int n1 , int n2);


int main()
{
	int table[DIMENSION],A,B, smallerorequalA,greaterorequalB, insideAB ;

	//Fill the table
	Fill(DIMENSION, table);

	//User Input
	printf("Insert two numbers A,B.. Note it must be A<B\n");
	printf("Insert A: ");
	scanf("%d", &A);
	printf("Insert B: ");
	scanf("%d", &B);

	//Computation
	Calculate(DIMENSION, table, &smallerorequalA, &greaterorequalB, &insideAB, A,B);

	//Output
	PrintRes(DIMENSION, table, smallerorequalA, greaterorequalB,insideAB,A,B);
	return 0;
}

//Function definition

void Fill(int row, int table[])
{
	int i;

	for(i=0; i<row; i++)
	{
		printf("Insert the element no%d: ", i);
		scanf("%d", &table[i]);
	}
}

void Calculate(int row, int table[], int *smalleqA, int *greateqB, int *insAB, int n1, int n2)
{
	int i;

	//Initialization
	(*smalleqA)=(*greateqB)=(*insAB=0);

	for(i=0; i<row; i++)
	{
		if(table[i]<=n1)
		{
			(*smalleqA)++;
		}

		if(table[i]>=n2)
		{
			(*greateqB)++;
		}

		if(table[i]>n1 && table[i]<n2)
		{
			(*insAB)++;
		}

	}
}


void PrintRes(int row, int table[], int smalA, int greaB,int  insAB, int n1 , int n2)
{
	int i;

	printf("Numbers in the table:\n");
	for(i=0; i<row; i++)
	{
		printf("%d\n", table[i]);
	}

	printf("A: %d\n", n1);
	printf("B: %d\n", n2);

	printf("Total numbers that are smaller or equal to A: %d\n", smalA);
	printf("Total numbers that are greater or equal to B: %d\n", greaB);
	printf("Total numbers that are bigger than A and smaller than B: %d\n", insAB);
}
