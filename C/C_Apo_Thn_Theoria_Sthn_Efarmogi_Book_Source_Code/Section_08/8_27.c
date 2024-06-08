#include <stdio.h>

#define SIZE 100

int main(void)
{
	int *p1, *p2, arr[SIZE];

	p1 = arr;
	while (p1 < arr + SIZE)
	{
		printf("Enter code_%d: ", p1 - arr + 1);
		scanf("%d", p1);
		if (*p1 == -1)
			break;

		for (p2 = arr; p2 < p1; p2++) /* Ξεκινώντας από την αρχή του πίνακα, ελέγχουμε αν ο κωδικός έχει ήδη αποθηκευτεί. */
		{
			if (*p1 == *p2)
			{
				printf("Error: Code %d exists\n", *p1);
				break;
			}
		}
		/* Αν ο κωδικός δεν υπάρχει στον πίνακα αυξάνουμε τον δείκτη. */
		if (p2 == p1)
			p1++;
	}
	/* Εμφάνιση κωδικών. */
	for (p2 = arr; p2 < p1; p2++)
		printf("C: %d\n", *p2);
	return 0;
}