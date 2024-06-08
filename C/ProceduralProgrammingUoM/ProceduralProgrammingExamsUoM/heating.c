#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include"simpio.h"
#include"genlib.h"

#define M 6
#define HEATERS 4
#define HEATSIZE 80
#define NSIZE 15

//Structure definition

typedef struct
{
    int sBT;
    int SCod;
    float SCon;
    int SClass;
    char name[NSIZE];
}heatSysT;
//Function prototypes
int computeEnergyClass(float sCons, int sBtu);
void fillTable(int row, heatSysT Heat[],int DIM, float SCon[DIM], int SBT[DIM], int SCod[DIM], int SClass[DIM], int *ctr, char sBrand[DIM][NSIZE]);
void  buildingBTUCons( int row, float Cons[], int BTU[], int *SumBT, float *SumCons);
void importNewHeaters(FILE *infile, int row, heatSysT Heat[], int *ctr);

//Main function
int main(){

   FILE *infile1, *infile2;
   float sysCons[M] = {234.2, 135.4, 222.4, 90.4, 340.4, 310.0};
   int sysBTU[M] = {2000, 1500, 3000, 2500, 4000, 3500};
   int sysCode[M] = {1222,1344,2234,5556,2221,3334};
   char sysBrand[M][15] = {"FumitsuA", "Noheat","FumitsuB","Varrier","TokibaA", "TokibaB"};

   int building[HEATERS] = {1222,1344,2234,3334};
   int buildingBTU[HEATERS];
   float buildingCons[HEATERS];
   int i, systemClass[M], ctr=0,j,index,found;
   int sumBTU=0;
   float sumCons=0;
   heatSysT heatersTab[HEATSIZE];


   infile1=fopen("heaters1.txt", "r");
   if(infile1==NULL)
   {
       printf("Problem with file %s\nExecution terminated.", "heaters1.txt");
       exit(1);
   }

   infile2=fopen("heaters2.txt", "r");
   if(infile2==NULL)
   {
       printf("Problem with file %s\nExecution terminated.", "heaters2.txt");
       exit(1);
   }

   for(i=0; i<M; i++)
   {
       systemClass[i]=computeEnergyClass(sysCons[i], sysBTU[i]);
       printf("Heater Code: %d, BTU: %d, Consumption: %5.1f  class: %d\n", sysCode[i], sysBTU[i],sysCons[i], systemClass[i]);
   }

	for(i=0; i<4; i++)
	{
		found=0;
		for(j=0; j<M; j++)
		{
			if(building[i]==sysCode[j])
			{
				found=1;
				index=j;
				//break;
			}
		}
		if(found)
		{
			buildingBTU[i]=sysBTU[index];
			buildingCons[i]=sysCons[index];
		}
	}

    fillTable(HEATSIZE, heatersTab, M, sysCons, sysBTU, sysCode, systemClass, &ctr, sysBrand);

    buildingBTUCons(HEATERS, buildingCons, buildingBTU, &sumBTU, &sumCons);

    for(i=0; i<30; i++)
        printf("*");
    printf("\n");

    printf("Building has total BTU %d and total consumption %.1f\n", sumBTU,sumCons);

    for(i=0; i<30; i++)
        printf("*");
    printf("\n");


    importNewHeaters(infile1, HEATSIZE, heatersTab, &ctr);
    importNewHeaters(infile2, HEATSIZE, heatersTab, &ctr);


    for(i=0; i<ctr; i++)
        printf("Heater Name: %15s Code: %d, BTU: %d, Consumption: %5.1f Class:%d\n", heatersTab[i].name, heatersTab[i].SCod,  heatersTab[i].sBT,  heatersTab[i].SCon,  heatersTab[i].SClass);

    fclose(infile1);
    fclose(infile2);
    system("pause");
   return 0;
}


//Function declaration

int computeEnergyClass(float sCons, int sBtu)
{
    if(sBtu>=2000 && sCons<300)
        return 1;
    else if(sCons>=300)
        return 2;
    else
        return 3;
}

void fillTable(int row, heatSysT Heat[],int DIM, float SCon[DIM], int SBT[DIM], int SCod[DIM], int SClass[DIM], int *ctr, char sBrand[DIM][NSIZE])
{
    int i;

    for(i=0; i<DIM; i++)
    {
       Heat[*ctr].sBT= SBT[i];
       Heat[*ctr].SCon=SCon[i];
       Heat[*ctr].SCod= SCod[i];
       Heat[*ctr].SClass= SClass[i];
       strcpy(Heat[*ctr].name, sBrand[i]);
       (*ctr)++;
    }
}


void  buildingBTUCons( int row, float Cons[], int BTU[], int *SumBT, float *SumCons)
{
    int i;

    for(i=0; i<row; i++)
    {
        (*SumBT)+= BTU[i];
        (*SumCons)+= Cons[i];
    }
}

void importNewHeaters(FILE *infile, int row, heatSysT Heat[], int *ctr)
{
    int line=0,thingsscan;
    char termch;
    int code,btu;
    float cons;
    char n[15];

    while(TRUE)
    {
        thingsscan=fscanf(infile,"%d,%14[^,], %d, %f%c", &code, n, &btu, &cons, &termch);

        if(thingsscan==EOF)
            break;

        if(thingsscan!=5 || termch!='\n')
        {
            printf("Problem in line %d\n", line);
            exit(1);
        }
        line++;
        n[strlen(n)]='\0';

        if(thingsscan!=EOF)
        {
            strcpy(Heat[*ctr].name, n);
            Heat[*ctr].SCod=code;
            Heat[*ctr].SCon=cons;
            Heat[*ctr].sBT=btu;
            Heat[*ctr].SClass=computeEnergyClass(cons, btu);
            (*ctr)++;
        }
    }
}

