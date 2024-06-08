#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char str[100];
	int i, words;

	i = words = 0;

	printf("Enter text: ");
	read_text(str, sizeof(str), 1);

	if (str[0] != ' ' && str[0] != '\t' && str[0] != '\0') /* Αν ο πρώτος χαρακτήρας δεν είναι κενός χαρακτήρας σημαίνει ότι αρχίζει μία λέξη, οπότε αυξάνεται η μεταβλητή words. */
		words++;

	while (str[i] != '\0')
	{
		if (str[i] == ' ' || str[i] == '\t')
		{
			/* Ελέγχουμε αν ο επόμενος χαρακτήρας, δηλαδή ο str[i+1], δεν είναι κενός χαρακτήρας, γιατί μπορεί να υπάρχουν περισσότεροι από ένας κενοί χαρακτήρες ανάμεσα στις λέξεις. Αν δεν είναι κενός χαρακτήρας, τότε σημαίνει ότι αρχίζει μία καινούργια λέξη, οπότε η μεταβλητή words αυξάνεται κατά ένα. */
			if (str[i + 1] != ' ' && str[i + 1] != '\t' && str[i + 1] != '\0')
			{
				words++;
				printf("\n");
			}
		}
		else
			printf("%c", str[i]);
		i++;
	}
	printf("\nThe text contains %d words\n", words);
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