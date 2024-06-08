#include <stdio.h>

int collatz(int n);

int main(void)
{
	int a;

	do
	{
		printf("Enter a positive integer: ");
		scanf("%d", &a);
	} while (a <= 0);

	printf("The result is %d indeed!!!\n", collatz(a));
	return 0;
}
int collatz(int n)
{
	printf("%d\n", n);

	if (n == 1)
		return 1;
	else if (n & 1) /* Αν ο n είναι περιττός. */
		return collatz(3 * n + 1);
	else /* Αν ο n είναι άρτιος. */
		return collatz(n / 2);
}