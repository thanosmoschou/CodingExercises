#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 3
#define COLS 5

int main(void)
{
	int i, j, min, max, arr[ROWS][COLS];

	srand(time(NULL));
	for (i = 0; i < ROWS; i++)
	{
		min = max = *arr[i] = rand();
		for (j = 1; j < COLS; j++)
		{
			*(arr[i] + j) = rand();
			if (*(arr[i] + j) < min)
				min = *(arr[i] + j);
			if (*(arr[i] + j) > max)
				max = *(arr[i] + j);
		}
		printf("Row_%d: Min=%d Max=%d\n", i + 1, min, max);
	}
	for (i = 0; i < COLS; i++)
	{
		min = max = *(arr[0] + i);
		for (j = 1; j < ROWS; j++)
		{
			if (*(arr[j] + i) < min)
				min = *(arr[j] + i);
			if (*(arr[j] + i) > max)
				max = *(arr[j] + i);
		}
		printf("Col_%d: Min=%d Max=%d\n", i + 1, min, max);
	}
	/* Εμφανίζουμε τον πίνακα για επαλήθευση των αποτελεσμάτων. */
	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
			printf("%10d", *(arr[i] + j));
		printf("\n");
	}
	return 0;
}