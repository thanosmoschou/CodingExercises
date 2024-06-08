#include <stdio.h>
int main(void)
{
	char chk_dig;
	int i, ch, sum, temp;

	sum = 0;
	printf("Enter IMEI (15 digits): ");
	for (i = 1; i < 15; i++) /* ���������� �� 14 ����� �����.*/
	{
		ch = getchar();
		if ((i & 1) == 1) /* ��������� �� � ���� ��� ������ ����� ����. */
			sum += ch - '0'; /* ��� �� ������ ��� ���������� ���� ��� ���� ������ ��������� ��� ��� ASCII ���� ���, ��� ASCII ���� ��� 0. */
		else /* H ���� ��� ������ ����� �����. */
		{
			temp = 2 * (ch - '0');
			if (temp >= 10)
				temp = (temp / 10) + (temp % 10); /* �� � ������� ���� ��� ����������� ����� �������� ������������ �� �������� ��� ������ ���. */
			sum += temp;
		}
	}
	ch = getchar(); /* ����� ��������� �� 14 ��� �� 15 ����� ��� IMEI. �������� ���� ��� ���� ��� getchar() ���������� ��� �� ��������� �����, ������ �� Luhn digit. */
	ch = ch - '0';

	chk_dig = sum % 10;
	if (chk_dig != 0)
		chk_dig = 10 - chk_dig;

	if (ch == chk_dig)
		printf("*** Valid IMEI ***\n");
	else
		printf("*** Invalid IMEI ***\n");
	return 0;
}