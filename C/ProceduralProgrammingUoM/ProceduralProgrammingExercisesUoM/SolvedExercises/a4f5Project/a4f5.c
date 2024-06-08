#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#define axia1 25000
#define axia2 15000
#define axia3 32000
#define axia4 21000
#define axia5 9200
#define P 4
#define S 5

int main()
{

	long matrix1[P],proi[S],x;
	double matrix2[P];

	for(int i=0; i<P; i++)
	{

			matrix1[i]=0;
			matrix2[i]=0;
	}

	for (int i=0; i<S;i++)
	{
		proi[i]=0;
	}

	for(int i=0; i<P; i++)
	{

		for (int j=0; j<S; j++)
		{
			printf("Dwse polisi %dou proiontos gia ton %do politi:",j+1,i+1);
			if(j==0)
			{
				x=GetLong();
				proi[j]+=x;
				matrix1[i]+= x*axia1;

			}
			else if(j==1)
			{
				x=GetLong();
				proi[j]+=x;
				matrix1[i]+= x*axia2;

			}
			else if(j==2)
			{
				x=GetLong();
				proi[j]+=x;
				matrix1[i]+= x*axia3;

			}
			else if(j==3)
			{
				x=GetLong();
				proi[j]+=x;
				matrix1[i]+= x*axia4;
			}
			else
			{
				x=GetLong();
				proi[j]+=x;
				matrix1[i]+= x*axia5;
			}
		}
		matrix2[i]+=0.1*matrix1[i];
	}

	//Output

	printf("Synoliko Poso Eispraksis / Pwlhth: ");
	for(int i=0; i<P; i++)
	{
		printf("%ld ",matrix1[i]);
	}
	printf("\n");

	printf("Promitheia / Pwlhth: ");
	for(int i=0; i<P; i++)
	{
		printf("%.2f ",matrix2[i]);
	}
	printf("\n");

	printf("Posothtes proiontwn: ");
	for(int i=0; i<S; i++)
	{
		printf("%ld ",proi[i]);
	}
	printf("\n");

	return 0;
}
