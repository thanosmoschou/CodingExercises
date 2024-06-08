#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define ERROR_TRIES 7

int read_text(char str[], int size, int flag);

int main(void)
{
	char ch, secret[30], hide[30] = { 0 };
	int i, found, len, error, correct;

	printf("Enter secret word: ");
	len = read_text(secret, sizeof(secret), 1);

	for (i = 0; i < len; i++)
		hide[i] = '_';

	error = correct = 0;
	while (error < ERROR_TRIES)
	{
		printf("Enter character: ");
		ch = getchar();
		found = 0;
		for (i = 0; i < len; i++)
		{
			if (secret[i] == ch)
			{
				hide[i] = ch;
				found = 1;
				correct++;
				if (correct == len)
				{
					printf("Secret word is found !!!\n");
					return 0;
				}
			}
		}
		if (found == 0)
		{
			error++;
			printf("Error, %c does not exist. You’ve got %d more attempts\n", ch, ERROR_TRIES - error);
		}
		else
			printf("%s\n", hide);
		getchar(); /* Παραλείπουμε το '\n', από την προηγούμενη getchar(). */
	}
	printf("Sorry, the secret word was %s\n", secret);
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