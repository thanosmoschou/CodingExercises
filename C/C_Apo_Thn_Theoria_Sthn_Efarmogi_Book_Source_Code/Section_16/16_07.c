#include <stdio.h>

#define max(a, b, c) ((a) >= (b) && (a) >= (c) ? (a) : \
	(b) > (a) && (b) > (c) ? (b) : (c))

int main(void)
{
	double i, j, k;

	printf("Enter numbers: ");
	scanf("%lf%lf%lf", &i, &j, &k);
	printf("Max = %f\n", max(i, j, k));
	return 0;
}