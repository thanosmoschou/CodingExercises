#include<stdio.h>
#include "genlib.h"
#include "simpio.h"

#define Rows 20
#define Columns 20

//Function declaration
void populate_data(int row, int col, int matrix[row][col]);
void print_array(int row, int col, int matrix[row][col], bool result);
void change_array(int row, int col, int matrix[row][col]);


int main()
{
	int R,C, matrix[Rows][Columns];


	printf("Dwse ton arithmo twn grammwn: ");
	scanf("%d", &R);

	printf("Dwse ton arithmo twn sthlwn: ");
	scanf("%d", &C);

	populate_data(R,C,matrix);
	change_array(R, C, matrix);

	return 0;
}


//Function definition
void populate_data(int row, int col, int matrix[row][col])
{
	int i,j;

	for (i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			matrix[i][j]= rand() % 100;
		}
	}

	print_array(row, col, matrix, 0);
}

void print_array(int row, int col, int matrix[row][col], bool result)
{
	int i,j;

	if(result)
	{
		printf("ALLAGMENOS PINAKAS \n");
	}
	else
	{
		printf("ARXIKOS PINAKAS\n");
	}

	for(i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			printf("%4d", matrix[i][j]);
		}

		printf("\n");
	}

}

void change_array(int row, int col, int matrix[row][col])
{
	int i,j,max[row], index[row];

	for(i=0; i<row; i++)
	{
		max[i]= matrix[i][0];  //kratao max kai sthn thesi tou oste ta  stoixia aristera tou max na ginoun isa me to max ara meta thelo for na paei mexri to index(thn thesi tou)
		index[i]=0;

		for(j=1; j<col; j++)
		{
			if(matrix[i][j]> max[i])
			{
				max[i]= matrix[i][j];
				index[i]=j;
			}
		}
	}

	for(i=0; i<row; i++)
	{
		for(j=0; j<index[i]; j++) //thelo ta stoixeia ths tade grammis pou einai aristera tou max ths na ginoun isa me to max ara pao mexri prin to index tou max
		{
			matrix[i][j]=max[i];
		}
	}

	print_array(row, col, matrix, 1);
}
