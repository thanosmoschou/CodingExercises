#include <stdio.h>
int main(void)
{
	float tax, a;

	printf("Enter income: ");
	scanf("%f", &a);

	tax = (a > 5000 && a <= 20000)*(a - 5000)*0.15 + (a > 20000)*((a - 20000)*0.3 + 15.000*0.15);
	printf("Tax = %.2f\n", tax);
	return 0;
}