#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include"genlib.h"
#include"simpio.h"
#define DIMEN1 5
#define DIMEN2 20

//Function declaration
void fillnames(int row, int col, char matrix[row][col]);
void calculate(int row, int col, char matrix[row][col], int *sum);
void printres(int row, int col, char matrix[row][col], int *sum, char initial);


int main()
{
	char names[DIMEN1][DIMEN2];
	int sum;

	fillnames(DIMEN1,DIMEN2,names);
	calculate(DIMEN1,DIMEN2,names,&sum);
	return 0;
}

//Function definition

void fillnames(int row, int col, char matrix[row][col])
{
	int i;

	for(i=0; i<row; i++)
	{
		printf("Give name %d :",i);
		gets(matrix[i]);
	}


}

void calculate(int row, int col, char matrix[row][col], int *sum)
{
	int i;
	char initial;

	printf("\n");
	printf("Give initial char:");
	initial=getchar();

	for(i=0; i<row; i++)
	{
		if(matrix[i][0]==initial) ((*sum)++);
	}

	printres(row,col,matrix,(sum),initial);

}

void printres(int row, int col, char matrix[row][col], int *sum, char initial)
{
	printf("Names starting with %c are: %d\n",initial,*sum);
	if((*sum))
	{
		int i;
		for(i=0; i<row; i++)
		{
			if(matrix[i][0]==initial) printf("%s\n", matrix[i]);
		}
	}

}
