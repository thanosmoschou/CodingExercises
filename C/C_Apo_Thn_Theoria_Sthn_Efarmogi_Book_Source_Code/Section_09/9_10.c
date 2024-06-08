#include <stdio.h>
int main(void)
{
	char chk_dig;
	int i, ch, sum, temp;

	sum = 0;
	printf("Enter IMEI (15 digits): ");
	for (i = 1; i < 15; i++) /* Διαβάζουμε τα 14 πρώτα ψηφία.*/
	{
		ch = getchar();
		if ((i & 1) == 1) /* Ελέγχουμε αν η θέση του ψηφίου είναι μονή. */
			sum += ch - '0'; /* Για να βρούμε την αριθμητική τιμή του κάθε ψηφίου αφαιρούμε από την ASCII τιμή του, την ASCII τιμή του 0. */
		else /* H θέση του ψηφίου είναι άρτια. */
		{
			temp = 2 * (ch - '0');
			if (temp >= 10)
				temp = (temp / 10) + (temp % 10); /* Αν ο αριθμός μετά τον διπλασιασμό είναι διψήφιος υπολογίζουμε το άθροισμα των ψηφίων του. */
			sum += temp;
		}
	}
	ch = getchar(); /* Έχουν διαβαστεί τα 14 από τα 15 ψηφία του IMEI. Καλώντας άλλη μία φορά την getchar() διαβάζουμε και το τελευταίο ψηφίο, δηλαδή το Luhn digit. */
	ch = ch - '0';

	chk_dig = sum % 10;
	if (chk_dig != 0)
		chk_dig = 10 - chk_dig;

	if (ch == chk_dig)
		printf("*** Valid IMEI ***\n");
	else
		printf("*** Invalid IMEI ***\n");
	return 0;
}