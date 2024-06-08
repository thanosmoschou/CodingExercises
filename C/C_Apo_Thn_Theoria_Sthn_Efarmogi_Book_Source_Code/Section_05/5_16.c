#include <stdio.h>
int main(void)
{
	float i, grd;

	printf("Enter grade: ");
	scanf("%f", &grd);

	i = (grd >= 5 && grd <= 10) ? grd : -1;
	printf("%f\n", i);
	return 0;
}