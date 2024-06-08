#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#define ATHLITES 8

void InputGrades(int row, float Grades[]);
void FindMax(int row, float Grades[], float *max);
void FindAvg(int row, float Grades[], float *avg);
void ypologismosEpityxontwn(int row, float Grade1[], float Grade2[], float Grade3[], int Code[]);
void print(int code, float sum);


int main()
{
	//Πίνακας που περιλαμβάνει τους τριψήφιους κωδικούς αθλητών
	 int kwdikoiAthlitwn[ATHLITES] = {115, 136, 187, 254, 281, 290, 301, 314};

	//Πίνακες που περιλαμβάνουν τη βαθμολογία σε 3 αγωνίσματα
	float vathmologiaKolymbi[ATHLITES];
	float vathmologiaPodilato[ATHLITES];
	float vathmologiaTreximo[ATHLITES];

	float maxKolymbi, maxPodilato, maxTreximo;
	float avgKolymbi, avgPodilato, avgTreximo;

	//Ανάγνωση βαθμολογίας κάθε αθλήματος από το χρήστη
	printf("EISAGWGI VATHMOLOGIAS ATHLIMATOS 1 - Kolymbi\n");
	InputGrades(ATHLITES,vathmologiaKolymbi);

	printf("EISAGWGI VATHMOLOGIAS ATHLIMATOS 2 - Podilato\n");
	InputGrades(ATHLITES,vathmologiaPodilato);

	printf("EISAGWGI VATHMOLOGIAS ATHLIMATOS 3 - Treximo\n");
	InputGrades(ATHLITES,vathmologiaTreximo);

	 //Υπολογισμός μέγιστης βαθμολογίας κάθε αθλήματος
	FindMax(ATHLITES,vathmologiaKolymbi, &maxKolymbi);

	FindMax(ATHLITES,vathmologiaPodilato, &maxPodilato);

	FindMax(ATHLITES,vathmologiaTreximo, &maxTreximo);

	printf("Megistes vathmologies: %.1f (Kol) %.1f (Pod) %.1f (Trex) \n", maxKolymbi, maxPodilato, maxTreximo);


	//Υπολογισμός μέσου όρου βαθμολογίας κάθε αθλήματος
	FindAvg(ATHLITES,vathmologiaKolymbi, &avgKolymbi);

	FindAvg(ATHLITES,vathmologiaPodilato, &avgPodilato);

	FindAvg(ATHLITES,vathmologiaTreximo, &avgTreximo);

	printf("Mesoi oroi: %.1f (Kol) %.1f (Pod) %.1f (Trex) \n",avgKolymbi, avgPodilato, avgTreximo);

	ypologismosEpityxontwn(ATHLITES, vathmologiaKolymbi, vathmologiaPodilato, vathmologiaTreximo, kwdikoiAthlitwn);
	system("PAUSE");

}

void InputGrades(int row, float Grades[])
{
	int i;

	for(i=0; i<ATHLITES; i++)
	{
		printf("Eisagete ti vathmologia tou athliti %d: ", i);
		Grades[i] = GetReal();
	}
	printf("\n");

}

void FindMax(int row, float Grades[], float *max)
{
	int i;

	*max=Grades[0];
	 for(i=1; i<row; i++)
	 	if(Grades[i] > (*max)) *max = Grades[i];
}

void FindAvg(int row, float Grades[], float *avg)
{
	int i;

	*avg = 0;
	for(i=0; i<row; i++)
		*avg += Grades[i];
	*avg/=row;

}

void ypologismosEpityxontwn(int row, float Grade1[], float Grade2[], float Grade3[], int Code[])
{
	int i;
	float sum[row];

	for(i=0; i<row; i++)
	{
		sum[i]=0;
		sum[i]+=(Grade1[i]+Grade2[i]+Grade3[i]);
		sum[i]/=3;
	}

	printf("Epitixontes athlites:\n");
	for(i=0; i<row; i++)
		if(sum[i]>5) print(Code[i], sum[i]);
}

void print(int code, float sum)
{
	printf("%d %.2f\n", code, sum);
}
