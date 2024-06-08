#include<stdio.h>
#include<stdlib.h>
#define DIM 30

//Function declaration
void read_temperatures(int row, float temp[], double *max, double *min, double *avg);


int main()
{
	float temper[DIM];
	double max,min,avg=0;

	read_temperatures(DIM,temper, &max, &min, &avg);

	printf("H megisti thermokrasia einai %.2f\n", max);
	printf("H elaxisti thermokrasia einai %.2f\n", min);
	printf("O mesos oros einai %.2f\n", avg);

	system("PAUSE");
}


//Function definition
void read_temperatures(int row, float temp[], double *max, double *min, double *avg)
{
	int i;

	printf("Dwse tis thermokrasies toy mina:\n");
	for(i=0; i<row; i++)
	{
		printf("Dwse ti thermokrasia %d: ", i);
		scanf("%f", &temp[i]);
	}

	*max= temp[0];
	*min= temp[0];
	*avg+=temp[0];

	for(i=1; i<row; i++)
	{
		if(temp[i]>(*max))
			*max= temp[i];

		if(temp[i]<(*min))
			*min=temp[i];

		*avg+= temp[i];
	}

	*avg/=row;

}
