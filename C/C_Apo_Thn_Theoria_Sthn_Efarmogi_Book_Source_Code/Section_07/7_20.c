#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 10

int main(void)
{
	int i, j, k, size, arr[SIZE];

	srand(time(NULL));
	for (i = 0; i < SIZE; i++)
		arr[i] = rand() % 16 + 5;

	size = SIZE;
	for (i = 0; i < size; i++)
	{
		j = i + 1;
		while (j < size)
		{
			if (arr[i] == arr[j])
			{
				for (k = j; k < size - 1; k++)
					arr[k] = arr[k + 1]; /* Μετακίνηση των στοιχείων μία θέση αριστερά. */
				size--; /* Αφού διαγράφηκε το στοιχείο, μειώνουμε τον αριθμό τους. */
			}
			else
				j++;
		}
	}
	for (i = size; i < SIZE; i++)
		arr[i] = -1;
	for (i = 0; i < SIZE; i++)
		printf("%d ", arr[i]);
	return 0;
}