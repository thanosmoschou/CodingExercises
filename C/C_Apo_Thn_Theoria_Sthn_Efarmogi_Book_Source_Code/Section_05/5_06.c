#include <stdio.h>
int main(void)
{
	double a, b;

	printf("Enter numbers: ");
	scanf("%lf%lf", &a, &b);

	if (a == 0)
	{
		if (b == 0)
			printf("Infinite solutions\n");
		else
			printf("There is no solution !!!\n");
	}
	else
		printf("The solution is %f\n", -b / a);
	return 0;
}