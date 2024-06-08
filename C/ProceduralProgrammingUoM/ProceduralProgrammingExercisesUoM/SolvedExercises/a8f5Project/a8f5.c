#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#define M 50
#define N 50

//Function declaration
void Read_Array(int m, int n);
void Create_Array(int row, int col, long matrix[row][col]);
void Print_Array(int row, long matrix[row], int dimens1, int dimens2);


int main()
{
	int m,n;


	//Input
	printf("Dwse to plhthos twn grammwn:");
	m=GetInteger();

	printf("Dwse to plhthos twn sthlwn:");
	n=GetInteger();

	Read_Array(m,n);

	return 0;
}

//Function definition

void Read_Array(int row, int col)
{
	long matrix[row][col];

	for(int i=0; i<row; i++)
	{
		for(int j=0; j<col; j++)
		{
			printf("Dwse to stoixeio [%d, %d]:", i,j);
			matrix[i][j]=GetLong();
		}
	}

	Create_Array(row,col,matrix); //Create another array with matrix's elements. b is 1d table
}

void Create_Array(int row, int col, long matrix[row][col])
{
	long b[row*col];
	int ctr=0;

	for(int i=0; i<row; i++)
	{
		for(int j=0; j<col; j++)
		{
			b[ctr]=matrix[i][j];
			ctr++;
		}
	}

	Print_Array(ctr-1, b, row,col); //In the last loop ctr increased one more time and i correct it
}

void Print_Array(int row, long matrix[row], int dimens1, int dimens2)
{
	int decision,ctr=0;

	printf("Chose horizontal or matrix appearance(0/1)");
	decision=GetInteger();

	if(decision)
	{
		for(int i=0; i<dimens1; i++)
		{
			for(int j=0; j<dimens2; j++)
			{
				printf("%ld ", matrix[ctr]);
				ctr++;
			}
			printf("\n");
		}
	}
	else
	{
		for(int i=0; i<dimens1; i++)
		{
			for(int j=0; j<dimens2; j++)
			{
				printf("%ld ", matrix[ctr]);
				ctr++;
			}
	     }
	}
}
