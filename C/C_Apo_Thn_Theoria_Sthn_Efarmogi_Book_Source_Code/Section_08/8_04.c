#include <stdio.h>
int main(void)
{
	double *p, val;

	p = &val;
	printf("Enter number: ");
	scanf("%lf", p);

	if (*p >= 0)
		printf("%f\n", *p);
	else
		printf("%f\n", -*p);
	return 0;
}