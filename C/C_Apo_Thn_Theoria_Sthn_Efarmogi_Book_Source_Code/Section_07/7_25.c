#include <stdio.h>

#define N 2
#define M 3

int main(void)
{
	int i, j, k, a[N][M], b[M][N], c[N][N] = { 0 };
	for (i = 0; i < N; i++)
	{
		for (j = 0; j < M; j++)
		{
			printf("Enter element a[%d][%d]: ", i, j);
			scanf("%d", &a[i][j]);
		}
	}
	for (i = 0; i < M; i++)
	{
		for (j = 0; j < N; j++)
		{
			printf("Enter element b[%d][%d]: ", i, j);
			scanf("%d", &b[i][j]);
		}
	}
	for (i = 0; i < N; i++)
	for (j = 0; j < N; j++)
	for (k = 0; k < M; k++)
		c[i][j] += a[i][k] * b[k][j];

	printf("\nArray c = a x b (%dx%d)\n", N, N);
	printf("-----------------\n");
	for (i = 0; i < N; i++)
	{
		for (j = 0; j < N; j++)
			printf("%5d", c[i][j]);
		printf("\n");
	}
	return 0;
}