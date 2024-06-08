#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

typedef struct
{
	char name[100];
	char capital[100];
	int pop;
} country;

int main(void)
{
	FILE *fp;
	country *cntr;
	char str[100];
	int i, num_cntr, pop;

	printf("Enter file name: ");
	read_text(str, sizeof(str), 1);

	fp = fopen(str, "r");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	if (fscanf(fp, "%d", &num_cntr) != 1)
	{
		fclose(fp);
		printf("Error: fscanf() failed\n");
		exit(EXIT_FAILURE);
	}
	/* Δυναμική δέσμευση μνήμης, για να αποθηκεύσουμε τα στοιχεία των χωρών. */
	cntr = (country*)malloc(num_cntr * sizeof(country));
	if (cntr == NULL)
	{
		fclose(fp);
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < num_cntr; i++)
	if (fscanf(fp, "%s%s%d", cntr[i].name, cntr[i].capital, &cntr[i].pop) != 3)
	{
		fclose(fp);
		printf("Error: fscanf() read error\n");
		exit(EXIT_FAILURE);
	}
	fclose(fp);

	printf("Enter population: ");
	scanf("%d", &pop);
	for (i = 0; i < num_cntr; i++)
	if (cntr[i].pop >= pop)
		printf("%s %s\t%d\n", cntr[i].name, cntr[i].capital, cntr[i].pop);

	free(cntr);
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