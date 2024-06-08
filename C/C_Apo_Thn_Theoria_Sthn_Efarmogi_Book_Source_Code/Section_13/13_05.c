#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 10

struct book
{
	char title[50];
	int code;
	float prc;
};

struct book max_prc(struct book *b1, struct book *b2);
int read_text(char str[], int size, int flag);

int main(void)
{
	int i, j;
	struct book tmp, b[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("\nEnter title: ");
		read_text(b[i].title, sizeof(b[i].title), 1);

		printf("Enter code: ");
		scanf("%d", &b[i].code);

		printf("Enter price: ");
		scanf("%f", &b[i].prc);

		getchar();
	}
	do
	{
		printf("Enter two book numbers [1-%d]: ", SIZE);
		scanf("%d%d", &i, &j);
	} while ((i == j) || i > SIZE || j > SIZE || i < 1 || j < 1);
	i--;
	j--;
	tmp = max_prc(&b[i], &b[j]);
	if (tmp.prc != 0)
		printf("\nN: %s C: %d P: %.2f\n", tmp.title, tmp.code, tmp.prc);
	else
		printf("\nBoth books have the same price: %.2f\n", b[i].prc);
	return 0;
}
struct book max_prc(struct book *b1, struct book *b2)
{
	struct book tmp = { 0 };

	if (b1->prc > b2->prc)
		return *b1;
	else if (b1->prc < b2->prc)
		return *b2;
	else
		return tmp;
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