#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
#define DIM 20
#define SURNAME 16
#define AREA 4


//Structure declaration
typedef struct
{
	int code;
	char surname[SURNAME];
	long total;
	int area;
}salesmen;

//Function declaration
void Fill_Data(int D, int row, salesmen Pol[]);
void Find_Sum(int D, int row, salesmen Pol[], long *Sales);
void Print_Data(int D, int row, salesmen Pol[], long *Sales);


int main()
{
	int sal;
	long *Sum;
	salesmen Pol[DIM];

	printf("Give the amount of salesmen: ");
	scanf("%d", &sal);

	Fill_Data(DIM,sal,Pol);
	Sum=(long *)calloc(AREA, sizeof(long));

	Find_Sum(DIM,sal,Pol,Sum);
	Print_Data(DIM,sal,Pol,Sum);

	free(Sum);
	system("PAUSE");
	return 0;
}


//Function definition

void Fill_Data(int D, int row, salesmen Pol[])
{
	int i;

	for(i=0; i<row; i++)
	{
		Pol[i].code=i+1;
		printf("Give the surname of employee No. %d: ", i+1);
		scanf(" %[^\n]s", &Pol[i].surname);
		printf("Give the total price of sales: ");
		scanf(" %ld", &Pol[i].total);
		printf("Give the area of the employee(1= Thes/niki, 2= Athens, 3= Volos, 4= Hrakleio): ");
		scanf(" %d", &Pol[i].area);
	}
}

void Find_Sum(int D, int row, salesmen Pol[], long *Sales)
{
	int i;

	for(i=0; i<row; i++)
	{
		if(Pol[i].area==1) Sales[0]+=Pol[i].total;
		else if(Pol[i].area==2) Sales[1]+=Pol[i].total;
		else if(Pol[i].area==3) Sales[2]+=Pol[i].total;
		else if(Pol[i].area==4) Sales[3]+=Pol[i].total;
	}
}

void Print_Data(int D, int row, salesmen Pol[], long *Sales)
{
	long sum=0;
	int i;

	printf("%11s %13s\n", "PERIOXH", "SYN.PWLHSEWN");

	for(i=0; i<48; i++)printf("-");
	printf("\n");

	for(i=0; i<AREA; i++)
	{
		if(i==0) printf("%11s %13ld\n", "Thes/niki", Sales[i]);
		else if(i==1) printf("%11s %13ld\n", "Athens", Sales[i]);
		else if(i==2) printf("%11s %13ld\n", "Volos", Sales[i]);
		else  printf("%11s %13ld\n", "Hrakleio", Sales[i]);
		sum+=Sales[i];
	}

	for(i=0; i<48; i++)printf("-");
	printf("\n");

	printf("%11s %13ld\n", "SYNOLO:", sum);
}
