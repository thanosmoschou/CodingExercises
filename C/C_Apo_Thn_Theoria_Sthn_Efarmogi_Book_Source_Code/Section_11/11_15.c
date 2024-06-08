#include <stdio.h>

#define SIZE 50

float avg_arr(float arr[], float min, float max);

int main(void)
{
	int i;
	float a, b, k, arr[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter grade: ");
		scanf("%f", &arr[i]);
	}
	do
	{
		printf("Enter min and max grades: ");
		scanf("%f%f", &a, &b);
	} while (a > b);

	k = avg_arr(arr, a, b);
	if (k == -1)
		printf("None grade in [%f, %f]\n", a, b);
	else
		printf("Avg = %.2f\n", k);
	return 0;
}

float avg_arr(float arr[], float min, float max)
{
	int i, cnt = 0;
	float sum = 0;

	for (i = 0; i < SIZE; i++)
	{
		if (arr[i] >= min && arr[i] <= max)
		{
			cnt++;
			sum += arr[i];
		}
	}
	if (cnt == 0)
		return -1;
	else
		return sum / cnt;
}