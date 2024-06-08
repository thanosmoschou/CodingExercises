#include <stdio.h>
int main(void)
{
	int *p1, *p2, i, mul;

	p1 = &i;
	p2 = &mul;
	for (*p1 = 10, *p2 = 1; *p1 <= 20; (*p1) += 2)
		*p2 = *p2 * *p1;
	printf("Mul = %d\n", *p2);
	return 0;
}