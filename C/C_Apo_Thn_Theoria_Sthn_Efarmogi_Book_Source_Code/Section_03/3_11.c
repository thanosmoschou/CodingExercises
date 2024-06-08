#include <stdio.h>
int main(void)
{
	int i;

	printf("Enter number between 10 and 99: ");
	scanf("%d", &i);

	i = 10 * (i % 10) + i / 10;
	printf("%d\n", i);
	return 0;
}