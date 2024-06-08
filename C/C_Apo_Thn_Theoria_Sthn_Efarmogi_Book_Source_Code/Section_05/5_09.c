#include <stdio.h>
int main(void)
{
	double i, j, k, m, max;

	printf("Enter prices: ");
	scanf("%lf%lf%lf%lf", &i, &j, &k, &m);

	if (i > j)
		max = i;
	else
		max = j;

	if (k > max)
		max = k;
	if (m > max)
		max = m;

	printf("Max = %f\n", max);
	return 0;
}