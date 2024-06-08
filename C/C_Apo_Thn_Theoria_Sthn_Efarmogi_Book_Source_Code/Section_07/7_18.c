#include <stdio.h>

#define SIZE 50

int main(void)
{
	int i, j, pos, num, found, code[SIZE];

	pos = 0;
	while (pos < SIZE)
	{
		printf("Enter code: ");
		scanf("%d", &num);
		if (num == -1)
			break;

		found = 0;
		/* Η μεταβλητή pos μετράει πόσοι κωδικοί έχουν καταχωρηθεί στον πίνακα, οπότε ο επόμενος βρόχος ελέγχει αν ο εισαγόμενος κωδικός υπάρχει ήδη στον πίνακα. Αν υπάρχει, η μεταβλητή found γίνεται 1 και ο βρόχος τερματίζεται. */
		for (j = 0; j < pos; j++)
		{
			if (code[j] == num)
			{
				printf("Error: Code %d exists. ", num);
				found = 1;
				break;
			}
		}
		/* Αν ο κωδικός δεν υπάρχει στον πίνακα, τον αποθηκεύουμε και αυξάνουμε τον δείκτη θέσης κατά ένα. */
		if (found == 0)
		{
			code[pos] = num;
			pos++;
		}
	}
	printf("\nCodes: ");
	for (i = 0; i < pos; i++)
		printf("%d ", code[i]);
	return 0;
}