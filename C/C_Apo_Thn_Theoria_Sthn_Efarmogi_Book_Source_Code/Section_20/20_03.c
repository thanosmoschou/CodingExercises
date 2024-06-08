#include <stdio.h>
#include <string.h>

#define TOURISTS	100
#define ANSWERS	7

int main(void)
{
	int i, j, sel, pnts[ANSWERS] = { 0 }; /* Σε αυτόν τον πίνακα αποθηκεύονται οι βαθμοί που συγκεντρώνει η κάθε απάντηση. Για παράδειγμα, στο στοιχείο pnts[0] αποθηκεύονται οι βαθμοί που παίρνει η πρώτη απάντηση, στο pnts[1] αποθηκεύονται οι βαθμοί που παίρνει η δεύτερη απάντηση, κ.ο.κ. */

	int given_ans[ANSWERS] = { 0 }; /* Αυτός ο πίνακας χρησιμοποιείται για να ελέγξουμε αν μία απάντηση έχει δοθεί ή όχι. Αν η τιμή κάποιου στοιχείου είναι 1, σημαίνει ότι η αντίστοιχη απάντηση έχει επιλεχθεί. Για παράδειγμα, αν ο χρήστης επιλέξει την τρίτη απάντηση, η τιμή του given_ans[2] γίνεται 1. */
	for (i = 0; i < TOURISTS; i++)
	{
		printf("\nEnter answers of tourist_%d:\n", i + 1);

		memset(given_ans, 0, sizeof(given_ans)); /* Οι τιμές του πίνακα απαντήσεων μηδενίζονται πριν την εισαγωγή των απαντήσεων ενός νέου τουρίστα. Δείτε την memset() στο Παράρτημα Γ. */
		for (j = 0; j < ANSWERS; j++)
		{
			while (1) /* Ατέρμονος βρόχος μέχρι ο χρήστης να εισάγει έγκυρη απάντηση που να μην έχει ήδη δοθεί. */
			{
				printf("Answer_%d [1-%d]: ", j + 1, ANSWERS);
				scanf("%d", &sel);

				if (sel < 1 || sel > ANSWERS)
					printf("Wrong answer ...\n");
				else if (given_ans[sel - 1] == 1)
					printf("Error: This answer is already given ...\n");
				else
					break;
			}
			pnts[sel - 1] += ANSWERS - j; /* Για παράδειγμα, αν η πρώτη απάντηση (j = 0) είναι η πέμπτη επιλογή, τότε γίνεται pnts[sel-1] = pnts[5-1] = pnts[4] += 7–0 = 7; δηλαδή προστίθενται άλλοι 7 πόντοι στους ήδη αποθηκευμένους πόντους της πέμπτης επιλογής. */
			given_ans[sel - 1] = 1;
		}
	}
	printf("\n***** Answer Results *****\n");
	for (i = 0; i < ANSWERS; i++)
		printf("Answer_%d gets %d points\n", i + 1, pnts[i]);
	return 0;
}