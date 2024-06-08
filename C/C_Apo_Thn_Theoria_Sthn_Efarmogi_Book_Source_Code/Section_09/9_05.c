#include <stdio.h>
int main(void)
{
	char ch, last_ch;
	int sum1 = 0, sum2 = 0;

	while (1)
	{
		printf("Enter character: ");
		scanf("%c", &ch);

		if (last_ch == ':' && ch == 'q') /* Αν ο τελευταίος χαρακτήρας που εισήγαγε ο χρήστης είναι ο ':' και αυτός που εισήγαγε τώρα είναι ο 'q', η εισαγωγή χαρακτήρων τερματίζει. */
			break;
		else if (ch >= 'a' && ch <= 'z')
			printf("%c\n", ch - 32); /* Εμφάνιση αντίστοιχου κεφαλαίου χαρακτήρα. */
		else
			printf("%c\n", ch);

		last_ch = ch; /* Στη μεταβλητή last_ch αποθηκεύεται ο τελευταίος χαρακτήρας που εισήγαγε ο χρήστης. */
		if (ch == 'w')
			sum1++;
		else if (ch == 'x')
			sum2++;
		getchar();
	}
	printf("%c:%d times, %c:%d times\n", 'w', sum1, 'x', sum2);
	return 0;
}