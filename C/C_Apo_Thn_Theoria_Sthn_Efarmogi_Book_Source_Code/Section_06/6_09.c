#include <stdio.h>
int main(void)
{
	int i, num;

	for (;;) /* ���������� ��������� ������. */
	{
		printf("Enter number [1-10]: ");
		scanf("%d", &num);
		if ((num >= 1) && (num <= 10))
			break; /* �� � ������� ������� ������ ��� ������ ��� [1-10] � ��������� ������ ������������. */
	}
	for (i = 1; i <= 10; i++)
		printf("%d * %d = %d\n", i, num, i*num);
	return 0;
}