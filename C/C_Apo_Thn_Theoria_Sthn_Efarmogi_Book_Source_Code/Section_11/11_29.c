#include <stdio.h>

int mkd(int a, int b);

int main(void)
{
	int num1, num2;

	do
	{
		printf("Enter the first number: ");
		scanf("%d", &num1);

		printf("Enter the second number (equal or less than the first one): ");
		scanf("%d", &num2);
	} while ((num2 > num1) || (num1 <= 0) || (num2 <= 0));

	printf("MKD of %d and %d is %d\n", num1, num2, mkd(num1, num2));
	return 0;
}

int mkd(int a, int b)
{
	int r;

	while (1)
	{
		r = a%b;
		if (r == 0)
			return b;
		else /* Σύμφωνα με τον αλγόριθμο, διαιρούμε τον b με τον r, οπότε αλλάζουμε τις τιμές των a και b αντίστοιχα. */
		{
			a = b;
			b = r;
		}
	}
}