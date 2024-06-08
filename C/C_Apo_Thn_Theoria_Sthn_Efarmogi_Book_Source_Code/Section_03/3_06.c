#include <stdio.h>
int main(void)
{
	int i, j, temp;

	printf("Enter numbers: ");
	scanf("%d%d", &i, &j);
	temp = i;
	i = j;
	j = temp;
	printf("%d %d\n", i, j);
	return 0;
}