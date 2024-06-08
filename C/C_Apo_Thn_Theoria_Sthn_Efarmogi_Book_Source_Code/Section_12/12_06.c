#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 10 

void sel_sort(char str[][100], double arr[]);
int read_text(char str[], int size, int flag);

int main(void)
{
	char name[SIZE][100]; /* Πίνακας SIZE γραμμών, όπου σε κάθε γραμμή αποθηκεύεται ένα όνομα μέχρι 100 χαρακτήρες. Κάθε name[i] μπορεί να χρησιμοποιηθεί σαν δείκτης προς την αντίστοιχη γραμμή. */
	int i;
	double grd[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter name: ");
		read_text(name[i], sizeof(name[i]), 1);

		printf("Enter grade: ");
		scanf("%lf", &grd[i]);
		getchar();
	}
	sel_sort(name, grd);

	printf("\n***** Grades in increase order *****\n");
	for (i = 0; i < SIZE; i++)
		printf("%s\t%.2f\n", name[i], grd[i]);
	return 0;
}

void sel_sort(char str[][100], double arr[])
{
	char tmp[100];
	int i, j;
	double k;

	for (i = 0; i < SIZE - 1; i++)
	{
		for (j = i + 1; j < SIZE; j++)
		{
			if (arr[i] > arr[j])
			{
				/* Παράλληλη αντιμετάθεση βαθμών και των αντίστοιχων ονομάτων. */
				k = arr[i];
				arr[i] = arr[j];
				arr[j] = k;

				strcpy(tmp, str[j]);
				strcpy(str[j], str[i]);
				strcpy(str[i], tmp);
			}
		}
	}
}

int read_text(char str[], int size, int flag)
{
	int len;

	if (fgets(str, size, stdin) == NULL)
	{
		printf("Error: fgets() failed\n");
		exit(EXIT_FAILURE);
	}
	len = strlen(str);
	if (len > 0)
	{
		if (flag && (str[len - 1] == '\n'))
		{
			str[len - 1] = '\0';
			len--;
		}
	}
	else
	{
		printf("Error: No input\n");
		exit(EXIT_FAILURE);
	}
	return len;
}