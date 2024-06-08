#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 10

int main(void)
{
	int i, pos1, pos2, pos3, ans, arr[SIZE];

	srand(time(NULL));
	/* Πρώτη κλήρωση. */
	for (i = 0; i < SIZE; i++)
	{
		arr[i] = rand() % 101;
		printf("%d ", arr[i]);
	}
	while (1)
	{
		printf("\nContinue to play? (0:No): ");
		scanf("%d", &ans);
		if (ans == 0)
			return 0;
		/* Επιλέγουμε τρεις τυχαίες θέσεις του πίνακα. Οι αριθμοί που είναι αποθηκευμένοι σε αυτές τις θέσεις θα εμφανιστούν και στην επόμενη κλήρωση. */
		pos1 = rand() % SIZE;
		do
		{
			pos2 = rand() % SIZE;
		} while (pos1 == pos2);
		do
		{
			pos3 = rand() % SIZE;
		} while ((pos1 == pos3) || (pos2 == pos3));

		/* Επόμενη κλήρωση. */
		for (i = 0; i < SIZE; i++)
		{
			if ((i == pos1) || (i == pos2) || (i == pos3))
			{
				printf("%d ", arr[i]);
				continue;
			}
			arr[i] = rand() % 101;
			printf("%d ", arr[i]);
		}
	}
	return 0;
}