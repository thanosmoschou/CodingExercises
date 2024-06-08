#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	FILE *fp_in, *fp_out;
	char str[100];
	int ch, key_ch;

	printf("Enter input file: ");
	read_text(str, sizeof(str), 1);

	fp_in = fopen(str, "r");
	if (fp_in == NULL)
	{
		printf("Error: Input file can't be loaded\n");
		exit(EXIT_FAILURE);
	}
	printf("Enter output file: ");
	read_text(str, sizeof(str), 1);

	fp_out = fopen(str, "w");
	if (fp_out == NULL)
	{
		fclose(fp_in);
		printf("Error: Output file can't be created\n");
		exit(EXIT_FAILURE);
	}
	printf("Enter key char: ");
	key_ch = getchar();
	while (1)
	{
		ch = getc(fp_in);
		if (ch == EOF)
			break;
		putc(ch ^ key_ch, fp_out);
	}
	fclose(fp_in);
	fclose(fp_out);
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