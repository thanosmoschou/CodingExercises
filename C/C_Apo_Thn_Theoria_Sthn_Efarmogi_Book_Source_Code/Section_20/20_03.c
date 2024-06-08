#include <stdio.h>
#include <string.h>

#define TOURISTS	100
#define ANSWERS	7

int main(void)
{
	int i, j, sel, pnts[ANSWERS] = { 0 }; /* �� ����� ��� ������ ������������� �� ������ ��� ������������ � ���� ��������. ��� ����������, ��� �������� pnts[0] ������������� �� ������ ��� ������� � ����� ��������, ��� pnts[1] ������������� �� ������ ��� ������� � ������� ��������, �.�.�. */

	int given_ans[ANSWERS] = { 0 }; /* ����� � ������� ��������������� ��� �� ��������� �� ��� �������� ���� ����� � ���. �� � ���� ������� ��������� ����� 1, �������� ��� � ���������� �������� ���� ���������. ��� ����������, �� � ������� �������� ��� ����� ��������, � ���� ��� given_ans[2] ������� 1. */
	for (i = 0; i < TOURISTS; i++)
	{
		printf("\nEnter answers of tourist_%d:\n", i + 1);

		memset(given_ans, 0, sizeof(given_ans)); /* �� ����� ��� ������ ���������� ������������ ���� ��� �������� ��� ���������� ���� ���� ��������. ����� ��� memset() ��� ��������� �. */
		for (j = 0; j < ANSWERS; j++)
		{
			while (1) /* ��������� ������ ����� � ������� �� ������� ������ �������� ��� �� ��� ���� ��� �����. */
			{
				printf("Answer_%d [1-%d]: ", j + 1, ANSWERS);
				scanf("%d", &sel);

				if (sel < 1 || sel > ANSWERS)
					printf("Wrong answer ...\n");
				else if (given_ans[sel - 1] == 1)
					printf("Error: This answer is already given ...\n");
				else
					break;
			}
			pnts[sel - 1] += ANSWERS - j; /* ��� ����������, �� � ����� �������� (j = 0) ����� � ������ �������, ���� ������� pnts[sel-1] = pnts[5-1] = pnts[4] += 7�0 = 7; ������ ������������ ����� 7 ������ ����� ��� �������������� ������� ��� ������� ��������. */
			given_ans[sel - 1] = 1;
		}
	}
	printf("\n***** Answer Results *****\n");
	for (i = 0; i < ANSWERS; i++)
		printf("Answer_%d gets %d points\n", i + 1, pnts[i]);
	return 0;
}