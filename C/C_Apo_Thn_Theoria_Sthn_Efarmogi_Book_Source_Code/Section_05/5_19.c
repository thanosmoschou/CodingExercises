#include <stdio.h>
int main(void)
{
	float i, j, k;

	printf("Enter prices: ");
	scanf("%f%f%f", &i, &j, &k);

	if (i >= j && i >= k)
		printf("Max = %f\n", i);
	else if (j > i && j > k)
		printf("Max = %f\n", j);
	else
		printf("Max = %f\n", k);
	return 0;
}