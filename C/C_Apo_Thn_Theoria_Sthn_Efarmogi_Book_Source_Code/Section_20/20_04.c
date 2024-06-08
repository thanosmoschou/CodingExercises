#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char *argv[])
{
	int i, j, rows, cols;
	double **arr, sum_line;

	if (argc < 3)
		printf("Error: missing arguments...\n");
	else if (argc == 3)
	{
		rows = atoi(argv[1]); /* ��������� ��� �������� ��������� �� �������. */
		cols = atoi(argv[2]); /*�����, ��� �� ����� ������*/

		srand(time(NULL));
		arr = (double**)malloc(rows * sizeof(double*));
		if (arr == NULL)
		{
			printf("Error: Not available memory\n");
			exit(EXIT_FAILURE);
		}
		for (j = 0; j < rows; j++)
		{
			arr[j] = (double*)malloc(cols * sizeof(double));
			if (arr[j] == NULL)
			{
				printf("Error: Not available memory\n");
				exit(EXIT_FAILURE);
			}
		}
		for (i = 0; i < rows; i++)
		{
			sum_line = 0;
			for (j = 0; j < cols - 1; j++)
			{
				arr[i][j] = (rand() % 101 / (cols - 1)) / 100.0;
				sum_line += arr[i][j];
				/* ���� ��� � ������� ���� ������� �� ������ ������ �� 5. ��� �� 4 ����� �������� ���� �������, � rand()%101 ���������� ���� ������� ��� [0,100], ��� ���������� ����� �� ��� ������ ��� ������ ����� ���, ������ �� 4, ��������� ���� �������� ��� [0,25]. ���������� ��� �������� �� �� 100.0, ��������� ���� ������� ��� [0,0.25]. �� ����� ��� �����, �� �������� ��� �������� ������ ��������� ���� ������� ������������ ��� [0,1] */
			}
			arr[i][j] = 1 - sum_line; /* ��� �� ������������ � ������� ��� �� �������� ��� ��������� ���� ������� ������ �� ����� ��� �� 1, � ���� ��� ���������� ��������� ������������ ���������� ��� �� 1 �� �������� ���� ��� ��������� ��������� ��� �������. */
		}
		for (i = 0; i < rows; i++)
		{
			for (j = 0; j < cols; j++)
				printf("%6.2f", arr[i][j]);

			printf("\n");
		}
		for (j = 0; j < rows; j++)
			free(arr[j]);
		free(arr);
	}
	else
		printf("Error: too many arguments...\n");
	return 0;
}