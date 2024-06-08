#include <stdio.h>
int main(void)
{
	int i, num, an, an1, an2, an3;

	for (;;)
	{
		printf("Enter number [> 2]: ");
		scanf("%d", &num);
		if (num > 2)
			break;
	}
	an1 = 3;
	an2 = 2;
	an3 = 1;
	for (i = 3; i <= num; i++)
	{
		an = 2 * an1 - an2 + an3;
		an3 = an2;
		an2 = an1;
		an1 = an;
	}
	printf("a[%d] = %d\n", num, an);
	return 0;
}