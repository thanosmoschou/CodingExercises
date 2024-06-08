/*Same exercise with a6f8 but more general*/

#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include"genlib.h"
#include"simpio.h"
#define DIM1 20
#define DIM2 15
#define DIM3 30
#define N 50


//Structure declaration
typedef struct
{
	char surn[DIM1];
	char name[DIM2];
	char address[DIM3];
	int pay;
}Patient;



//Function declaration
void Fill_Data(int row, int D, Patient Hosp[]);
Patient Find_Max(int row, int D, Patient Hosp[]);
int Find_Sum(int row, int D, Patient Hosp[]);
bool Find_Pat(int row, int D, Patient Hosp[], char name[DIM3], char surn[DIM3], int *ind);
void Print_Pat(Patient pat);
void Print_Data(char name[DIM3], int row, int D, Patient Hosp[]);



int main()
{
	Patient Hosp1[N], Hosp2[N], maxpat1, maxpat2, finp1,finp2;
	int resu1, resu2;
	int pat1, pat2;
	int sumhosp1,sumhosp2;
	bool res1, res2;
	char name1[DIM3], name2[DIM3];
	char patnam1[DIM3],patnam2[DIM3], patsur1[DIM3], patsur2[DIM3];

	printf("Give the amount of patients for the first Hospital: ");
	pat1=GetInteger();

	printf("Give the amount of patients for the second Hospital: ");
	pat2=GetInteger();

	printf("\n");

	Fill_Data(pat1, N,Hosp1);
	Fill_Data(pat2,N,Hosp2);

	maxpat1=Find_Max(pat1, N, Hosp1);
	maxpat2=Find_Max(pat2,N,Hosp2);

	sumhosp1=Find_Sum(pat1,N,Hosp1);
	sumhosp2=Find_Sum(pat2,N,Hosp2);

	printf("Give the name of the first Hospital: ");
	gets(name1);

	printf("Give the name of the second Hospital: ");
	gets(name2);

	Print_Data(name1,pat1,N,Hosp1);
	Print_Data(name2, pat2,N,Hosp2);

	Print_Pat(maxpat1);
	Print_Pat(maxpat2);

	printf("Max income ");
	if(sumhosp1>sumhosp2) printf("%s %d\n", name1, sumhosp1);
	else printf("%s %d\n\n", name2, sumhosp2);

	printf("Search a patient for %s\n", name1);
	printf("Give last name ");
	gets(patsur1);

	printf("Give first name ");
	gets(patnam1);

	res1=Find_Pat(pat1, N, Hosp1, patnam1, patsur1, &resu1);

	if(res1)
	{
		finp1=Hosp1[resu1];
		Print_Pat(finp1);
	}
	else
		printf("Patient not found.\n");


	printf("Search a patient for %s\n", name2);
	printf("Give last name ");
	gets(patsur2);

	printf("Give first name ");
	gets(patnam2);

	res2=Find_Pat(pat2,N,Hosp2,patnam2,patsur2, &resu2);

	if(res2)
	{
		finp2=Hosp2[resu2];
		Print_Pat(finp2);
	}
	else
		printf("Patient not found.\n");


	return 0;
}

//Function definition

void Fill_Data(int row, int D, Patient Hosp[])
{
	int i;

	for(i=0; i< row; i++)
	{
		printf("Give data patient %d\n", i);

		printf("Last name: ");
		gets(Hosp[i].surn);

		printf("First name: ");
		gets(Hosp[i].name);

		printf("Address: ");
		gets(Hosp[i].address);

		printf("Amount: ");
		Hosp[i].pay= GetInteger();

		printf("\n");
	}

	//printf("\n");

}

void Print_Data(char name[DIM3], int row, int D, Patient Hosp[])
{
	int i;

	for(i=0; i<9; i++)
		printf("-");

	printf("%s", name);

	for(i=0; i<9; i++)
		printf("-");
	printf("\n");

	printf("%-20s %-15s %-29s %-6s \n", "Last name", "First Name", "Address", "Amount");

	for(i=0; i<73; i++) printf("-");
	printf("\n");

	for(i=0; i<row; i++)
		printf("%-20s %-15s %-29s %6d\n", Hosp[i].surn,Hosp[i].name, Hosp[i].address, Hosp[i].pay);

	printf("\n");
}

Patient Find_Max(int row, int D, Patient Hosp[])
{
	Patient max=Hosp[0];
	int i;

	for(i=1; i<row; i++)
	{
		if(Hosp[i].pay>max.pay)
			max=Hosp[i];
	}

	return max;
}

int Find_Sum(int row, int D, Patient Hosp[])
{
	int i,sum=0;

	for(i=0; i<row; i++)
		sum+=Hosp[i].pay;

	return sum;
}

void Print_Pat(Patient pat)
{
	int i;


	printf("%-20s %-15s %-29s %-6s \n", "Last name", "First Name", "Address", "Amount");

	for(i=0; i<73; i++) printf("-");
	printf("\n");

	printf("%-20s %-15s %-29s %6d\n", pat.surn,pat.name, pat.address, pat.pay);

	printf("\n");

}

bool Find_Pat(int row, int D, Patient Hosp[], char name[DIM3], char surn[DIM3], int *ind)
{
	int i,ctr,j;

	for(i=0; i<row; i++)
	{
		ctr=0;
		for(j=0; Hosp[i].name[j]!='\0'; j++)
				if(Hosp[i].name[j]!=name[j] && Hosp[i].surn[j]!=surn[j])ctr++; //Sugkrino ena onoma tis domis me to onoma pros
																												 //anazitisi gramma gramma kai an den exoun diaforetika grammata epistrefo tin thesi pou vrethike meso pointer kai true allios sunexizo me to epomeno onoma tis domis
		if(ctr==0)
		{
			*ind=i;
			return TRUE;
		}
	}

	return FALSE;
}

