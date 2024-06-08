#include <stdio.h>
int main(void)
{
	int i, cnt;
	double sum, term;

	sum = cnt = 0;
	i = 1;
	for (;;)
	{
		term = (double)(i*(i + 1)) / ((i + 2)*(i + 3));
		if (term > 0.995)
			break;
		cnt++;
		sum += term;
		i += 4;
	}
	i -= 4;
	term = (double)(i*(i + 1)) / ((i + 2)*(i + 3));
	printf("Sum:%f Terms:%d Last:%f\n", sum, cnt, term);
	return 0;
}