#include <stdio.h>

double fact(int num);

int main(void)
{
	int num;

	do
	{
		printf("Enter a positive integer less than 170: ");
		scanf("%d", &num);
	} while (num < 0 || num > 170);

	printf("Factorial of %d is %e\n", num, fact(num));
	return 0;
}

double fact(int num)
{
	if ((num == 0) || (num == 1))
		return 1;
	else
		return num * fact(num - 1);
}