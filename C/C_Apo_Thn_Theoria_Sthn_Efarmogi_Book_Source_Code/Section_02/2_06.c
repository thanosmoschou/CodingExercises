#include <stdio.h>
int main(void)
{
	int i, j, k;

	i = 35;
	j = i / 10;
	k = i  - (10 * j);
	printf("Sum = %d\n", j + k);
	return 0;
}