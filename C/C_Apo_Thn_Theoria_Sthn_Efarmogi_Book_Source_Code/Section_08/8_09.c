#include <stdio.h>
int main(void)
{
	int *p, i;

	p = &i;
	*p = 1;
	while (*p <= 10)
	{
		printf("%d\n", *p);
		(*p)++;
	}
	return 0;
}