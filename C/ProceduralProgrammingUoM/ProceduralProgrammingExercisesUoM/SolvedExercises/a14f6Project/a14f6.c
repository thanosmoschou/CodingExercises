#include<stdio.h>
#include<math.h>
#include"genlib.h"
#include"simpio.h"
#define STUDENTS 30
#define COURSES 3

//Func declar
void CalcGrades(int row, int col, int table1[row][col]);
void CalcGpa(int row, int col, int table1[row][col], double table2[]);
void PrintGrades(int row, int col, int table1[row][col], double table2[]);
void FindPercentage(int row, double table1[], int *arisnum, double *posarist, int *oxiar, double *posoxiar );


int main()
{
	int grades[STUDENTS][COURSES], aristnum, oxiarist;
	double gpa[STUDENTS], posarist, posoxiar;


	CalcGrades(STUDENTS, COURSES, grades);
	CalcGpa(STUDENTS, COURSES, grades, gpa);
	PrintGrades(STUDENTS, COURSES, grades, gpa);
	FindPercentage(STUDENTS, gpa, &aristnum, &posarist, &oxiarist, &posoxiar);

	printf("Apotyxontes: %d\n", oxiarist);
	printf("Pososto apotyxonton: %5.2f %%\n", posoxiar);
	printf("Aristouxoi: %d\n", aristnum);
	printf("Pososto aristouxwn: %5.2f %%\n", posarist);

	return 0;
}

//Func defin

void CalcGrades(int row, int col, int table1[row][col])
{
	int i,j;

	for(i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			table1[i][j]= rand() % 21;
		}
	}
}


void CalcGpa(int row, int col, int table1[row][col], double table2[])
{
	int i,j;

	for(i=0; i<row; i++)
	{
		table2[i]=0;
		for(j=0; j<col; j++)
		{
			table2[i] += table1[i][j];
		}
		table2[i] /=3;
	}
}

void PrintGrades(int row, int col, int table1[row][col], double table2[])
{
	int i,j;

	for(i=0; i<row; i++)
	{
		printf("%2d: ", i+1);
		for(j=0; j<col; j++)
		{
			printf("%3d", table1[i][j]);
		}
		printf(" : %5.2f\n", table2[i]);
	}
}

void FindPercentage(int row, double table1[], int *arisnum, double *posarist, int *oxiar, double *posoxiar )
{
	int i;

	*arisnum=*oxiar=0;

	for(i=0; i<row; i++)
	{
		if (table1[i]>= 18.5)
		{
			(*arisnum)++;
		}

		if(table1[i]< 9.5)
		{
			(*oxiar)++;
		}
	}



	*posarist= (*arisnum/(double)row)*100;
	*posoxiar= (*oxiar/ (double)row)*100;

}
