#include <stdio.h>
int main(void)
{
	float grd;

	printf("Enter grade: ");
	scanf("%f", &grd);

	printf("%s\n", (grd >= 7.5 && grd <= 10) ? "A" : (grd >= 5 && grd < 7.5) ? "B" : (grd >= 0 && grd < 5) ? "Next time" : "Grade should be within [0-10]"); 
	return 0;
}