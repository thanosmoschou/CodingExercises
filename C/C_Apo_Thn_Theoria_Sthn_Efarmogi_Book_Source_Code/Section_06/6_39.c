#include <stdio.h>
int main(void)
{
	int i, num;
	double a, val;

	do
	{
		printf("Enter number > 3: ");
		scanf("%d", &num);
	} while (num <= 3);

	val = 0;
	a = 1;
	for (i = 1; i <= num; i++)
	{
		val += a / i;
		a = -a;
	}
	printf("Val = %e\n", val);
	return 0;
}