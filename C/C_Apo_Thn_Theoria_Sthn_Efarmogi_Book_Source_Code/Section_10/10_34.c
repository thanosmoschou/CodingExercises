#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LETTERS 26

int read_text(char str[], int size, int flag);
int main(void)
{
	char str[100], key[LETTERS];
	int i, j, len, found;

	printf("Enter text: ");
	len = read_text(str, sizeof(str), 1);

	do
	{
		printf("Enter key (%d different characters): ", LETTERS);
		read_text(key, sizeof(key), 1);
		found = 0;
		for (i = 0; i < LETTERS; i++)
		{
			for (j = i + 1; j < LETTERS; j++)
			{
				if (key[i] == key[j])
				{
					found = 1;
					printf("Key characters should be different\n");
					break;
				}
			}
			if (found == 1)
				break;
		}
	} while (found != 0);

	for (i = 0; i < len; i++)
	{
		if (str[i] >= 'a' && str[i] <= 'z')
			str[i] = key[str[i] - 'a'];
	}
	printf("Encrypted text: %s\n", str);
	for (i = 0; i < len; i++)
	{
		for (j = 0; j < LETTERS; j++)
		{
			if (str[i] == key[j])
			{
				str[i] = 'a' + j;
				break;
			}
		}
	}
	printf("Original text: %s\n", str);
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