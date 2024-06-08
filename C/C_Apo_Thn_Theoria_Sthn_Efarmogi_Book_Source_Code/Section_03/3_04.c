#include <stdio.h>

#define PI 3.14159

int main(void)
{
	double radius;

	printf("Enter radius: ");
	scanf("%lf", &radius);
	printf("%f %f\n", PI*radius*radius, 2 * PI*radius);
	return 0;
}