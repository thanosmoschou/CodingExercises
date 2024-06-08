#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void copy(char s1[], char s2[]);
int read_text(char str[], int size, int flag);

int main(void)
{
	char str1[100], str2[100], tmp[100];

	printf("Enter first text: ");
	read_text(str1, sizeof(str1), 1);

	printf("Enter second text: ");
	read_text(str2, sizeof(str2), 1);

	copy(tmp, str1); /* Aποθήκευση του πρώτου αλφαριθμητικού στον πίνακα tmp. */
	copy(str1, str2); /* Αντιγραφή του δεύτερου αλφαριθμητικού στον πίνακα str1. */
	copy(str2, tmp); /* Αντιγραφή του πρώτου αλφαριθμητικού που υπάρχει στον πίνακα tmp στον πίνακα str2. */
	printf("\nFirst text: %s\n", str1);
	printf("Second text: %s\n", str2);
	return 0;
}

void copy(char s1[], char s2[])
{
	while (*s2 != '\0')
	{
		*s1 = *s2;
		s1++;
		s2++;
	}
	*s1 = '\0';
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