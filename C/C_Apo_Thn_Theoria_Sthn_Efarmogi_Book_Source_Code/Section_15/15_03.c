#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	FILE *fp;
	char str[100];
	int len, cnt;
	printf("Enter file name: ");
	read_text(str, sizeof(str), 1);
	fp = fopen(str, "a"); /* ’νοιγμα του αρχείου για πρόσθεση δεδομένων. */
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	cnt = 0;
	while (1)
	{
		printf("Enter text: ");
		len = read_text(str, sizeof(str), 1);
		if (strcmp(str, "end") == 0)
			break;
		if ((str[0] == 'a') && (len < 10))
		{
			cnt++;
			fputs(str, fp);
		}
	}
	printf("\n%d strings were written\n", cnt);
	fclose(fp);
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