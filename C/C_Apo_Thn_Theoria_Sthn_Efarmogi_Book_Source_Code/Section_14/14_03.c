#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *realloc_mem(int *ptr, int old_size, int new_size);

int main(void)
{
	int *arr, i;

	/* Δέσμευση μνήμης για 10 ακεραίους. */
	arr = (int*)malloc(10 * sizeof(int));
	if (arr == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < 10; i++)
		arr[i] = i + 100;

	arr = realloc_mem(arr, 10, 20); /* Η συνάρτηση επιστρέφει έναν δείκτη στην αρχή της νέας μνήμης, ο οποίος αποθηκεύεται στον δείκτη arr. */
	printf("\n***** Array elements *****\n");
	for (i = 0; i < 20; i++)
		printf("%d\n", arr[i]);

	free(arr); /* Απελευθέρωση της νέας μνήμης. */
	return 0;
}

int *realloc_mem(int *old_mem, int old_size, int new_size)
{
	int *new_mem;

	/* Δέσμευση νέας μνήμης για new_size ακεραίους. */
	new_mem = (int*)malloc(new_size * sizeof(int));
	if (new_mem == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	/* Αντιγραφή των υπαρχόντων δεδομένων στη νέα μνήμη. */
	memcpy(new_mem, old_mem, old_size * sizeof(int));
	free(old_mem); /* Αποδέσμευση παλιάς μνήμης. */
	return new_mem; /* Επιστροφή δείκτη στην αρχή της νέας μνήμης. */
}