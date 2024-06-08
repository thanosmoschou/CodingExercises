#include <stdio.h>
int main(void)
{
	int i, pos, neg, cnt;

	pos = neg = cnt = 0;
	do
	{
		printf("Enter number: ");
		scanf("%d", &i);

		if ((i & 1) == 0)
			printf("Num = %d\n", i*i);
		if (i > 0)
		{
			pos++;
			if (i >= 300 && i <= 500)
				cnt++;
		}
		else if (i < 0)
			neg++;
	} while (i < 10 || i > 20);

	printf("Pos = %d Neg = %d Cnt = %d\n", pos, neg, cnt);
	return 0;
}