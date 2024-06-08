#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);
char *find(char str[], char ch, int f);

int main(void)
{
	char *ptr, ch, str[100];
	int flag;

	printf("Enter text: ");
	read_text(str, sizeof(str), 1);

	printf("Enter character to search: ");
	scanf("%c", &ch);

	printf("Enter choice (0-first, other-last): ");
	scanf("%d", &flag);

	ptr = find(str, ch, flag);
	if (ptr == NULL)
		printf("'%c' is not included in the text\n", ch);
	else
		printf("The rest string is: %s\n", ptr);
	return 0;
}
char *find(char str[], char ch, int f)
{
	char *tmp = NULL; /* Αρχική τιμή σε περίπτωση που δεν βρεθεί ο χαρακτήρας. */
	while (*str != '\0')
	{
		if (*str == ch)
		{
			tmp = str;
			if (f == 0) /* Αν βρεθεί ο χαρακτήρας και η επιλογή είναι 0, ο βρόχος τερματίζεται και η συνάρτηση επιστρέφει τον δείκτη. Αλλιώς, ο tmp δείχνει στην τελευταία θέση εμφάνισης του χαρακτήρα. */
				break;
		}
		str++;
	}
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