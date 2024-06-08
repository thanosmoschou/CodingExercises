#include <stdio.h>
int main(void)
{
	int i, num, dig;

	num = 0;
	for(i = 7; i >= 0; i--)
	{
		printf("Enter digit_%d (0 or 1): ", i+1);
		scanf("%d", &dig);

		num += (dig << i);
	}
	printf("The decimal value = %d\n", num);
	return 0;
}