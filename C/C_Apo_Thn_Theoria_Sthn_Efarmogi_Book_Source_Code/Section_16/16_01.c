#include <stdio.h>

#define abs(a) ((a) >= 0 ? (a) : -(a))
int main(void)
{
	int i;

	printf("Enter number: ");
	scanf("%d", &i);
	printf("abs = %d\n", abs(i));
	return 0;
}