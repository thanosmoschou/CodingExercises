#include <stdio.h>

#define odd_even(a) (((a) & 1) == 0)

int main(void)
{
	int i;

	printf("Enter number: ");
	scanf("%d", &i);
	if (odd_even(i))
		printf("Even\n");
	else
		printf("Odd\n");
	return 0;
}