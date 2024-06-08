#include <stdio.h>
int main(void)
{
	int num2, div;
	double num1;

	printf("Enter positives float and int: ");
	scanf("%lf%d", &num1, &num2);
	div = num1 / num2; /* Έστω ότι ο χρήστης εισήγαγε τους αριθμούς 7.24 και 4. Τότε, αφού η μεταβλητή div έχει δηλωθεί ως ακέραια θα γίνει ίση με 1. */
	printf("%f\n", num1 - (div*num2));
	return 0;
}