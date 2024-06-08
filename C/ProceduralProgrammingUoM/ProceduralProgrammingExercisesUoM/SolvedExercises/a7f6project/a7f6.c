#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#define DIMEN1 100
#define DIMEN2 3
#define TICKETGR 7.5
#define TICKETCY 8.5

//Func declar

void Filling(int row, int col,int Gre,int Cyp, double matrix[row][col], double tickgr, double tickcyp);
void CalcAvgCity(int row, int col, int roomgr, int roomcy, double matrix[row][col], double AvgR[]);
void CalcAvgMonth(int row, int col, int roomgr, int roomcy, double matrix[row][col], double AvgC[2][col]);
void FindMinProfit(int row, int col, int roomgr, int roomcy, double matrix[row][col], double *mingr, int *mongr, double *minc, int *monc,int *citgr, int *citc);
void 	PrintProf(int row, int col, int roomgr, int roomc, double matrix[row][col],int countr);
void 	PrintStat(int row, int col,int roomgr,int roomc,double matrix1[],double matrix2[2][col],int countr, double mingr, int mongr, double minc, int monc,int citgr, int citc);



int main()
{
	int Rgre, Rcyp, monthgr,monthcy,citgr,citcy;
	double Cinema[DIMEN1][DIMEN2],AvgR[DIMEN1] ,AvgC[2][DIMEN2],mingr, mincyp;

	//Input from user
	printf("Give the number of rooms in Greece:");
	Rgre= GetInteger();
	printf("Give the number of rooms in Cyprus:");
	Rcyp=GetInteger();


	Filling(DIMEN1, DIMEN2,Rgre, Rcyp, Cinema, TICKETGR,TICKETCY);
	CalcAvgCity(DIMEN1, DIMEN2, Rgre, Rcyp, Cinema, AvgR);
	CalcAvgMonth(DIMEN1, DIMEN2, Rgre, Rcyp, Cinema, AvgC);
	FindMinProfit(DIMEN1,DIMEN2,Rgre,Rcyp,Cinema, &mingr, &monthgr, &mincyp, &monthcy,&citgr, &citcy);
	PrintProf(DIMEN1,DIMEN2,Rgre,Rcyp,Cinema,1);
	PrintStat(DIMEN1,DIMEN2,Rgre,Rcyp,AvgR,AvgC,1,mingr,monthgr,mincyp,monthcy,citgr,citcy);
	PrintProf(DIMEN1,DIMEN2,Rgre,Rcyp,Cinema,2);
	PrintStat(DIMEN1,DIMEN2,Rgre,Rcyp,AvgR,AvgC,2,mingr,monthgr,mincyp,monthcy,citgr,citcy);


	return 0;
}


//Func definit

void Filling(int row, int col,int Gre,int Cyp, double matrix[row][col], double tickgr, double tickcyp)
{
	int i,j;

	printf("Tickets in Greece\n");
	for(i=0; i<Gre; i++)
	{
		for(j=0; j<col; j++)
		{
			printf("Give tickets: [%d][%d]: ", i,j);
			matrix[i][j]= (GetInteger()*tickgr);
		}
	}

	printf("Tickets in Cyprus\n");
	for(i=Gre; i<Gre+Cyp; i++)
	{
		for(j=0; j<col; j++)
		{
			printf("Give tickets: [%d][%d]: ", i-Gre,j);
			matrix[i][j]= (GetInteger()*tickcyp);
		}
	}
}

void CalcAvgCity(int row, int col, int roomgr, int roomcy, double matrix[row][col], double AvgR[])
{
	int i,j;

	for(i=0; i<roomgr+roomcy; i++)
	{
		AvgR[i]=0;
		for(j=0; j<col; j++)
		{
			AvgR[i]+=matrix[i][j];
		}
		AvgR[i]/=col;
	}
}

void CalcAvgMonth(int row, int col, int roomgr, int roomcy, double matrix[row][col], double AvgC[2][col])
{
	int i,j;

	for(j=0; j<col; j++)
	{
		AvgC[0][j]=0;
		for(i=0;i<roomgr; i++)
		{
			AvgC[0][j]+= matrix[i][j];
		}
		AvgC[0][j]/=(roomgr);
	}

	for(j=0; j<col; j++)
	{
		AvgC[1][j]=0;
		for(i=roomgr;i<roomgr+roomcy; i++)
		{
			AvgC[1][j]+= matrix[i][j];
		}
		AvgC[1][j]/=(roomcy);
	}

}

void FindMinProfit(int row, int col, int roomgr, int roomcy, double matrix[row][col], double *mingr, int *mongr, double *minc, int *monc,int *citgr, int *citc)
{
	int i,j;

	*mingr=matrix[0][0];
	*mongr=0;
	*citgr=0;

	for(i=0; i<roomgr; i++)
	{
		for(j=0; j<col; j++)
		{
			if(matrix[i][j]<(*mingr))
			{
				*mingr= matrix[i][j];
				*mongr=j;
				*citgr=i;
			}
		}
	}

	*minc= matrix[roomgr][0];
	*monc=0;
	*citc=0;
	for(i=roomgr; i<roomcy+roomgr; i++)
	{
		for(j=0; j<col; j++)
		{
			if(matrix[i][j]<(*minc))
			{
				*minc= matrix[i][j];
				*monc=j;
				*citc=i-roomgr;
			}
		}
	}
}

void PrintProf(int row, int col, int roomgr, int roomc, double matrix[row][col],int countr)
{
	int i,j;



	if(countr==1)
	{
		printf("\n");
		printf("Cinema revenues in Greece \n");
		for(i=0; i<roomgr; i++)
		{
			printf("City %d:", i);
			for(j=0; j<col; j++)
			{
				printf(" %6.2f", matrix[i][j]);
			}
			printf("\n");
		}
	}
	else
	{
		printf("Cinema revenues in Cyprus \n");
		for(i=roomgr; i<roomgr+roomc; i++)
		{
			printf("City %d:", i-roomgr);
			for(j=0; j<col; j++)
			{
				printf(" %6.2f", matrix[i][j]);
			}
			printf("\n");
		}
	}

	printf("\n");
}

void PrintStat(int row, int col,int roomgr,int roomc,double matrix1[],double matrix2[2][col],int countr, double mingr, int mongr, double minc, int monc,int citgr, int citc)
{
	int i;

//	printf("\n");
	if(countr==1)
	{
		printf("Statistics in Greece\n");
		printf("Cities average revenues\n");
		for(i=0; i<roomgr; i++)
		{
			printf("%d: %6.2f \n",i,matrix1[i]);
		}
		printf("Months average revenues \n");
		for(i=0;i<col; i++)
		{
			printf("Month %d: %6.2f \n",i,matrix2[0][i]);
		}
		printf("Min revenue: %6.2f \n",mingr);
		printf("City: %d \n",citgr);
		printf("Month: %d \n\n",mongr);

	}
	else
	{
		printf("Statistics in Cyprus\n");
		printf("Cities average revenues\n");
		for(i=roomgr; i<roomgr+roomc; i++)
		{
			printf("%d: %6.2f \n",i-roomgr,matrix1[i]);
		}

		printf("Months average revenues \n");
		for(i=0;i<col; i++)
		{
			printf("Month %d: %6.2f \n",i,matrix2[1][i]);
		}
		printf("Min revenue: %6.2f \n",minc);
		printf("City: %d \n",citc);
		printf("Month: %d \n\n",monc);
	}
}

