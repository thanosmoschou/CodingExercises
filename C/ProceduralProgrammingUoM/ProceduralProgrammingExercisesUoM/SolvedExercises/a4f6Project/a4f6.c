#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#define DIM1 3
#define DIM2 3


//Func decl
void FillMatrix(int row, int col, int matrix[row][col]);
void FindMax(int row, int col, int matrix[row][col],int *max, int *i, int *j);


int main()
{
	int matrix[DIM1][DIM2], max, indexi, indexj;

	FillMatrix(DIM1,DIM2, matrix);
	FindMax(DIM1, DIM2, matrix, &max,  &indexi, &indexj);

	printf("The max element is %d in position [%d,%d]", max, indexi, indexj);

	return 0;
}

//Func definition
void FillMatrix(int row, int col, int matrix[row][col])
{
	int i,j;

	for(i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			printf("Insert the [%d,%d] element of the matrix: ", i,j);
			matrix[i][j]=GetInteger();
		}
	}

}


void FindMax(int row, int col, int matrix[row][col],int *max, int *i, int *j)
{
	int k,l;
	*max= matrix[0][0];
	*i=*j=0;

	for(k=0; k<row; k++)
	{
		for(l=0; l<col; l++)
		{
			if(matrix[k][l]> *max)
			{
				*max= matrix[k][l];
				*i=k;
				*j=l;
			}
		}
	}
}
