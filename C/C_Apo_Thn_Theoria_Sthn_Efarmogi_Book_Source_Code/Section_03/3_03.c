#include <stdio.h>
int main(void)
{
	float i, j, k, avg;

	printf("Enter 3 prices: ");
	scanf("%f%f%f", &i, &j, &k);

	avg = (i + j + k) / 3; /* �� ����������� ���������������� ��� �� ����� ����� � ����� ��� ��������� ��� ���� � ��������. */
	printf("Average = %f\n", avg);
	return 0;
}