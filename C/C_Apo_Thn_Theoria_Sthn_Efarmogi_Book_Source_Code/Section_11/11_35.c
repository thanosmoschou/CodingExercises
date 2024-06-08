#include <stdio.h>

unsigned int fib(int num);
int main(void)
{
	int num;

	do
	{
		printf("Enter a number between 2 and 40: ");
		scanf("%d", &num);
	} while (num < 2 || num > 40);

	printf("F(%d) = %u\n", num, fib(num));
	return 0;
}

unsigned int fib(int num)
{
	unsigned int term1, term2, sum;

	term1 = 1;
	term2 = 0;
	while (num > 1)
	{
		sum = term1 + term2;

		term2 = term1;
		term1 = sum;

		num--;
	}
	return sum;
}