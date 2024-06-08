#include <stdio.h>
int main(void)
{
	int i, num;

	printf("Enter number: ");
	scanf("%d", &num);

	if (num >= 10 && num <= 20)
	{
		for (i = 0; i < num; i++)
			printf("One\n");
	}
	else
	{
		for (i = 0; i < 10; i++)
		{
			printf("Enter number: ");
			scanf("%d", &num);

			if (num < 0)
				printf("%d\n", num);
		}
	}
	return 0;
}