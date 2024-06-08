#include <stdio.h>
int main(void)
{
	int *p1, sum;
	float *p2, *p3, grade, max;

	p1 = &sum;
	*p1 = 0;

	p3 = &max;
	*p3 = 0;

	p2 = &grade;
	while (1)
	{
		printf("Enter grade: ");
		scanf("%f", p2);

		if (*p2 == -1)
			break;
		if (*p2 >= 5 && *p2 <= 10)
		{
			(*p1)++;
			if (*p2 > *p3)
				*p3 = *p2;
		}
	}
	printf("%d students passed (max = %.2f)\n", *p1, *p3);
	return 0;
}