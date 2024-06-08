#include <stdio.h>

#define ROWS 5

int main(void)
{
	int i, j, num, t[ROWS][ROWS];

	printf("Enter [0][0] element: ");
	scanf("%d", &t[0][0]);
	/* Διαβάζουμε τα υπόλοιπα στοιχεία της πρώτης γραμμής. */
	for (i = 1; i < ROWS; i++)
	{
		printf("Enter [0][%d] element: ", i);
		scanf("%d", &t[0][i]);
	}
	/* Διαβάζουμε τα υπόλοιπα στοιχεία της πρώτης στήλης. */
	for (i = 1; i < ROWS; i++)
	{
		printf("Enter [%d][0] element: ", i);
		scanf("%d", &t[i][0]);
	}
	/* Δημιουργία του πίνακα Toeplitz. */
	for (i = 0; i < ROWS - 1; i++)
	for (j = 0; j < ROWS - 1; j++)
		t[i + 1][j + 1] = t[i][j]; /* Διατρέχουμε τον πίνακα t και κάνουμε κάθε στοιχείο του ίσο με το "πάνω και αριστερά" του, εκτός από τα στοιχεία της πρώτης γραμμής και της πρώτης στήλης. */
	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < ROWS; j++)
			printf("%3d", t[i][j]);
		printf("\n");
	}
	return 0;
}