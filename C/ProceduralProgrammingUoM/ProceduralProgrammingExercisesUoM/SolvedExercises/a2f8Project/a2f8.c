#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>
#define DIMNAME 25
#define MAXDIM 20
#define SUMBILL 5


//Structure declaration

typedef struct
{
	int numhome;
	char namesurname[DIMNAME];
	int sqrmeters;
	int caloriferfetes;
	float thermansi;
	float koinoxrista;
	float total;
}Enoikoi;

//Function declaration
int Fill_Data(int row, Enoikoi Polik[]);
void Sum(int row,int D, Enoikoi Polik[], float *Sum, int rentthings);
void Print(int row, int D,Enoikoi Polik[], float *Sum);


int main()
{
	Enoikoi Polik[MAXDIM];
	int people;
	float *Sinol;

	people=Fill_Data(MAXDIM,Polik); //It returns the amount of people who live in the building

	Sinol=(float *)calloc(SUMBILL,sizeof(float));
	Sum(people,MAXDIM,Polik, Sinol, SUMBILL);
	Print(people,MAXDIM,Polik,Sinol);

	free(Sinol);
	system("PAUSE");
	return 0;
}

//Function declaration

int Fill_Data(int row, Enoikoi Polik[])
{
	int i,rent;

	printf("Dwse to plithos twn enoikwn: ");
	scanf("%d", &rent);

	for(i=0; i<rent; i++)
	{
		Polik[i].numhome=i+1;
		printf("Dwse to poso thermansis:");
		scanf("%f", &Polik[i].thermansi);
		printf("Dwse ta koinoxrista: ");
		scanf("%f", &Polik[i].koinoxrista);
		printf("Dwwse to onomatepwnymo: ");
		scanf(" %25[^\n]s", &Polik[i].namesurname);
		printf("Dwse ta t.m: ");
		scanf("%d", &Polik[i].sqrmeters);
		printf("Dwse tis fetes: ");
		scanf("%d", &Polik[i].caloriferfetes);
		Polik[i].total=Polik[i].koinoxrista+Polik[i].thermansi;
		printf("\n");
	}

	return rent;
}

void Sum(int row, int D, Enoikoi Polik[], float *Sum, int rentthings)
{
	int i,j;

	for(i=0; i<rentthings; i++)
	{
		//Sum[i]=0;
		for(j=0; j<row; j++)
		{
			if(i==0) Sum[i]+=Polik[j].sqrmeters;
			else if(i==1) Sum[i]+= Polik[j].caloriferfetes;
			else if(i==2) Sum[i]+=Polik[j].thermansi;
			else if(i==3) Sum[i]+=Polik[j].koinoxrista;
			else  Sum[i]+=Polik[j].total;
		}
	}
}

void Print(int row, int D, Enoikoi Polik[], float *Sum)
{
	int i;

	printf("%-3s %-26s %-5s %-6s %-12s %-12s %-12s\n", "A/A", "ONOMATEPWNYMO", "T.M", "FETES", "POSO THERM","POSO KOIN.","SYNOLO");
	for(i=0; i<76; i++) printf("-");
	printf("\n");

	for(i=0;i<row; i++)
		printf("%-3d %-24s %8d %3d %12.2f %12.2f %10.2f\n", Polik[i].numhome, Polik[i].namesurname,Polik[i].sqrmeters,Polik[i].caloriferfetes,Polik[i].thermansi,Polik[i].koinoxrista,Polik[i].total);

	for(i=0; i<76; i++) printf("-");
	printf("\n");

	printf("%-29s %5.2f %7.2f %8.2f %8.2f %12.2f\n", "SYNOLA:", Sum[0], Sum[1], Sum[2], Sum[3],Sum[4]);
}
