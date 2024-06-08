#include <stdio.h>
int main(void)
{
	float i;

	printf("Enter positive number: ");
	scanf("%f", &i);
	printf("%f is between %d and %d\n", i, (int)i, (int)(i + 1));
	return 0;
}