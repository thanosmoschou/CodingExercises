#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char *argv[])
{
	int i, j, rows, cols;
	double **arr, sum_line;

	if (argc < 3)
		printf("Error: missing arguments...\n");
	else if (argc == 3)
	{
		rows = atoi(argv[1]); /* Μετατροπή του δεύτερου ορίσματος σε ακέραιο. */
		cols = atoi(argv[2]); /*Όμοια, για το τρίτο όρισμα*/

		srand(time(NULL));
		arr = (double**)malloc(rows * sizeof(double*));
		if (arr == NULL)
		{
			printf("Error: Not available memory\n");
			exit(EXIT_FAILURE);
		}
		for (j = 0; j < rows; j++)
		{
			arr[j] = (double*)malloc(cols * sizeof(double));
			if (arr[j] == NULL)
			{
				printf("Error: Not available memory\n");
				exit(EXIT_FAILURE);
			}
		}
		for (i = 0; i < rows; i++)
		{
			sum_line = 0;
			for (j = 0; j < cols - 1; j++)
			{
				arr[i][j] = (rand() % 101 / (cols - 1)) / 100.0;
				sum_line += arr[i][j];
				/* Έστω ότι ο χρήστης έχει εισάγει ως αριθμό στηλών το 5. Για τα 4 πρώτα στοιχεία κάθε γραμμής, η rand()%101 δημιουργεί έναν ακέραιο στο [0,100], άρα διαιρώντας αυτόν με τον αριθμό των στηλών μείον ένα, δηλαδή με 4, προκύπτει ένας ακέραιος στο [0,25]. Διαιρώντας στη συνέχεια με το 100.0, προκύπτει ένας αριθμός στο [0,0.25]. Με αυτόν τον τρόπο, το άθροισμα των τεσσάρων πρώτων στοιχείων κάθε γραμμής περιορίζεται στο [0,1] */
			}
			arr[i][j] = 1 - sum_line; /* Για να ικανοποιηθεί η συνθήκη ότι το άθροισμα των στοιχείων κάθε γραμμής πρέπει να είναι ίσο με 1, η τιμή του τελευταίου στοιχείου υπολογίζεται αφαιρώντας από το 1 το άθροισμα όλων των υπολοίπων στοιχείων της γραμμής. */
		}
		for (i = 0; i < rows; i++)
		{
			for (j = 0; j < cols; j++)
				printf("%6.2f", arr[i][j]);

			printf("\n");
		}
		for (j = 0; j < rows; j++)
			free(arr[j]);
		free(arr);
	}
	else
		printf("Error: too many arguments...\n");
	return 0;
}