#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#define dimensions 100


int main()
{
	long matrix[dimensions][dimensions], m,n, sumgr[dimensions],sumst[dimensions],sumdiag[2]={0,0};

	//User gives the dimensions of the matrix
	printf("Dwse ton arithmo twn grammwn: ");
	m=GetLong();

	printf("Dwse ton arithmo twn sthlwn: ");
	n=GetLong();

	for(int i=0; i<m; i++)
	{
		//Initialization
		sumgr[i]=0;

		for(int j=0; j<n; j++)
		{
			printf("Thesi [%d , %d]:", i , j); //Matrix filling with prompt messages
			matrix[i][j]=GetLong();
			sumgr[i]+= matrix[i][j];
		}
	}

	for(int j=0; j<n; j++)
	{
		//Initialization
		sumst[j]=0;

		for (int i=0; i<m; i++)
		{
			sumst[j]+= matrix[i][j];
		}
	}

	if(m==n)
	{
		for(int i=0; i<m; i++)
		{
			sumdiag[0]+=matrix[i][i];
			sumdiag[1]+= matrix[i][m-i-1];
		}
	}

	//Output
	printf("Table:\n");

	for(int i =0; i<m; i++)
	{
		for(int j=0; j<n; j++)
		{
			printf("    %ld", matrix[i][j]);
			if(j==n-1)
			{
				printf(" | = %ld\n", sumgr[i]);
			}
		}
	}
	printf("------------\n");
	for(int i=0; i<n; i++)
	{
		printf("   %ld", sumst[i]);
	}
	if(m==n)
	{
		printf("\n");
		printf("Sum Diag 1: %ld,    Diag 2: %ld", sumdiag[0],sumdiag[1]);
	}


	return 0;
}
