#include <stdio.h>
int main(void)
{
	char ch, last_ch;
	int sum1 = 0, sum2 = 0;

	while (1)
	{
		printf("Enter character: ");
		scanf("%c", &ch);

		if (last_ch == ':' && ch == 'q') /* �� � ���������� ���������� ��� �������� � ������� ����� � ':' ��� ����� ��� �������� ���� ����� � 'q', � �������� ���������� ����������. */
			break;
		else if (ch >= 'a' && ch <= 'z')
			printf("%c\n", ch - 32); /* �������� ����������� ��������� ���������. */
		else
			printf("%c\n", ch);

		last_ch = ch; /* ��� ��������� last_ch ������������ � ���������� ���������� ��� �������� � �������. */
		if (ch == 'w')
			sum1++;
		else if (ch == 'x')
			sum2++;
		getchar();
	}
	printf("%c:%d times, %c:%d times\n", 'w', sum1, 'x', sum2);
	return 0;
}