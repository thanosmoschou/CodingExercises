#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char str[100], min_str[100], max_str[100];
	printf("Enter text: ");
	read_text(str, sizeof(str), 1);
	/* Αποθηκεύουμε το πρώτο αλφαριθμητικό που θα εισάγει ο χρήστης σαν μικρότερο και σαν μεγαλύτερο, ώστε να υπάρχει μία βάση σύγκρισης. */
	strcpy(min_str, str);
	strcpy(max_str, str);
	if (strncmp(str, "end", 3) == 0)
	{
		printf("\nMax = %s Min = %s\n", max_str, min_str);
		return 0;
	}
	while (1)
	{
		printf("Enter text: ");
		read_text(str, sizeof(str), 1);

		if (strncmp(str, "end", 3) == 0)
			break;

		if (strcmp(str, min_str) < 0)
			strcpy(min_str, str);
		if (strcmp(str, max_str) > 0)
			strcpy(max_str, str);
	}
	printf("\nMax = %s Min = %s\n", max_str, min_str);
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