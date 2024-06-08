#include <stdio.h>
int main(void)
{
	int i, j, sum;

	printf("Enter numbers: ");
	scanf("%d%d", &i, &j);

	sum = 0;
	if (i < j)
	{
		for (i = i + 1; i < j; i++)
			sum += i;
	}
	else if (j < i)
	{
		for (j = j + 1; j < i; j++)
			sum += j;
	}
	printf("Sum = %d\n", sum);
	return 0;
}