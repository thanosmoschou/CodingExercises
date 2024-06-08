#include <stdio.h>

#define SIZE 5

void insert_sort(int arr[]);

int main(void)
{
	int i, a[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter number: ");
		scanf("%d", &a[i]);
	}
	insert_sort(a);
	printf("\n***** Sorted array *****\n");
	for (i = 0; i < SIZE; i++)
		printf("%d\n", a[i]);
	return 0;
}

void insert_sort(int arr[])
{
	int i, j, temp;

	for (i = 1; i < SIZE; i++)
	{
		temp = arr[i];
		j = i;
		while ((j > 0) && (arr[j - 1] > temp))
		{
			arr[j] = arr[j - 1]; /* Μετακίνηση του στοιχείου κατά μία θέση δεξιά. */
			j--;
		}
		arr[j] = temp;
	}
}