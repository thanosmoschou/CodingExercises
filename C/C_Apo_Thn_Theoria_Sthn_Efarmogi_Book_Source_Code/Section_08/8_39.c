#include <stdio.h>

#define SIZE 5

int main(void)
{
	int *p, arr[SIZE][SIZE] = { 0 };

	for (p = &arr[0][0]; p <= &arr[SIZE - 1][SIZE - 1]; p++)
	{
		if ((p - &arr[0][0]) % (SIZE + 1) == 0)
			*p = 1;
	}
	return 0;
}