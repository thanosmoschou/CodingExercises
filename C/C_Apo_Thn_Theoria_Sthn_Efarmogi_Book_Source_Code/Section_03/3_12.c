#include <stdio.h>
int main(void)
{
	int i;
	printf("Enter number between 100 and 999: ");
	scanf("%d", &i);

	i = 100 * (i % 10) + 10 * (i % 100 / 10) + i / 100;
	printf("%d\n", i);
	return 0;
}