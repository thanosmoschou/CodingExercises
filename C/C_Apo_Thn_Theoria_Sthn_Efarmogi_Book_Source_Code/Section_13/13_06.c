#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 100

struct product
{
	char name[50];
	int code;
	float prc;
};

struct product *find_prod(struct product prod[], int num_prods, int code); /* Δήλωση συνάρτησης που επιστρέφει έναν δείκτη σε δομή τύπου product. */
int read_text(char str[], int size, int flag);

int main(void)
{
	int i, cnt, code;
	float prc;
	struct product *ptr, prod[SIZE];
	cnt = 0;
	for (i = 0; i < SIZE; i++)
	{
		printf("\nPrice: ");
		scanf("%f", &prc);

		if (prc > 20)
		{
			prod[cnt].prc = prc;

			getchar();

			printf("Name: ");
			read_text(prod[cnt].name, sizeof(prod[cnt].name), 1);

			printf("Code: ");
			scanf("%d", &prod[cnt].code);

			cnt++;
		}
	}
	if (cnt == 0)
	{
		printf("None product is stored\n");
		return 0;
	}
	printf("\nEnter code to search: ");
	scanf("%d", &code);

	ptr = find_prod(prod, cnt, code);
	if (ptr == NULL)
		printf("\nNo product with code = %d\n", code);
	else
		printf("\nN: %s C: %d P: %.2f\n", ptr->name, code, ptr->prc);
	return 0;
}

struct product *find_prod(struct product prod[], int num_prods, int code)
{
	int i;

	for (i = 0; i < num_prods; i++)
	{
		if (prod[i].code == code)
			return &prod[i]; /* Αν βρεθεί ο κωδικός του προϊόντος, η συνάρτηση τερματίζει άμεσα και επιστρέφει τη διεύθυνση της δομής. */
	}
	return NULL; /* Αν φτάσουμε σε αυτό το σημείο σημαίνει ότι ο κωδικός του προϊόντος δεν βρέθηκε, οπότε η συνάρτηση επιστρέφει NULL. */
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