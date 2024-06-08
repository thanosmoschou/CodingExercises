#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 20

int read_text(char str[], int size, int flag);

int main(void)
{
	char *temp, *ptr[SIZE], str[SIZE][100];
	int i, j;

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter name: ");
		read_text(str[i], sizeof(str[i]), 1);
		ptr[i] = str[i]; /* Τα στοιχεία του πίνακα δεικτών δείχνουν στα αλφαριθμητικά. */
	}
	for (i = 0; i < SIZE - 1; i++)
	{
		for (j = i + 1; j < SIZE; j++)
		{
			/* Αν το αλφαριθμητικό στο οποίο δείχνει ο ptr[j] είναι μικρότερο από το αλφαριθμητικό στο οποίο δείχνει ο ptr[i], αντιμεταθέτουμε τους αντίστοιχους δείκτες. */
			if (strcmp(ptr[j], ptr[i]) < 0)
			{
				temp = ptr[j];
				ptr[j] = ptr[i];
				ptr[i] = temp;
			}
		}
	}
	for (i = 0; i < SIZE; i++)
		printf("%s\n", ptr[i]);
	return 0;
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