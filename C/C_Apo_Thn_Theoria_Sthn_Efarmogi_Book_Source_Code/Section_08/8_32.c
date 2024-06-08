#include <stdio.h>
int main(void)
{
	int *p[3], i, j, k;

	p[0] = &i;
	p[1] = &j;
	p[2] = &k;

	printf("Enter length_a and length_b: ");
	scanf("%d%d", p[0], p[1]);
	do
	{
		printf("Enter length_c: ");
		scanf("%d", p[2]);
	} while ((*p[2] <= *p[0]) || (*p[2] <= *p[1]));

	if ((*p[0])*(*p[0]) + (*p[1])*(*p[1]) == (*p[2])*(*p[2]))
		printf("Right triangle\n");
	else if ((*p[0])*(*p[0]) + (*p[1])*(*p[1]) > (*p[2])*(*p[2]))
		printf("Acute triangle\n");
	else
		printf("Obtuse triangle\n");
	return 0;
}