#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 4
#define COLS 5

void sort_rows(int arr[][COLS]);
void sort_cols(int arr[][COLS]);

int main(void)
{
	int i, j, type, arr[ROWS][COLS];

	srand(time(NULL));
	for (i = 0; i < ROWS; i++)
	for (j = 0; j < COLS; j++)
		arr[i][j] = rand();

	printf("Enter sort type (1: rows): ");
	scanf("%d", &type);
	if (type == 1)
		sort_rows(arr);
	else
		sort_cols(arr);

	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
			printf("%10d", arr[i][j]);
		printf("\n");
	}
	return 0;
}

void sort_rows(int arr[][COLS])
{
	int i, j, k, temp;

	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS - 1; j++)
		{
			for (k = j + 1; k < COLS; k++)
			{
				if (arr[i][j] > arr[i][k])
				{
					temp = arr[i][j];
					arr[i][j] = arr[i][k];
					arr[i][k] = temp;
				}
			}
		}
	}
}

void sort_cols(int arr[][COLS])
{
	int i, j, k, temp;

	for (j = 0; j < COLS; j++)
	{
		for (i = 0; i < ROWS - 1; i++)
		{
			for (k = i + 1; k < ROWS; k++)
			{
				if (arr[i][j] < arr[k][j])
				{
					temp = arr[i][j];
					arr[i][j] = arr[k][j];
					arr[k][j] = temp;
				}
			}
		}
	}
}