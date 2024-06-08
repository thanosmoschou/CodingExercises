#include <stdio.h>

#define max(a, b) ((a) > (b) ? (a) : (b)) 

int main(void)
{
	int i, j, k, l;

	printf("Enter numbers: ");
	scanf("%d%d%d%d", &i, &j, &k, &l);
	printf("Max = %d\n", max(max(max(i, j), k), l));
	return 0;
}