#include <stdio.h>

#define ROWS 3
#define COLS 3

int main(void)
{
	int i, j, sum, tmp, arr[ROWS][COLS];

	sum = tmp = 0;
	for (i = 0; i < ROWS; i++)
	{
		/* Βρίσκουμε τα αθροίσματα των στοιχείων των διαγωνίων. */
		for (j = 0; j < COLS; j++)
		{
			printf("Enter element arr[%d][%d]: ", i, j);
			scanf("%d", &arr[i][j]);
			if (i == j)
				sum += arr[i][j];
			if (i + j == ROWS - 1) /* Ελέγχουμε αν το στοιχείο βρίσκεται στη δευτερεύουσα διαγώνιο. */
				tmp += arr[i][j];
		}
	}
	if (sum != tmp)
	{
		printf("Not magic square -> Sum_main_diag: %d Sum_sec_diag: %d\n", sum, tmp);
		return 0;
	}
	for (i = 0; i < ROWS; i++)
	{
		/* Αρχικοποίηση της μεταβλητής που υπολογίζει το άθροισμα των στοιχείων της κάθε γραμμής. */
		tmp = 0;
		for (j = 0; j < COLS; j++)
			tmp += arr[i][j];

		if (sum != tmp)
		{
			printf("Not magic square -> Sum_row_%d: %d Sum_diag: %d\n", i + 1, tmp, sum);
			return 0;
		}
	}
	for (i = 0; i < COLS; i++)
	{
		tmp = 0; /* Αρχικοποίηση της μεταβλητής που υπολογίζει το άθροισμα των στοιχείων της κάθε στήλης. */
		for (j = 0; j < ROWS; j++)
			tmp += arr[j][i];

		if (sum != tmp)
		{
			printf("Not magic square -> Sum_col_%d: %d Sum_diag: %d\n", i + 1, tmp, sum);
			return 0;
		}
	}
	printf("Magic square !!!\n");
	return 0;
}