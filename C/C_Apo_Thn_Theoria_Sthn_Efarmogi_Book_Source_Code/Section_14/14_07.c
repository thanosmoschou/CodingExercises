#include <stdio.h>
#include <stdlib.h>

#define SIZE 100

double *find_diff(double a1[], double a2[], int size, int *items); /* Η παράμετρος items δηλώνει πόσα στοιχεία θα αποθηκευτούν στη μνήμη. Μεταβιβάζεται δείκτης, για να μπορεί η συνάρτηση να αλλάξει την τιμή της. */

int main(void)
{
	int i, elems;
	double *p3, j, k, p1[SIZE], p2[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter numbers: ");
		scanf("%lf%lf", &j, &k);
		if ((j == -1) || (k == -1))
			break;
		p1[i] = j;
		p2[i] = k;
	}
	elems = 0;
	p3 = find_diff(p1, p2, i, &elems);
	if (elems == 0)
		printf("\n***** No different elements *****\n");
	else
	{
		for (i = 0; i < elems; i++)
			printf("%f\n", p3[i]);
	}
	free(p3);
	return 0;
}

double *find_diff(double a1[], double a2[], int size, int *items)
{
	int i, j, found;
	double *mem;

	mem = (double*)malloc(size * sizeof(double));
	if (mem == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < size; i++)
	{
		found = 0; /* Μεταβλητή που δηλώνει αν το στοιχείο του πρώτου πίνακα υπάρχει ή όχι στον δεύτερο πίνακα. Η τιμή 0 σημαίνει ότι δεν υπάρχει. */
		/* Με αυτόν τον βρόχο ελέγχουμε αν το κάθε στοιχείο του πρώτου πίνακα υπάρχει στον δεύτερο πίνακα. */
		for (j = 0; j < size; j++)
		{
			if (a2[j] == a1[i])
			{
				found = 1;
				break; /* Αφού αυτό το στοιχείο υπάρχει, η αναζήτηση τερματίζεται. */
			}
		}
		/* Αν δεν υπάρχει, αποθηκεύεται στη μνήμη. */
		if (found == 0)
		{
			mem[*items] = a1[i]; /* Χειριζόμαστε τη μνήμη σαν πίνακα και την items σαν δείκτη θέσης του πίνακα. */
			(*items)++;
		}
	}
	return mem;
}