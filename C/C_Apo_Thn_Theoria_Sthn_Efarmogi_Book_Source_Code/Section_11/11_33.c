#include <stdio.h>

void stat_arr(float arr[], int size, float *min, float *max, float *avg);

int main(void)
{
	int i;
	float min, max, avg, arr[100];

	for (i = 0; i < 100; i++)
	{
		printf("Enter price: ");
		scanf("%f", &arr[i]);
		if (arr[i] == -1)
			break;
	}
	if (i == 0)
		return 0;
	/* Η μεταβλητή i δηλώνει πόσες τιμές αποθηκεύτηκαν στον πίνακα. Π.χ. αν ο χρήστης δεν εισάγει την τιμή -1, τότε η τιμή του i μετά το for βρόχο θα είναι ίση με 100. Αν ο χρήστης εισάγει το -1, η τιμή του i δηλώνει τον αριθμό τους. */
	stat_arr(arr, i, &min, &max, &avg);
	printf("Max=%.2f Min=%.2f Avg=%.2f\n", max, min, avg);
	return 0;
}

void stat_arr(float arr[], int size, float *min, float *max, float *avg)
{
	int i;
	float sum;

	sum = *min = *max = arr[0];
	for (i = 1; i < size; i++)
	{
		if (arr[i] > *max)
			*max = arr[i];
		if (arr[i] < *min)
			*min = arr[i];
		sum += arr[i];
	}
	*avg = sum / size;
}