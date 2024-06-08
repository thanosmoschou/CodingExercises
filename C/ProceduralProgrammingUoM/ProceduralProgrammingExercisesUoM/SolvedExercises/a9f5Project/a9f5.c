#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

#define M 50
#define N 50

//Function declaration
void Read_Array(int m, int n, long matrix[m][n]);
void Find_Min_of_Rows(int row, int col, long matrix[row][col], long b[row]);
void Print_Min_Array(int row, long b[row]);


int main()
{
	int m,n;
	long matrix[M][N], b[M];

	//Input
	printf("Dwse thn timh tou m:");
	m=GetInteger();

	printf("Dwse thn timh tou n:");
	n=GetInteger();

	//Computation and output in combination with functions

	Read_Array(m,n,matrix);
	Find_Min_of_Rows(m,n,matrix,b);
	Print_Min_Array(m,b);



	return 0;
}


//Function definition
void Read_Array(int m, int n, long matrix[m][n])
{
	for (int i=0; i<m; i++)
	{
		for(int j=0; j<n; j++)
		{
			printf("Dwse to stoixeio [%d,%d]", i,j);
			matrix[i][j]=GetLong();
		}
	}
}


void Find_Min_of_Rows(int row, int col, long matrix[row][col], long b[row])
{
	for(int i=0; i<row; i++)
	{
		b[i]=matrix[i][0]; //Afou thelo min stoixeio kathe grammis arxikopoio to proto kathe grammis dil ton i,0 kai thn mesa for thn arxizo apo 1 gia 1 ligoteri epanalipsi
		for(int j=1; j<col; j++)
		{
			if(matrix[i][j]<b[i])
			{
				b[i]=matrix[i][j];
			}
		}
	}
}

void Print_Min_Array(int row, long b[row])
{
	for(int i=0; i<row; i++)
	{
		printf("%ld\n",b[i]);
	}
}
