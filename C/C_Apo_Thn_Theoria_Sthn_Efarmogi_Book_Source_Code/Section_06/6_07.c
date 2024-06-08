#include <stdio.h>
int main(void)
{
	int i, num;
	double fact;

	printf("Enter number within [0, 170]: ");
	scanf("%d", &num);

	if (num >= 0 && num <= 170)
	{
		fact = 1; /* ������� ������ ���� ��� �� �� ���, ��� �� ����� ����� � ����������� ��� ������������. */
		for (i = 1; i <= num; i++)
			fact = fact*i;
		/* �� ��������� ��� � ������� ������� ��� ���� 0,  ���� � for ������ ��� ����������, ����� � ������� (i <= num) ����� ������, ���� i = 1 ��� num = 0. ��������, � ���� ��� �� ���������� �� ����� � ������ ���� ��� fact, ������ 1, � ����� ����� ��� ����� ���� 0! = 1. */
		printf("Factorial of %d is %e\n", num, fact);
	}
	else
		printf("Error: Number should be within [0, 170]\n");
	return 0;
}