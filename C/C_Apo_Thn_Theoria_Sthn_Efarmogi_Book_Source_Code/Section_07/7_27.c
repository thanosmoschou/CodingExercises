#include <stdio.h>

#define ROWS 5

int main(void)
{
	int i, j, num, t[ROWS][ROWS];

	printf("Enter [0][0] element: ");
	scanf("%d", &t[0][0]);
	/* ���������� �� �������� �������� ��� ������ �������. */
	for (i = 1; i < ROWS; i++)
	{
		printf("Enter [0][%d] element: ", i);
		scanf("%d", &t[0][i]);
	}
	/* ���������� �� �������� �������� ��� ������ ������. */
	for (i = 1; i < ROWS; i++)
	{
		printf("Enter [%d][0] element: ", i);
		scanf("%d", &t[i][0]);
	}
	/* ���������� ��� ������ Toeplitz. */
	for (i = 0; i < ROWS - 1; i++)
	for (j = 0; j < ROWS - 1; j++)
		t[i + 1][j + 1] = t[i][j]; /* ����������� ��� ������ t ��� ������� ���� �������� ��� ��� �� �� "���� ��� ��������" ���, ����� ��� �� �������� ��� ������ ������� ��� ��� ������ ������. */
	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < ROWS; j++)
			printf("%3d", t[i][j]);
		printf("\n");
	}
	return 0;
}