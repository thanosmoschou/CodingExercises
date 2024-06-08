#include <stdio.h>
int main(void)
{
	int i, num;

	for (;;) /* Δημιουργία ατέρμονου βρόχου. */
	{
		printf("Enter number [1-10]: ");
		scanf("%d", &num);
		if ((num >= 1) && (num <= 10))
			break; /* Αν ο χρήστης εισάγει αριθμό που ανήκει στο [1-10] ο ατέρμονος βρόχος τερματίζεται. */
	}
	for (i = 1; i <= 10; i++)
		printf("%d * %d = %d\n", i, num, i*num);
	return 0;
}