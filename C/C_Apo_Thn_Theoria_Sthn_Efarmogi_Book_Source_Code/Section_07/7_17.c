#include <stdio.h>
int main(void)
{
	int i, j, tmp, bits[32]; /* �� ����� ��� ������ �� ������������ �� bits ��� �������, ������ 0 � 1. �� ����� ��� ������ ��������� ��� �� 32, ���� �������� ��� ��� ������� ��������� ���� 32 bits. */
	unsigned int num;

	printf("Enter number: ");
	scanf("%d", &tmp);
	if (tmp < 0)
	{
		tmp = -tmp;
		tmp = ~tmp;
		tmp++;
	}
	num = tmp; 	/* ������������ �� �������. */
	i = 0;
	/* ���������� ���������� �� �� 2 ��� ���������� ��� ���� bit �� ���������� ���� ���� ������. */
	while (num > 0)
	{
		bits[i] = num & 1;
		num >>= 1; /* ��������� �� num /= 2. */
		i++;
	}
	printf("Binary form: ");
	/* �������� ��� bits ��� ������� ��� �������� ���� �� �����. */
	for (j = i - 1; j >= 0; j--)
		printf("%d", bits[j]);
	return 0;
}