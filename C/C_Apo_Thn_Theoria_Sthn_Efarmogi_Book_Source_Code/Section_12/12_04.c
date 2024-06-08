#include <stdio.h>
int main(void)
{
	int x, ans, low, high, middle, times;

	do
	{
		printf("Enter number in [0, 1000]: ");
		scanf("%d", &x);
	} while (x < 0 || x > 1000);

	times = 1;
	low = 0;
	high = 1000;
	middle = (high + low) / 2;
	while (high >= low)
	{
		printf("Is %d the hidden number (0 = No, 1 = Yes) ? ", middle);
		scanf("%d", &ans);
		if (ans == 1)
		{
			printf("Num = %d is found in %d tries\n", x, times);
			return 0;
		}
		times++;
		printf("Is the hidden number < %d (0 = No, 1 = Yes) ? ", middle);
		scanf("%d", &ans);
		if (ans == 1)
		{
			high = middle - 1;
			middle = (high + low) / 2;
		}
		else
		{
			low = middle + 1;
			middle = (high + low) / 2;
		}
	}
	printf("Num = %d isn't found. You probably gave a wrong answer\n", x);
	return 0;
}