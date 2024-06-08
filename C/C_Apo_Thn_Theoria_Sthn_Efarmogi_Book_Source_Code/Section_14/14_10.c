#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int read_text(char str[], int size, int flag);

typedef struct /* Ας θυμηθούμε πάλι το typedef. */
{
	char *name;
	char *addr;
	char *phone;
} pub;

typedef struct
{
	char *title;
	char *auth;
	char *code;
	pub  *pub_ptr;
	float prc;
} book;

/* Για λόγους έκτασης του προγράμματος θεωρούμε ότι όλες οι κλήσεις της malloc() είναι επιτυχημένες. Κανονικά, θα έπρεπε να ελέγχουμε αν η τιμή επιστροφής της κάθε malloc() δεν είναι NULL. */
int main(void)
{
	book *books_ptr;
	char str[100];
	int i, num, len;

	printf("Enter number of books: ");
	scanf("%d", &num);
	getchar();

	books_ptr = (book*)malloc(num * sizeof(book));
	for (i = 0; i < num; i++)
	{
		printf("\nTitle: ");
		len = read_text(str, sizeof(str), 1);
		books_ptr[i].title = (char*)malloc(len + 1);
		strcpy(books_ptr[i].title, str);

		printf("Authors: ");
		len = read_text(str, sizeof(str), 1);
		books_ptr[i].auth = (char*)malloc(len + 1);
		strcpy(books_ptr[i].auth, str);

		printf("Code: ");
		len = read_text(str, sizeof(str), 1);
		books_ptr[i].code = (char*)malloc(len + 1);
		strcpy(books_ptr[i].code, str);

		printf("Price: ");
		scanf("%f", &books_ptr[i].prc);

		getchar();
		/* Δέσμευση μνήμης για την αποθήκευση των στοιχείων του εκδοτικού οίκου. */
		books_ptr[i].pub_ptr = (pub*)malloc(sizeof(pub));

		printf("Name: ");
		len = read_text(str, sizeof(str), 1);
		(books_ptr[i].pub_ptr)->name = (char*)malloc(len + 1);
		strcpy((books_ptr[i].pub_ptr)->name, str);

		printf("Address: ");
		len = read_text(str, sizeof(str), 1);
		(books_ptr[i].pub_ptr)->addr = (char*)malloc(len + 1);
		strcpy((books_ptr[i].pub_ptr)->addr, str);

		printf("Phone: ");
		len = read_text(str, sizeof(str), 1);
		(books_ptr[i].pub_ptr)->phone = (char*)malloc(len + 1);
		strcpy((books_ptr[i].pub_ptr)->phone, str);
	}
	printf("\nEnter code to search: ");
	read_text(str, sizeof(str), 1);

	for (i = 0; i < num; i++)
	{
		if (strcmp(books_ptr[i].code, str) == 0)
		{
			printf("\nTitle: %s\tPublisher: %s\n\n", books_ptr[i].title, (books_ptr[i].pub_ptr)->name);
			break;
		}
	}
	if (i == num)
		printf("\nCode '%s' isn't registered\n", str);

	for (i = 0; i < num; i++)
	{
		free((books_ptr[i].pub_ptr)->name);
		free((books_ptr[i].pub_ptr)->addr);
		free((books_ptr[i].pub_ptr)->phone);

		free(books_ptr[i].title);
		free(books_ptr[i].auth);
		free(books_ptr[i].code);
		free(books_ptr[i].pub_ptr);
	}
	free(books_ptr);
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