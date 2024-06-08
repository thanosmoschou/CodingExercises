#include <stdio.h>
#include <math.h>

#define MAX_DGR 100

double poly(double a[], double x, int n);

int main(void)
{
	int i, dgr;
	double num, arr[MAX_DGR + 1];

	do
	{
		printf("Enter degree (<= %d): ", MAX_DGR);
		scanf("%d", &dgr);
	} while (dgr < 0 || dgr > MAX_DGR);

	for (i = 0; i <= dgr; i++)
	{
		printf("Enter coefficient arr[%d]: ", i);
		scanf("%lf", &arr[i]);
	}
	printf("Enter number: ");
	scanf("%lf", &num);
	printf("Poly(%f) = %f\n", num, poly(arr, num, dgr));
	return 0;
}
double poly(double a[], double x, int n)
{
	int i;
	double sum;

	sum = 0;
	for (i = 0; i <= n; i++)
		sum += a[i] * pow(x, i);
	return sum;
}