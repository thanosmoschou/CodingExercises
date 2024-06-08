#include <stdio.h>
#include <stdlib.h>

#define ROWS 30
#define COLS 20

int main(void)
{
	int i, j, sel, row, col, rsvd_seats, cost, seats[ROWS][COLS] = { 0 }; /* Χρησιμοποιούμε τον πίνακα seats για να διαχειριστούμε τις θέσεις του κινηματογράφου. Αν η τιμή κάποιου στοιχείου είναι 0 σημαίνει ότι η θέση είναι ελεύθερη. */
	rsvd_seats = cost = 0;
	while (1)
	{
		printf("\nMenu selections\n");
		printf("---------------\n");

		printf("1. Buy Ticket\n");
		printf("2. Ticket Refund\n");
		printf("3. Show Information\n");
		printf("4. Exit\n");

		printf("\nEnter choice: ");
		scanf("%d", &sel);

		switch (sel)
		{
		case 1:
			if (rsvd_seats == ROWS*COLS)
			{
				printf("\nSorry, no free seats\n");
				break;
			}
			printf("\nWould you like a specific seat (No: 0)? ");
			scanf("%d", &sel);
			if (sel == 0)
			{
				do
				{
					row = rand() % ROWS; /* Χρησιμοποιούμε την rand() για να επιλέξουμε μία τυχαία θέση. */
					col = rand() % COLS;
				} while (seats[row][col] == 1);
			}
			else
			{
				do
				{
					printf("\nEnter row [1-%d]: ", ROWS);
					scanf("%d", &row);
				} while (row < 1 || row > ROWS);

				do
				{
					printf("Enter seat [1-%d]: ", COLS);
					scanf("%d", &col);
				} while (col < 1 || col > COLS);

				row--; /* Αφαιρούμε 1, γιατί η αρίθμηση αρχίζει από το 0. */
				col--;
			}
			if (seats[row][col] == 1)
				printf("\nSorry, seat in row_%d and column_%d is reserved\n", row + 1, col + 1);
			else
			{
				seats[row][col] = 1;
				cost += 6;
				rsvd_seats++;
			}
			break;

		case 2:
			if (rsvd_seats == 0)
			{
				printf("\nAll seats are free\n");
				break;
			}
			do
			{
				printf("\nEnter row [1-%d]: ", ROWS);
				scanf("%d", &row);
			} while (row < 1 || row > ROWS);

			do
			{
				printf("Enter seat [1-%d]: ", COLS);
				scanf("%d", &col);
			} while (col < 1 || col > COLS);

			row--;
			col--;
			if (seats[row][col] != 1)
				printf("\nSeat in row_%d and column_%d is not reserved\n", row + 1, col + 1);
			else
			{
				seats[row][col] = 0;
				cost -= 5;
				rsvd_seats--;
			}
			break;

		case 3:
			printf("\nFree seats: %d, Income: %d\n\n", ROWS*COLS - rsvd_seats, cost);
			for (i = 0; i < ROWS; i++)
			{
				for (j = 0; j < COLS; j++)
				{
					if (seats[i][j] == 1)
						printf("%2s", "X");
					else
						printf("%2s", "#");
				}
				printf("\n");
			}
			break;

		case 4:
			return 0;

		default:
			printf("\nWrong choice\n");
			break;
		}
	}
	return 0;
}