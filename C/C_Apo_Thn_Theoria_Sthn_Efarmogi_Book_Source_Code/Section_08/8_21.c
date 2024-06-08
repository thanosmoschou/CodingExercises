#include <stdio.h>
int main(void)
{
	int *ptr, sum, arr[5] = {11, 21, 31, 41, 51};
	
	sum = 0;
	for(ptr = arr; ptr < arr+5; ptr++)
	{
		--*ptr;
		sum += *ptr;
	}
	printf("Sum = %d\n", sum);
	return 0;
}