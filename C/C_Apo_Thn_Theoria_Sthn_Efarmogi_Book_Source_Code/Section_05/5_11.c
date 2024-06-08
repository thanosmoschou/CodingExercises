#include <stdio.h>
int main(void)
{
	float i, j, k;

	printf("Enter grades: ");
	scanf("%f%f%f", &i, &j, &k);

	if (i <= j && i <= k)
	{
		printf("%f ", i);
		if (j < k)
			printf("%f %f\n", j, k);
		else
			printf("%f %f\n", k, j);
	}
	else if (j < i && j < k)
	{
		printf("%f ", j);
		if (i < k)
			printf("%f %f\n", i, k);
		else
			printf("%f %f\n", k, i);
	}
	else
	{
		printf("%f ", k);
		if (j < i)
			printf("%f %f\n", j, i);
		else
			printf("%f %f\n", i, j);
	}
	return 0;
}