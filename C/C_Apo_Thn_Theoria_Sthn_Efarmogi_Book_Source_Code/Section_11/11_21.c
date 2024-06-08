#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int str_end(char str1[], char str2[]);
int read_text(char str[], int size, int flag);

int main(void)
{
	char str1[100], str2[100];
	int i;

	printf("Enter first text: ");
	read_text(str1, sizeof(str1), 1);

	printf("Enter second text: ");
	read_text(str2, sizeof(str2), 1);

	i = str_end(str1, str2);
	if (i == 0)
		printf("%s is not at the end of %s\n", str2, str1);
	else
		printf("%s is at the end of %s\n", str2, str1);
	return 0;
}

int str_end(char str1[], char str2[])
{
	int i, len1, len2;

	len1 = strlen(str1);
	len2 = strlen(str2);

	if (len1 < len2) /* Αν το μήκος του δεύτερου αλφαριθμητικού είναι μεγαλύτερο η συνάρτηση επιστρέφει κατευθείαν. */
		return 0;
	for (i = 1; i <= len2; i++)
	if (str1[len1 - i] != str2[len2 - i]) /* Αν δύο χαρακτήρες δεν είναι ίδιοι δεν υπάρχει λόγος να συνεχίζουν οι συγκρίσεις και η συνάρτηση τερματίζεται άμεσα. */
		return 0;

	/* Αν ο κώδικας φτάσει εδώ σημαίνει ότι όλοι οι χαρακτήρες που συγκρίθηκαν ήταν ίδιοι. */
	return 1;
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