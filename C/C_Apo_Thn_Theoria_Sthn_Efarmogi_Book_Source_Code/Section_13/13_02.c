#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 100

int read_text(char str[], int size, int flag);

struct city
{
	char name[50];
	char cntry[50];
	int pop;
};

int main(void)
{
	char cntry[50];
	int i, pop, flag;
	struct city cities[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("\nCity: ");
		read_text(cities[i].name, sizeof(cities[i].name), 1);

		printf("Country: ");
		read_text(cities[i].cntry, sizeof(cities[i].cntry), 1);

		printf("Population: ");
		scanf("%d", &cities[i].pop);

		getchar();
	}
	printf("\nEnter country to search: ");
	read_text(cntry, sizeof(cntry), 1);

	printf("Population: ");
	scanf("%d", &pop);

	flag = 0;
	for (i = 0; i < SIZE; i++)
	{
		if ((strcmp(cities[i].cntry, cntry) == 0) && (cities[i].pop > pop))
		{
			flag = 1;
			printf("C: %s P: %d\n", cities[i].name, cities[i].pop);
		}
	}
	if (flag == 0)
		printf("\nNone city is found\n");
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