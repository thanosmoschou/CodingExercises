#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char str[100];
	int i, cnt;

	printf("Enter text: ");
	read_text(str, sizeof(str), 1);

	cnt = 0;
	for (i = 0; str[i] != '\0'; i++)
	{
		if (str[i] == ' ')
			str[i] = '\n';
		else if (str[i] == 'a')
			str[i] = 'p';
		else if (str[i] == 'b')
			cnt++;
	}
	printf("Len = %d Times = %d\nText = %s\n", i, cnt, str);
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