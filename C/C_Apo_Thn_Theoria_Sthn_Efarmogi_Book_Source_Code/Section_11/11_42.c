#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 4
#define COLS 4

void show_board(int c[][COLS], int s[][COLS]);
void sel_card(int c[][COLS], int s[][COLS], int *row, int *col);

int main(void)
{
	int i, j, m, r, c, r2, c2, cnt, cards[ROWS][COLS], status[ROWS][COLS] = { 0 }; /* Ο πίνακας status δηλώνει αν μία κάρτα είναι ανοικτή ή κλειστή (0 είναι για κλειστή). */
	cnt = 0; /* Αυτή η μεταβλητή μετράει τον αριθμό των ανοικτών καρτών. */
	for (i = r = 0; i < ROWS; i++) /* Εκχωρούμε τις τιμές 1 έως 8, διαδοχικά. */
	{
		for (j = 0; j < COLS; j += 2)
		{
			cards[i][j] = cards[i][j + 1] = r + 1;
			r++;
		}
	}
	/* Τώρα, ανακατεύουμε τις κάρτες, ώστε να τοποθετηθούν σε τυχαίες θέσεις. */
	srand(time(NULL));
	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
		{
			c = cards[i][j];
			m = rand() % ROWS;
			r = rand() % COLS;
			cards[i][j] = cards[m][r];
			cards[m][r] = c;
		}
	}
	show_board(cards, status);
	m = 0;
	while (cnt != ROWS*COLS) /* Το παιχνίδι τερματίζει όταν όλες οι κάρτες ανοίξουν. */
	{
		sel_card(cards, status, &r, &c);
		printf("Card_1 = %d\n", cards[r][c]);

		sel_card(cards, status, &r2, &c2);
		printf("Card_2 = %d\n", cards[r2][c2]);

		for (i = 0; i < 18; i++) /* Κενές γραμμές για να διαγράψουμε το ιστορικό των προσπαθειών και να το κάνουμε δυσκολότερο για το χρήστη να θυμηθεί τις θέσεις των καρτών. */
			printf("\n");

		if (cards[r][c] == cards[r2][c2])
		{
			printf("Cards matched !!!\n");
			cnt += 2;
		}
		else
		{
			printf("Sorry. No match !!!\n");
			status[r][c] = status[r2][c2] = 0; /* Κλείνουμε πάλι τις κάρτες. */
		}
		m++;
		show_board(cards, status);
	}
	printf("Congrats: You did it in %d tries\n", m);
	return 0;
}

void show_board(int c[][COLS], int s[][COLS])
{
	int i, j;

	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
		{
			if (s[i][j] == 1)
				printf("%d ", c[i][j]);
			else
				printf("* ");
		}
		printf("\n");
	}
}

void sel_card(int c[][COLS], int s[][COLS], int *row, int *col)
{
	while (1)
	{
		printf("Enter row and column: ");
		scanf("%d %d", row, col);
		(*row)--; /* Αφαιρούμε το 1, γιατί η μέτρηση στους πίνακες αρχίζει από 0. */
		(*col)--;
		if (*row >= ROWS || *row < 0 || *col >= COLS || *col < 0)
		{
			printf("Out of bound dimensions\n");
			continue;
		}
		if (s[*row][*col] == 1)
		{
			printf("Error: This card is already flipped\n");
			continue;
		}
		s[*row][*col] = 1; /* Ανοίγουμε την κάρτα. */
		return;
	}
}