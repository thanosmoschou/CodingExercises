#include <stdio.h>

unsigned int fib(int num);

int main(void)
{
	int num;

	do
	{
		printf("Enter a number between 2 and 40: ");
		scanf("%d", &num);
	} while(num < 2 || num > 40);

	printf("F(%d) = %d\n", num, fib(num));
	return 0;
}

unsigned int fib(int num)
{
	if(num == 0)
		return 0;
	else if(num == 1)
		return 1;
	else
		return fib(num-1) + fib(num-2);
}