#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#define N 3
#define CLUES 4

//Func declar
void ReadData(int row, int col, int tab[row][col]);
void FindMean(int row, int col, int tab[row][col] , int index, double *avgm, double *avgw);


int main()
{
	int Users[N][CLUES],i;
	double avg[3][2];

	//Filling the matrix
	ReadData(N, CLUES, Users);

	//Computation
	int ctr=1;
	for(i=0; i<3; i++)
	{
		FindMean(N, CLUES, Users, ctr, &avg[i][0], &avg[i][1]);
		ctr++;
	}

	//Output

	printf("Average males weight: %.1f\n", avg[0][0]);
	printf("Average womens weight: %.1f\n", avg[0][1]);
	printf("Average males height: %.1f\n", avg[1][0]);
	printf("Average womens height: %.1f\n", avg[1][1]);
	printf("Average males age: %.1f\n", avg[2][0]);
	printf("Average womens age: %.1f\n", avg[2][1]);


	return 0;
}


//Func definit

void ReadData(int row, int col, int tab[row][col])
{
	int i,j;

	for(i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			switch(j)
			{
				case 0:
					printf("Insert gender (0 for male / 1 for women) : ");
					scanf("%d", &tab[i][j]);
					break;
				case 1:
					printf("Insert weight (to kg) : ");
					scanf("%d", &tab[i][j]);
					break;
				case 2:
					printf("Insert height (to cm) : ");
					scanf("%d", &tab[i][j]);
					break;
				case 3:
					printf("Insert age: ");
					scanf("%d", &tab[i][j]);
					break;
			}
		}
		printf("------\n");
	}
}

void FindMean(int row, int col, int tab[row][col] , int index, double *avgm, double *avgw)
{
	int i, sumMal, sumFem;

	//Initialization
	(*avgm)=(*avgw)=sumMal=sumFem=0;

	if(index==1)
	{
		for(i=0; i<row; i++)
		{

			if(tab[i][0]) //If gender is female i increase thefe males' total weight so i can divide it by the number of females and find the average weight..The same for males
			{
				(*avgw)+= tab[i][1];
				sumFem++;

			}
			else
			{
				(*avgm)+= tab[i][1];
				sumMal
				++;
			}

		}
	}
	else if(index==2)
	{
		for(i=0; i<row; i++)
		{

			if(tab[i][0]) //If gender is female i increase thefe males' total weight so i can divide it by the number of females and find the average weight..The same for males
			{
				(*avgw)+= tab[i][2];
				sumFem++;

			}
			else
			{
				(*avgm)+= tab[i][2];
				sumMal
				++;
			}
		}
	}
	else if(index==3)
	{
		for(i=0; i<row; i++)
		{

			if(tab[i][0]) //If gender is female i increase thefe males' total weight so i can divide it by the number of females and find the average weight..The same for males
			{
				(*avgw)+= tab[i][3];
				sumFem++;

			}
			else
			{
				(*avgm)+= tab[i][3];
				sumMal
				++;
			}

		}
	}

	*avgm = ((double)(*avgm)/ sumMal); //Find the average with percentage
	*avgw = ((double)(*avgw)/ sumFem);
}
