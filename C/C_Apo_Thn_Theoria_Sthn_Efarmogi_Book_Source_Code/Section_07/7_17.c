#include <stdio.h>
int main(void)
{
	int i, j, tmp, bits[32]; /* Σε αυτόν τον πίνακα θα αποθηκευτούν τα bits του αριθμού, δηλαδή 0 ή 1. Το μήκος του πίνακα δηλώνεται ίσο με 32, αφού θεωρούμε ότι μία ακέραια μεταβλητή έχει 32 bits. */
	unsigned int num;

	printf("Enter number: ");
	scanf("%d", &tmp);
	if (tmp < 0)
	{
		tmp = -tmp;
		tmp = ~tmp;
		tmp++;
	}
	num = tmp; 	/* Αποθηκεύεται ως θετικός. */
	i = 0;
	/* Διαδοχικές διαιρέσεις με το 2 και αποθήκευση του κάθε bit σε αντίστοιχη θέση στον πίνακα. */
	while (num > 0)
	{
		bits[i] = num & 1;
		num >>= 1; /* Ισοδύναμο με num /= 2. */
		i++;
	}
	printf("Binary form: ");
	/* Εμφάνιση των bits του αριθμού από αριστερά προς τα δεξιά. */
	for (j = i - 1; j >= 0; j--)
		printf("%d", bits[j]);
	return 0;
}