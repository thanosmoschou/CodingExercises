#include <stdio.h>
int main(void)
{
	int k;
	float i = 3.45, j = 6.78, tmp;

	tmp = i - (int)i; /* ��������� �� �������� �����. */
	k = (int)i; /* ������������ �� ������� ������� �����, ���� ������� � ���� ���. */
	i = (int)j + tmp;

	tmp = j - (int)j;
	j = k + tmp;
	printf("%f %f\n", i, j);
	return 0;
}