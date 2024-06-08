#include <stdio.h>

double avg(double a, double b, double c);

int main(void)
{
	double i, j, k, ret;

	printf("Enter prices: ");
	scanf("%lf%lf%lf", &i, &j, &k);

	ret = avg(i, j, k);
	if (ret == -1)
		printf("No value in [1, 2]\n");
	else
		printf("Avg = %f\n", ret);
	return 0;
}

double avg(double a, double b, double c)
{
	int k = 0;
	double sum = 0;

	if (a >= 1 && a <= 2)
	{
		sum += a;
		k++;
	}
	if (b >= 1 && b <= 2)
	{
		sum += b;
		k++;
	}
	if (c >= 1 && c <= 2)
	{
		sum += c;
		k++;
	}
	if (k != 0)
		return sum / k;
	else
		return -1;
}