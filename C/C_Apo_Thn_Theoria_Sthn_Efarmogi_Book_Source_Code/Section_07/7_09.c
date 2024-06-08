#include <stdio.h>

#define SIZE 100

int main(void)
{
	int i, min_pos, max_pos;
	float sum, min_grd, max_grd, grd[SIZE];

	sum = max_grd = 0; /* ������������� ��� max_grd �� �� ��������� ������ ����. */
	min_grd = 10; /* ������������ �� �� ���������� ������ ����. */
	for (i = 0; i < SIZE; i++)
	{
		printf("Enter grade in [0-10]: ");
		scanf("%f", &grd[i]);
		/* �� ���������� �� ��������� ��� ���� �� ������� �������. ���� �.7.14 ���������������� do-while. */
		while (grd[i] < 0 || grd[i] > 10)
		{
			printf("Error - Enter new grade in [0-10]: ");
			scanf("%f", &grd[i]);
		}
		sum += grd[i];
		if (grd[i] > max_grd)
		{
			max_grd = grd[i];
			max_pos = i; /* ���������� ��� ����� �� ��� ���������� �����. */
		}
		if (grd[i] < min_grd)
		{
			min_grd = grd[i];
			min_pos = i; /* ���������� ��� ����� �� ��� ��������� �����. */
		}
	}
	printf("Avg: %.2f H(%d): %.2f L(%d): %.2f\n", sum / SIZE, max_pos, max_grd, min_pos, min_grd);
	return 0;
}