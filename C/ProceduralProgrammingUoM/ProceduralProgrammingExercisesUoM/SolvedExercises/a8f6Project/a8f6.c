#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#define DIMENSION1 30
#define DIMENSION2 20

//Func decl
void Filling(int rows, int table[]);
void FrequencyCount(int row1, int row2, int table1[], int table2[]);
void MaxFrequencyFind(int row2, int table2[], int *max,  int *maxfreq);
void 	MinFrequencyFind(int row2, int table2[], int *min, int *minfreq);
void PrintResults(int row1,int row2, int table1[], int table2[], int maxel, int freqmax, int minel, int minfreq );


int main()
{
	int grades[DIMENSION1], frequency[DIMENSION2], maxgr, freqmax, mingr, freqmin;

	Filling(DIMENSION1, grades);
	FrequencyCount(DIMENSION1, DIMENSION2, grades, frequency);
	MaxFrequencyFind(DIMENSION2, frequency,&maxgr, &freqmax);
	MinFrequencyFind( DIMENSION2, frequency, &mingr, &freqmin);
	PrintResults(DIMENSION1, DIMENSION2, grades, frequency, maxgr, freqmax, mingr, freqmin);

	return 0;
}

//Func definit

void Filling(int rows, int table[])
{
	int i;

	for(i=0; i<rows; i++)
	{
		printf("Dwse vathmo %d: ", i+1);
		table[i]= GetInteger();
	}
}


void FrequencyCount(int row1, int row2, int table1[], int table2[])
{
	int i,j;

	for(i=0; i<row2; i++)
	{
		table2[i]=0; //Initialization
	}

	for(j=0; j<row2; j++)
	{
		for(i=0; i<row1; i++)
		{
			if(table1[i]==(j+1)) //An o vathmos ston table1 einai isos me ton antistoixo vathmo j+1 pou upostirizetai apo ton table2 auksano tin suxnothta tou vathmou
			{
				table2[j]++;
			}
		}
	}


}

void MaxFrequencyFind(int row2, int table2[], int *max,  int *maxfreq)
{
	int i=0;

	*max=1;
	*maxfreq= table2[0];//H suxnothta emfanisis tou max
	//index=0;

	for(i=1; i<row2; i++)
	{
		if (table2[i]> *maxfreq)
		{
			//index=i;
			*max= i+1;
			*maxfreq=table2[i];
		}
	}
	//*max= table1[index];
}


void 	MinFrequencyFind(int row2, int table2[], int *min, int *minfreq)
{
	int i=0;

	*min=1;
	*minfreq=table2[0] ; //H suxnothta emfanisis tou min

	for(i=1; i<row2; i++)
	{
		if (table2[i]< *minfreq)
		{
			*min= i+1;
			*minfreq=table2[i];
		}
	}
}

void PrintResults(int row1,int row2, int table1[], int table2[], int maxel, int freqmax, int minel, int minfreq )
{
	int i;

	printf("Syxnotites bathmwn\n");
	for(i=0; i<row2; i++)
	{
		printf("%d: %d \n", i+1, table2[i]);
	}
	printf("Bathmos me th megalyteri syxnotita: %d\n", maxel);
	printf("Syxnotita: %d\n", freqmax);
	printf(" Bathmos me th mikroteri syxnotita: %d\n", minel);
	printf("Syxnotita: %d\n", minfreq);
}
