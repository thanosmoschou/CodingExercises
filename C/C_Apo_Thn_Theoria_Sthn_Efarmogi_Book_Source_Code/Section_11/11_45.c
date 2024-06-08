#include <stdio.h>
#include <stdarg.h>

double find_max(int num, ...);

int main(void)
{
	double i, j, k;

	printf("Enter numbers: ");
	scanf("%lf%lf%lf", &i, &j, &k);

	printf("Max = %f\n", find_max(3, i, j, k));
	return 0;
}

double find_max(int num, ...)
{
	int i;
	double max, tmp;
	va_list arg_ptr;

	va_start(arg_ptr, num);
	max = va_arg(arg_ptr, double);
	for (i = 1; i < num; i++)
	{
		tmp = va_arg(arg_ptr, double);
		if (max < tmp)
			max = tmp;
	}
	va_end(arg_ptr);
	return max;
}