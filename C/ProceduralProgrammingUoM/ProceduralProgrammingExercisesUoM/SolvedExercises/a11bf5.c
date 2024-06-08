#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

#define CTS 10
#define S 3

//Function declaration
void ReadData(int row, int col, double temper[row][col]);
double CalculateAverage(int row, int col, double temper[row][col]);
void CalculateAvCity(int row, int col, double temper[row][col], double average[]);
void CalculateMaxDeviation(double natavg, int row, int col, double temper[row][col],double mdeviation[]);
void Print_Results(double natavg,int row, double average[],double mdeviation[]);


int main()
{
    double  temper[CTS][S];
    double average[CTS], mdeviation[CTS];
    double natavg;


	/*Read all Temperatures*/
    ReadData(CTS,S, temper);

	/*Calculating The Average of all Cities&Temps*/
    natavg=CalculateAverage(CTS,S, temper);

	/*Calculating Average temp on each City*/
	CalculateAvCity(CTS,S,temper, average);

	/*Calculating max Deviation*/
    CalculateMaxDeviation(natavg,CTS,S,temper,mdeviation);

    /*Printing results*/
    Print_Results(natavg,CTS, average, mdeviation);
    return 0;
}


//Function definition
void ReadData(int row, int col, double temper[row][col])
{
    int i,j;
    for (i=0; i<row; i++)
		for (j=0; j<col; j++)
		  	{ printf("Temp of City %d During %d 8-hour period: ",i,j);
              temper[i][j] = GetReal();
              }
}

double CalculateAverage(int row, int col, double temper[row][col])
{
    int i,j;
    double natavg;

    natavg = 0;
    for (i=0; i<row; i++)
      for (j=0; j<col; j+=1)
         natavg += temper[i][j];
    natavg = natavg/(row*col);
    return natavg;

}

void CalculateAvCity(int row, int col, double temper[row][col], double average[])
{
   int i,j;
   for (i=0; i<row; i++)
    {
        average[i] = 0;
        for (j=0; j<col; j++)
        {
            average[i] += temper[i][j];
        }
        average[i] = average[i]/S;
    }

}

void CalculateMaxDeviation(double natavg, int row, int col, double temper[row][col],double mdeviation[])
{
    int i,j;
    double devnat[row][col];

    /*Calculating Standard Deviation*/
    for (i=0; i<CTS; i++)
        for (j=0; j<S; j++)
            devnat[i][j] = fabs(natavg-temper[i][j]);
    for (i=0; i<row; i++)
    {
        mdeviation[i] = devnat[i][0];
        for(j=1; j<col; j++)
            if (mdeviation[i]<devnat[i][j]) mdeviation[i] = devnat[i][j];
    }

}

void Print_Results(double natavg,int row, double average[row],double mdeviation[row])
{
    int i;
    printf("%3.1f\n", natavg);
    for (i=0; i<row; i+=1)
		printf("City %d Average %.1f Deviation %.1f\n",i, average[i], mdeviation[i]);
    system("PAUSE");

}
