#include <stdio.h>
int main(void)
{
	int **p1, **p2, *p3, *p4, i, num, times;

	p3 = &num;
	p1 = &p3;

	p4 = &times;
	p2 = &p4;

	**p2 = 0;

	for (;;)
	{
		printf("Enter number: ");
		scanf("%d", *p1);
		if (**p1 == 0)
			break;
		if (**p1 < 0)
			**p1 = -**p1;
		for (i = 0; i < **p1; i++)
			printf("test\n");
		**p2 += **p1;
	}
	printf("Total number is = %d\n", **p2);
	return 0;
}