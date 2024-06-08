#include <stdio.h>

#define CNT_POS

int main(void)
{
	int cnt = 0;
	double num = 1;

	while (num != 0)
	{
		printf("Enter number: ");
		scanf("%lf", &num);
#ifdef CNT_POS
		if (num > 0)
			cnt++;
#else
		if (num < 0)
			cnt++;
#endif
	}
	printf("Cnt = %d\n", cnt);
	return 0;
}