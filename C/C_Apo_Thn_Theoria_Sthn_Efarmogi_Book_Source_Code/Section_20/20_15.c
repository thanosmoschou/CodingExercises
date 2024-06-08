#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LEN 50

typedef struct
{
	char title[LEN];
	char auth[LEN];
	int code;
} book;

void read_data(book *ptr);
void find_book(FILE *fp, char title[]);
void modify_book(FILE *fp, book *ptr, int flag);
void show_books(FILE *fp);

int read_text(char str[], int size, int flag);

int main(void)
{
	FILE *fp;
	char title[LEN];
	int sel;
	book b;

	fp = fopen("test.bin", "r+b");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	while (1)
	{
		printf("\n\nMenu selections\n");
		printf("---------------\n");

		printf("1. Add Book\n");
		printf("2. Find Book\n");
		printf("3. Modify Book \n");
		printf("4. Erase Book\n");
		printf("5. Exit\n");

		printf("\nEnter choice: ");
		scanf("%d", &sel);
		getchar();

		switch (sel)
		{
		case 1:
			read_data(&b);
			fseek(fp, 0, SEEK_END); /* Πρόσθεση του βιβλίου στο τέλος του αρχείου. */
			fwrite(&b, sizeof(book), 1, fp);
			break;

		case 2:
			printf("\nTitle to search: ");
			read_text(title, sizeof(title), 1);

			if (strcmp(title, "*") != 0)
				find_book(fp, title);
			else
				show_books(fp);
			break;

		case 3:
			read_data(&b);
			modify_book(fp, &b, 0);
			break;

		case 4:
			printf("\nTitle to search: ");
			read_text(b.title, sizeof(b.title), 1);
			modify_book(fp, &b, 1);
			break;

		case 5:
			fclose(fp);
			return 0;

		default:
			printf("\nWrong choice\n");
			break;
		}
	}
	return 0;
}

void read_data(book *ptr)
{
	printf("\nTitle: ");
	read_text(ptr->title, sizeof(ptr->title), 1);

	printf("Authors: ");
	read_text(ptr->auth, sizeof(ptr->auth), 1);

	do
	{
		printf("Code [> 0]: ");
		scanf("%d", &ptr->code);
	} while (ptr->code <= 0);
}

void find_book(FILE *fp, char title[])
{
	book b;

	fseek(fp, 0, SEEK_SET);
	while (1)
	{
		if (fread(&b, sizeof(book), 1, fp) != 1)
			break;
		else
		{
			if (strcmp(b.title, title) == 0)
			{
				printf("\nT:%s A:%s C:%d", b.title, b.auth, b.code);
				return;
			}
		}
	}
	printf("\n%s doesn’t exist", title);
}

void modify_book(FILE *fp, book *ptr, int flag)
{
	book b;

	fseek(fp, 0, SEEK_SET);
	while (1)
	{
		if (fread(&b, sizeof(book), 1, fp) != 1)
			break;
		else
		{
			if (strcmp(b.title, ptr->title) == 0)
			{
				/* Τώρα, ο fp δείχνει στην επόμενη εγγραφή. Με την fseek(), τον επαναφέρουμε στην τρέχουσα εγγραφή. */
				fseek(fp, -sizeof(book), SEEK_CUR);
				if (flag == 0)
					fwrite(ptr, sizeof(book), 1, fp);
				else
				{
					b.code = -1; /* Θέτουμε τον κωδικό ίσο με -1. */
					fwrite(&b, sizeof(book), 1, fp);
					printf("\n%s title is erased", ptr->title);
				}
				return;
			}
		}
	}
	printf("\n%s doesn’t exist", ptr->title);
}

void show_books(FILE *fp)
{
	book b;

	fseek(fp, 0, SEEK_SET);
	while (1)
	{
		if (fread(&b, sizeof(book), 1, fp) != 1)
			return;
		else
			printf("T:%s A:%s C:%d\n", b.title, b.auth, b.code);
	}
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