#include <stdio.h>

#define SIZE 10

int main(void)
{
	int i, a[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter element a[%d]: ", i);
		scanf("%d", &a[i]);
	}
	for (i = 0; i < SIZE / 2; i++)
	if (a[i] != a[SIZE - 1 - i])
	{
		printf("Non symmetric array\n");
		return 0; /* Αφού διαπιστώσαμε ότι ο πίνακας δεν είναι συμμετρικός, το πρόγραμμα τερματίζεται άμεσα. */
	}
	printf("Symmetric array\n");
	return 0;
}