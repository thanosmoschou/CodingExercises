#include <stdio.h>
int main(void)
{
	int i = 50, j = 20;

	printf("Sum = %d\n", i + j);
	printf("Diff = %d\n", i - j);
	printf("Product = %d\n", i*j);
	printf("Div = %f\n", (double)i / j);
	printf("Rem = %d\n", i%j);
	return 0;
}