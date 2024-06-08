#include <stdio.h>

#define SIZE 10 

void sel_sort(double arr[]);

int main(void)
{
	int i;
	double grd[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter grade of stud_%d: ", i + 1);
		scanf("%lf", &grd[i]);
	}
	sel_sort(grd);

	printf("\n***** Sorted array *****\n");
	for (i = 0; i < SIZE; i++)
		printf("%.2f\n", grd[i]);
	return 0;
}

void sel_sort(double arr[])
{
	int i, j;
	double tmp;

	for (i = 0; i < SIZE - 1; i++)
	{
		for (j = i + 1; j < SIZE; j++)
		{
			if (arr[i] > arr[j])
			{
				/* Αντιμετάθεση τιμών. */
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}
}