#include <stdio.h>

#define SIZE 50

int main(void)
{
	int *ptr, i, arr[SIZE];

	ptr = arr;
	for (i = 0; i < SIZE; i++)
	{
		printf("Enter number: ");
		scanf("%d", ptr);

		if (*ptr >= 30 && *ptr <= 40)
			ptr++;
	}
	printf("%d elements are stored\n", ptr - arr);
	for (; ptr < arr + SIZE; ptr++)
		*ptr = -1;
	return 0;
}