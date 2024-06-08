#include <stdio.h>
int main(void)
{
	double d1, d2, d3, temp;

	printf("Enter numbers: ");
	scanf("%lf%lf%lf", &d1, &d2, &d3);

	temp = d1;
	d1 = d2;
	d2 = temp;

	temp = d3;
	d3 = d1;
	d1 = temp;
	printf("%f %f %f\n", d1, d2, d3);
	return 0;
}