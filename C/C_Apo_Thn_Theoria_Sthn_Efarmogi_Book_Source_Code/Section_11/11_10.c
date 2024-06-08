#include <stdio.h>

void swap(float *ptr1, float *ptr2);

int main(void)
{
	float i, j;

	printf("Enter numbers: ");
	scanf("%f%f", &i, &j);
	swap(&i, &j);
	printf("i = %f j = %f\n", i, j);
	return 0;
}

void swap(float* ptr1, float* ptr2)
{
	float m;

	m = *ptr1; /* Ισοδύναμο με m = i; */
	*ptr1 = *ptr2; /* Ισοδύναμο με i = j; */
	*ptr2 = m; /* Ισοδύναμο με j = m = i; */
}