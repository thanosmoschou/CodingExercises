#include <stdio.h>
int main(void)
{
	int *p1, *p2, *p3, i, j, sum;

	p1 = &i;
	p2 = &j;
	p3 = &sum;
	*p3 = 0;
	do
	{
		printf("Enter two numbers (a < b < 100): ");
		scanf("%d%d", p1, p2);
	} while (*p1 >= *p2 || *p2 > 100);

	(*p1)++;
	while (*p1 < *p2)
	{
		*p3 += *p1;
		(*p1)++;
	}
	printf("Sum = %d\n", *p3);
	return 0;
}