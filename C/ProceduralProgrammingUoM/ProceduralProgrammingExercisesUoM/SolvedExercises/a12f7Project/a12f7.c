#include<stdio.h>
#include<ctype.h>
#include<string.h>
#define DIM 100
#define DIM2 40

void Filling( int rows,int col, char names[rows][col]);
int Validation(int row,int col,int until, char strmess[row][col], char name[]);
int BreakFunc(int row,char name[]);
void Print(int row,int col ,int until, char name[row][col]);



int main()
{
	char  names[DIM][DIM2];

	Filling(DIM,DIM2, names);

	return 0;
}

void Filling( int rows,int col, char names[rows][col])
{
	int ctr=0, flag;

	while(1)
	{
		do
		{
			printf("Passenger in seat %d :", ctr+1);
			scanf(" %[^\n]s", names[ctr]);
			names[ctr][strlen(names[ctr])]='\0';

			if(ctr!=0)
			{
				if((flag=Validation(rows,col, ctr, names, names[ctr])))
					printf("Passenger %s already exists.\n", names[ctr]);
			}

		}while(flag!=0);

		if(BreakFunc(strlen(names[ctr]), names[ctr])==4) break;
		ctr++;
	}

	Print(rows,col,ctr,names);
}

int Validation(int row,int col,int until, char strmess[row][col], char name[])
{
	int counter,i,j;

	for(i=0; i<until; i++)
	{
		counter=0;
		if(strlen(strmess[i])==strlen(name))
			for(j=0; j<strlen(name); j++)
				if(strmess[i][j]==name[j]) counter++;
		if(counter==strlen(name))
			return counter;
	}

	return counter;
}

int BreakFunc(int row,char name[])
{
	int cou=0,i;

	for(i=0; (name[i])!='\0'; i++)
		if((name[i])=='-') cou++;
	return cou;
}

void Print(int row,int col ,int until, char name[row][col])
{
	int i;

	printf("Passenger List\n");
	for(i=0; i<14; i++) printf("-");
	printf("\n");

	for(i=0; i<until; i++)
	{
		printf("In seat %d: %s\n", i+1, (name[i]));
	}
}
