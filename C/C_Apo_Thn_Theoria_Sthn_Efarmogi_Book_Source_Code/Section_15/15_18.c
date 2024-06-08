#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 100

struct employee
{
	char name[100];
	int tax_num;
	int salary;
};

int read_text(char str[], int size, int flag);

int main(void)
{
	FILE *fp;
	int i, num_empl;
	struct employee empl[SIZE];

	fp = fopen("test.bin", "wb");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	num_empl = 0;
	for (i = 0; i < SIZE; i++)
	{
		printf("\nEnter full name: ");
		read_text(empl[i].name, sizeof(empl[i].name), 1);
		if (strcmp(empl[i].name, "fin") == 0)
			break;

		printf("Enter tax number: ");
		scanf("%d", &empl[i].tax_num);

		printf("Enter salary: ");
		scanf("%d", &empl[i].salary);

		num_empl++;
		getchar();
	}
	/* Γράφουμε κατευθείαν όλες τις δομές στο αρχείο. */
	fwrite(empl, sizeof(struct employee), num_empl, fp);
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