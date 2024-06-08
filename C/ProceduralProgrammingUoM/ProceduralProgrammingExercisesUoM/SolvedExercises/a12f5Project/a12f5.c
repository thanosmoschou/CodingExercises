#include<stdio.h>
#include "genlib.h"
#include "simpio.h"
#define M 30
#define N 10

//Function declaration
void Give_grades(int row, int col, double matrix[row][col]);
void print_results(int row, int col, double matrix[row][col]);




int main()
{
	double results[M][N];
	int num_stud, them;

	printf("Dwse ton arithmo twn mathitwn: ");
	num_stud=GetInteger();

	printf("Dwse ton arithmo twn thematwn: ");
	them=GetInteger();

	Give_grades(num_stud, them, results);



	return 0;
}


//Function definition

void Give_grades(int row, int col, double matrix[row][col])
{
	int i,j;

	for(i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			printf("Dwse th bathmologia tou %dou thematos tou %dou mathiti:", j+1 , i+1 );
			matrix[i][j]=GetReal();
		}
	}

	print_results(row,col, matrix);

}


void print_results(int row, int col, double matrix[row][col])
{
	int i,j;

	for(i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			printf("%6.1f", matrix[i][j]); //tupono se 100 vathmia klimaka
		}
		printf("\n");

		for(j=0; j<col; j++)
		{
			printf("%6.1f", matrix[i][j]*0.2); //tupono se 20 vathmia klimaka
		}
		printf("\n");
	}
}
