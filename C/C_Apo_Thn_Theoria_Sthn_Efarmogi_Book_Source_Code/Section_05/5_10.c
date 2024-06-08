#include <stdio.h>
int main(void)
{
	float income, tax;

	printf("Enter income: ");
	scanf("%f", &income);

	if (income < 12000)
		tax = 0;
	else if (income <= 14000)
		tax = (income - 12000)*0.15;
	else if (income <= 30000)
		tax = (2000 * 0.15) + (income - 14000)*0.3; /* Το 2000 προκύπτει από τη διαφορά 14000–12000. */
	else
		tax = (2000 * 0.15) + (16000 * 0.3) + (income - 30000)*0.4; /* Το 16000 προκύπτει από τη διαφορά 30000–14000. */
	printf("Tax = %.2f\n", tax);
	return 0;
}