#include <stdio.h>
int main(void)
{
	int num;

	printf("Enter number: ");
	scanf("%d", &num);

	num > 0 ? printf("Pos\n") : (num < 0) ? printf("Neg\n") : printf("Zero\n");
	return 0;
}