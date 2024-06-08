#include <stdio.h>
int main(void)
{
	double i, j;

	printf("Enter two positives: ");
	scanf("%lf%lf", &i, &j);
	printf("%d %f\n", (int)i + (int)j, (i - (int)i) + (j - (int)j));
	return 0;
}