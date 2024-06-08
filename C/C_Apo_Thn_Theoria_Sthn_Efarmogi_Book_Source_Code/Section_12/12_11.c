#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CNTRS    50
#define MONTHS   12

void bubble_sort(char str[][100], int arr[]);
int read_text(char str[], int size, int flag);

int main(void)
{
	char cntr[CNTRS][100], str[100];
	int i, j, tmp, flag, tour[CNTRS] = { 0 };

	for (i = 0; i < CNTRS; i++)
	{
		printf("Enter name of country_%d: ", i + 1);
		read_text(cntr[i], sizeof(cntr[i]), 1);

		for (j = 0; j < MONTHS; j++)
		{
			printf("Enter tourists of month_%d: ", j + 1);
			scanf("%d", &tmp);
			tour[i] += tmp; /* Σε αυτόν τον πίνακα αποθηκεύουμε τον συνολικό αριθμό των τουριστών που επισκέφτηκαν το κάθε κράτος. */
		}
		getchar();
	}
	printf("Enter country to search: ");
	read_text(str, sizeof(str), 1);

	flag = 0;
	for (i = 0; i < CNTRS; i++)
	{
		if (strcmp(str, cntr[i]) == 0)
		{
			flag = 1;
			printf("%d tourists visited %s\n", tour[i], str);
			break;
		}
	}
	if (flag == 0)
		printf("%s not registered\n", str);

	bubble_sort(cntr, tour); /* Ταξινόμηση του πίνακα με τον αριθμό των τουριστών και παράλληλη ενημέρωση του πίνακα με τα ονόματα των κρατών. */
	printf("\n***** Tourists in decrease order *****\n");
	for (i = 0; i < 5; i++)
		printf("%d.%s\t%d\n", i + 1, cntr[i], tour[i]);
	/* Ελέγχουμε αν υπάρχουν και άλλα κράτη που να έχουν τον ίδιο αριθμό τουριστών με αυτό που βρίσκεται στην πέμπτη θέση. */
	while ((tour[i] == tour[4]) && i < CNTRS)
	{
		printf("%d.%s\t%d\n", i + 1, cntr[i], tour[i]);
		i++;
	}
	return 0;
}

void bubble_sort(char str[][100], int arr[])
{
	char temp[100];
	int i, j, k, reorder;

	for (i = 1; i < CNTRS; i++)
	{
		reorder = 0;
		for (j = CNTRS - 1; j >= i; j--)
		{
			if (arr[j] > arr[j - 1]) /* Παράλληλη αντιμετάθεση του αριθμού τουριστών και των αντίστοιχων κρατών */
			{
				k = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = k;

				strcpy(temp, str[j]);
				strcpy(str[j], str[j - 1]);
				strcpy(str[j - 1], temp);
				reorder = 1;
			}
		}
		if (reorder == 0)
			return;
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