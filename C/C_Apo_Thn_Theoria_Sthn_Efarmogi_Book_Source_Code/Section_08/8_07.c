#include <stdio.h>
int main(void)
{
	float *ptr1, *ptr2, i, j, tmp;

	/* Oι δείκτες πρέπει να δείχνουν στις διευθύνσεις των αντίστοιχων μεταβλητών, πριν χρησιμοποιηθούν στην scanf(). */
	ptr1 = &i;
	ptr2 = &j;

	printf("Enter prices: ");
	scanf("%f%f", ptr1, ptr2); /* Αποθήκευση των τιμών στις διευθύνσεις μνήμης που δείχνουν οι δείκτες. */
	tmp = *ptr2;
	*ptr2 = *ptr1;
	*ptr1 = tmp;

	if (*ptr1 > *ptr2)
		printf("%f\n", *ptr1);
	else
		printf("%f\n", *ptr2);
	return 0;
}