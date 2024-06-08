#include <stdio.h>

double *max(double *ptr1, double *ptr2);

int main(void)
{
	double *ptr, i, j;

	printf("Enter numbers: ");
	scanf("%lf%lf", &i, &j);

	ptr = max(&i, &j);
	printf("The max of %f and %f is %f\n", i, j, *ptr);
	return 0;
}

double *max(double *ptr1, double *ptr2)
{
	if (*ptr1 > *ptr2)
		return ptr1;
	else
		return ptr2;
}