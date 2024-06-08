#include <stdio.h>
int main(void)
{
	int i, num, times;

	times = 0;
	while (1)
	{
		printf("Enter number: ");
		scanf("%d", &num);
		if (num < 0)
			break;
		i = 0;
		while (i < num)
		{
			printf("Hello\n");
			i++;
		}
		times += num;
	}
	printf("Total number is = %d\n", times);
	return 0;
}