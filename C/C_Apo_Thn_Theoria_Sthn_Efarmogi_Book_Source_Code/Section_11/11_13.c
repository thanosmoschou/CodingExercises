#include <stdio.h>
#include <math.h>

void find_roots(double a, double b, double c, double *r1, double *r2, int *code);

int main(void)
{
	int code;
	double a, b, c, r1, r2;

	do
	{
		printf("Enter coefficients (a<>0): ");
		scanf("%lf%lf%lf", &a, &b, &c);
	} while (a == 0);

	find_roots(a, b, c, &r1, &r2, &code);
	if (code == 2)
		printf("Two roots: %f %f\n", r1, r2);
	else if (code == 1)
		printf("One root: %f\n", r1);
	else
		printf("Not real roots\n");
	return 0;
}

void find_roots(double a, double b, double c, double *r1, double *r2, int *code)
{
	double d;

	d = b*b - 4 * a*c;
	if (d > 0)
	{
		*code = 2;
		*r1 = (-b + sqrt(d)) / (2 * a);
		*r2 = (-b - sqrt(d)) / (2 * a);
	}
	else if (d == 0)
	{
		*code = 1;
		*r1 = *r2 = -b / (2 * a);
	}
	else
		*code = 0;
}