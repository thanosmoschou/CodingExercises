#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char str[100], new_str[200]; /* Στον πίνακα new_str θα καταχωρήσουμε το νέο αλφαριθμητικό. Το μέγεθός του είναι διπλάσιο του πίνακα str για να καλύψουμε την περίπτωση που όλες οι θέσεις του str περιέχουν τον χαρακτήρα '*'. */
	int i, j, len, small_let, big_let;

	while (1)
	{
		printf("Enter text: ");
		len = read_text(str, sizeof(str), 1);

		if (str[0] == 'e' && str[1] == 'n' && str[2] == 'd')
			break;

		j = small_let = big_let = 0;
		for (i = 0; i < len; i++)
		{
			if (str[i] >= 'a' && str[i] <= 'z')
			{
				str[i] -= 32; /* Σύμφωνα με τον ASCII κώδικα η διαφορά ενός κεφαλαίου χαρακτήρα από τον αντίστοιχο πεζό είναι 32. */
				big_let++;
			}
			else if (str[i] >= 'A' && str[i] <= 'Z')
			{
				str[i] += 32;
				small_let++;
			}
			new_str[j] = str[i]; /* Αντιγραφή κάθε χαρακτήρα στη θέση που υποδεικνύει η μεταβλητή j. */
			if (str[i] == '*')
			{
				j++; /* Αύξηση της j για την αποθήκευση ενός ακόμα χαρακτήρα '*'. */
				new_str[j] = '*';
			}
			j++; /* Αύξηση της j για την αποθήκευση του επόμενου χαρακτήρα. */
		}
		new_str[j] = '\0';
		printf("%s contains %d lower case and %d upper case letters\n", new_str, small_let, big_let);
	}
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