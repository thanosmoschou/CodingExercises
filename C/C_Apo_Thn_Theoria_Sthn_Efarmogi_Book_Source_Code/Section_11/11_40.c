#include <stdio.h>

#define ROWS 3
#define COLS 4

void find_sums(int arr1[][COLS], int arr2[], int arr3[]);

int main(void)
{
	int i, j, arr1[ROWS][COLS], arr2[ROWS], arr3[COLS];

	for (i = 0; i < ROWS; i++)
	for (j = 0; j < COLS; j++)
	{
		printf("arr1[%d][%d] = ", i, j);
		scanf("%d", &arr1[i][j]);
	}

	find_sums(arr1, arr2, arr3);
	for (i = 0; i < ROWS; i++)
		printf("sum_line_%d = %d\n", i, arr2[i]);
	for (i = 0; i < COLS; i++)
		printf("sum_col_%d = %d\n", i, arr3[i]);
	return 0;
}

void find_sums(int arr1[][COLS], int arr2[], int arr3[])
{
	int i, j, sum;

	for (i = 0; i < ROWS; i++)
	{
		sum = 0;
		for (j = 0; j < COLS; j++)
			sum += arr1[i][j];
		arr2[i] = sum;
	}
	for (i = 0; i < COLS; i++)
	{
		sum = 0;
		for (j = 0; j < ROWS; j++)
			sum += arr1[j][i];
		arr3[i] = sum;
	}
}