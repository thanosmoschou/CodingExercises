#include <stdio.h>
int main(void)
{
	unsigned int num, pos;

	printf("Enter number: ");
	scanf("%d", &num);

	printf("Enter bit position [1-32]: ");
	scanf("%d", &pos);
	printf("bit%d is %d\n", pos, (num >> (pos - 1)) & 1);
	return 0;
}