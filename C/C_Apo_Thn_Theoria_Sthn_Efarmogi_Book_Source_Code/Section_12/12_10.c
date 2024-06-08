#include <stdio.h>

#define SIZE 5 

void bubble_sort(int arr[]);

int main(void)
{
	int i, a[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter number: ");
		scanf("%d", &a[i]);
	}
	bubble_sort(a);

	printf("\n***** Sorted array *****\n");
	for (i = 0; i < SIZE; i++)
		printf("%d\n", a[i]);
	return 0;
}

void bubble_sort(int arr[])
{
	int i, j, temp, reorder;

	for (i = 1; i < SIZE; i++)
	{
		reorder = 0;
		for (j = SIZE - 1; j >= i; j--)
		{
			if (arr[j] < arr[j - 1])
			{
				/* Αντιμετάθεση τιμών. */
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				reorder = 1;
			}
		}
		if (reorder == 0)
			return;
	}
}