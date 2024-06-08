#include <stdio.h>

#define ROWS 2
#define COLS 4

int main(void)
{
	int i, j, arr[ROWS][COLS];

	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
		{
			printf("Enter arr[%d][%d]: ", i, j);
			scanf("%d", &arr[i][j]);
		}
	}
	printf("\nArray elements\n");
	printf("--------------\n");
	for (i = ROWS - 1; i >= 0; i--)
	for (j = COLS - 1; j >= 0; j--)
		printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
	return 0;
}