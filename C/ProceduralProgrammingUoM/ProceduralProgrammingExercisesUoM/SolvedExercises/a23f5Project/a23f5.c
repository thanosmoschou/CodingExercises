#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

#define size1 4


int main()
{
	int tab1[size1]  , tab2[size1] , i , j , ResTab[size1][size1], sum;

	for(i=0; i<2*size1; i++)
	{
		/*anti na kathomai na exo 2 for pou vazo stoixeia se pinakes 4x4 ara 4 loops kathe for kano mia for pou kanei 8 epanalhpseis
		kai se mia if leo an einai o deiktis mikroteros tou 4 eimai ston 1o pinaka ara emfanizo to analogo minima kai vazo sthn
		analogi thesi to stoixeio.An tora perasei to megethos tou prwtou pinaka (dil i>=4) o deiktis shmainei pos eimai ston 2o pinaka ara
		thelo na emfaniso allo minima tora kai na valo ta stoixeia ston 2o pinaka. Tora omos o deiktis exei alllo megethos pou vgainei
		ektos orion ara prepei na to diorthoso me index-4 opou index to noumero pou exei to i mou kai 4 oi theseis tou prohgoumenou
		pinaka. Opote an i=7 tote i-4=3 ara stin teleutaia thesi tou 2ou pinaka vazo stoixeio*/
		//Input

		if(i<4)
		{
			printf("Insert setA num %d:", i);
			tab1[i]=GetInteger();
		}
		else
		{
			printf("Insert setB num %d:", i-size1);
			tab2[i-size1]=GetInteger();
		}
	}

	//Computation
	sum=0;
	for(j=0; j<size1; j++) //Ulopoihsh kata stiles...des information gia to endiaferon tetragono
	{
		sum += (tab1[j] + tab2[j]);
		for(i=0; i<size1; i++)
		{
			ResTab[j][i] = tab1[j] + tab2[i];
		}
	}

	//Output
	printf("Sum: %d\n", sum);
	for(j=0 ; j<size1; j++)
	{
		for(i=0; i<size1; i++)
		{
			printf("%6d", ResTab[i][j]);
		}
		printf("\n");
	}

	return 0;
}
