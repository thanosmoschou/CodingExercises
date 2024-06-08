#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	FILE *fp1, *fp2;
	char flag, str1[100], str2[100];

	printf("Enter first file: ");
	read_text(str1, sizeof(str1), 1);

	fp1 = fopen(str1, "r");
	if (fp1 == NULL)
	{
		printf("Error: fopen() for %s failed\n", str1);
		exit(EXIT_FAILURE);
	}
	printf("Enter second file: ");
	read_text(str1, sizeof(str1), 1);

	fp2 = fopen(str1, "r");
	if (fp2 == NULL)
	{
		fclose(fp1);
		printf("Error: fopen() for %s failed\n", str1);
		exit(EXIT_FAILURE);
	}
	flag = 0;
	while (1)
	{
		if ((fgets(str1, sizeof(str1), fp1) == NULL)
			|| (fgets(str2, sizeof(str2), fp2) == NULL))
			break; /* Ελέγχουμε αν φτάσαμε στο τέλος κάποιου αρχείου ή αν συνέβη κάποιο λάθος. Σε οποιαδήποτε περίπτωση ο βρόχος τερματίζει. */
		if (strcmp(str1, str2) == 0)
		{
			printf("The same line is: %s\n", str1);
			flag = 1;
			break; /* Αφού βρέθηκε κοινή γραμμή, δεν συνεχίζουμε με άλλες συγκρίσεις. */
		}
	}
	if (flag == 0)
		printf("There is no common line\n");

	fclose(fp1);
	fclose(fp2);
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