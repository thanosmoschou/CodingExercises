#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	FILE *fp;
	char found, str[100], tmp_str[100];
	int i, len;

	printf("Enter file name: ");
	read_text(str, sizeof(str), 1);

	fp = fopen(str, "w+b");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < 10; i++)
	{
		printf("Enter text: ");
		len = read_text(str, sizeof(str), 1);

		fwrite(&len, sizeof(int), 1, fp);
		fwrite(str, 1, len, fp);
	}
	printf("Enter title to search: ");
	read_text(tmp_str, sizeof(tmp_str), 1);

	found = 0;
	fseek(fp, 0, SEEK_SET);
	while (1)
	{
		if (fread(&len, sizeof(int), 1, fp) != 1)
			break;
		if (fread(str, 1, len, fp) != len)
			break;
		str[len] = '\0';
		if (strcmp(str, tmp_str) == 0)
		{
			found = 1;
			break;
		}
	}
	if (found == 0)
		printf("\n%s isn't found\n", tmp_str);
	else
		printf("\n%s is found\n", tmp_str);

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