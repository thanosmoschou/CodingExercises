#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define DEBUG

void guess_code(int guess[]);

int main(void)
{
	int i, j, k, found, corr_guess, col_guess, code[4], guess[4];

	srand(time(NULL));
	i = 0;
	/* Δημιουργία τυχαίας ακολουθίας με διαφορετικά χρώματα */
	while (i < 4)
	{
		code[i] = rand() % 6;
		found = 0;
		for (j = 0; j < i; j++)
		{
			if (code[j] == code[i])
			{
				found = 1;
				break;
			}
		}
		if (found == 0)
			i++;
	}
#ifdef DEBUG
	printf("\n**** Secret code is: %d %d %d %d\n\n", code[0], code[1], code[2], code[3]);
#endif
	for (i = 0; i < 10; i++)
	{
		guess_code(guess);

		corr_guess = col_guess = 0;
		/* Υπολογίζουμε τον αριθμό των σωστών χρωμάτων σε σωστές θέσεις. */
		for (j = 0; j < 4; j++)
		{
			if (guess[j] == code[j])
				corr_guess++;
		}
		if (corr_guess == 4)
		{
			printf("\nCongratulations !!! You did it in %d attempts\n", i + 1);
			return 0;
		}
		/* Υπολογίζουμε τον αριθμό των σωστών χρωμάτων σε λάθος θέσεις. */
		for (j = 0; j < 4; j++)
		{
			for (k = 0; k < 4; k++)
			{
				/* Ο δεύτερος όρος χρειάζεται, ώστε να μην προσθέσουμε πάλι τον αριθμό των σωστών χρωμάτων σε σωστές θέσεις. */
				if ((guess[k] == code[j]) && (k != j))
				{
					col_guess++;
					break;
				}
			}
		}
		printf("Colors in right places = %d\nMatching colors in wrong places = %d\n\n", corr_guess, col_guess);
	}
	printf("\nFail: The secret code is %d %d %d %d\n", code[0], code[1], code[2], code[3]);
	return 0;
}

/* Για απλότητα, θεωρούμε ότι ο χρήστης θα εισάγει διαφορετικά χρώματα. */
void guess_code(int guess[])
{
	int i, col;

	i = 0;
	while (i < 4)
	{
		printf("Enter color (RED:0,GREEN:1,BLUE:2,WHITE:3,BLACK:4,YEL:5): ");
		scanf("%d", &col);

		switch (col)
		{
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			guess[i] = col;
			i++;
			break;

		default:
			printf("Wrong choice\n");
			break;
		}
	}
}