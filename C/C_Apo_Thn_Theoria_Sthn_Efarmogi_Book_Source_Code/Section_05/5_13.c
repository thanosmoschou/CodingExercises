#include <stdio.h>
int main(void)
{
	int a1, a2, a3, a4, b1, b2, b3, b4;

	printf("Enter first IP address: ");
	scanf("%d.%d.%d.%d", &a1, &a2, &a3, &a4);

	printf("Enter second IP address: ");
	scanf("%d.%d.%d.%d", &b1, &b2, &b3, &b4);

	if (a1 < 128)
	{
		if (a1 == b1)
			printf("Class A: Correct Configuration\n");
		else
			printf("Class A: Wrong Configuration\n");
	}
	else if (a1 < 192)
	{
		if (a1 == b1 && a2 == b2)
			printf("Class B: Correct Configuration\n");
		else
			printf("Class B: Wrong Configuration\n");
	}
	else if (a1 < 224)
	{
		if (a1 == b1 && a2 == b2 && a3 == b3)
			printf("Class C: Correct Configuration\n");
		else
			printf("Class C: Wrong Configuration\n");
	}
	else
		printf("Error: Wrong class\n");
	return 0;
}