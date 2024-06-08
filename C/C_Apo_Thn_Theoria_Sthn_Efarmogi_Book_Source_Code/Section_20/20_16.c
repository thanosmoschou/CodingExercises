#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char pad_ch, key_str[10], in_str[110] = { 0 }, out_str[110] = { 0 }; /* Δηλώνουμε τους πίνακες με περισσότερους από 100 χαρακτήρες, για να καλύψουμε την περίπτωση των πρόσθετων χαρακτήρων. */
	int i, j, tmp, seg, key_len, max_key_dig, msg_len;

	tmp = 1;
	while (tmp)
	{
		tmp = 0; /* Ο βρόχος τερματίζεται μόνο αν η τιμή της tmp παραμείνει στο 0. */
		printf("Enter 1 up to 9 different key digits: ");
		key_len = read_text(key_str, sizeof(key_str), 1);
		if (key_len < 1 || key_len > 9)
		{
			printf("Error: Length should be 1 to 9 different digits\n");
			tmp = 1;
			continue;
		}
		max_key_dig = '0'; /* Σε αυτή τη μεταβλητή αποθηκεύεται το μεγαλύτερο ψηφίο. */
		for (i = 0; (tmp != 1) && i < key_len; i++)
		{
			if (key_str[i] < '1' || key_str[i] > '9')
			{
				printf("Error: Only digits are allowed\n");
				tmp = 1;
				break;
			}
			if (key_str[i] > max_key_dig)
				max_key_dig = key_str[i];
			/* Ελέγχουμε αν κάθε ψηφίο εμφανίζεται μόνο μία φορά. */
			for (j = i + 1; j < key_len; j++)
			{
				if (key_str[i] == key_str[j])
				{
					printf("Error: Digits should be different\n");
					tmp = 1;
					break;
				}
			}
		}
		if (tmp == 0)
		{
			max_key_dig -= '0';
			if (key_len != max_key_dig) /* Π.χ., το κλειδί 125 δεν είναι αποδεκτό, γιατί η τιμή του μεγαλύτερου ψηφίου πρέπει να είναι ίση με το μήκος του κλειδιού, δηλαδή το 3. */
			{
				printf("Error: Digits should be from 1 to %d\n", key_len);
				tmp = 1;
			}
		}
	}
	printf("Enter padding character: ");
	pad_ch = getchar();

	getchar();
	while (1)
	{
		printf("Enter text: ");
		msg_len = read_text(in_str, sizeof(in_str), 1);
		if (msg_len >= key_len)
			break;
		else
			printf("Error: Text length must be greater than the key size\n");
	}
	seg = msg_len / key_len;
	tmp = msg_len - (seg*key_len);

	if (tmp != 0) /* Αν το αποτέλεσμα δεν είναι μηδέν, σημαίνει ότι το μήκος του μηνύματος δεν διαιρείται ακριβώς με το μήκος του κλειδιού. Επομένως, προσθέτουμε στο τέλος του μηνύματος όσους ειδικούς χαρακτήρες χρειάζονται. Παρατηρήστε ότι η αντικατάσταση αρχίζει από τη θέση του τερματικού χαρακτήρα. */
	{
		seg++;
		for (i = 0; i < key_len - tmp; i++)
			in_str[msg_len + i] = pad_ch;
	}
	for (i = 0; i < seg; i++)
	{
		for (j = 0; j < key_len; j++)
		{
			tmp = key_str[j] - '1'; /* Αφαιρούμε την ASCII τιμή του 1, για να χρησιμοποιήσουμε το ψηφίο σαν δείκτη θέσης στο αρχικό μήνυμα. */
			out_str[i*key_len + j] = in_str[i*key_len + tmp];
		}
	}
	printf("Encoded text: %s\n", out_str);
	for (i = 0; i < seg; i++)
	{
		for (j = 0; j < key_len; j++)
		{
			tmp = key_str[j] - '1';
			in_str[i*key_len + tmp] = out_str[i*key_len + j];
		}
	}
	printf("Decoded text: %s\n", in_str); /* Αν έχουν προστεθεί ειδικοί χαρακτήρες θα εμφανιστούν στο τέλος του αρχικού μηνύματος. */
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