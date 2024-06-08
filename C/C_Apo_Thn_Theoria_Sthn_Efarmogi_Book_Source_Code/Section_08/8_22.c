#include <stdio.h>

#define SIZE 50

int main(void)
{
	float *ptr, arr[SIZE];

	ptr = arr;
	while (ptr < arr + SIZE)
	{
		printf("Enter grade: ");
		scanf("%f", ptr);
		ptr++;
	}
	ptr--;
	while (ptr >= arr)
	{
		printf("%f\n", *ptr);
		ptr--;
	}
	return 0;
}