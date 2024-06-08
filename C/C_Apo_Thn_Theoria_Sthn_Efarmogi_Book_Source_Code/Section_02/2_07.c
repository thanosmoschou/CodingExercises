#include <stdio.h>
int main(void)
{
	int k;
	float i = 3.45, j = 6.78, tmp;

	tmp = i - (int)i; /* Βρίσκουμε το δεκαδικό μέρος. */
	k = (int)i; /* Αποθηκεύουμε το υπάρχον ακέραιο μέρος, πριν αλλάξει η τιμή του. */
	i = (int)j + tmp;

	tmp = j - (int)j;
	j = k + tmp;
	printf("%f %f\n", i, j);
	return 0;
}