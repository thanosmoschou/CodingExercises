#include <stdio.h>
int main(void)
{
	int i = 1; /* ������� ��� ������ ����, ����� ��� �����, ���� �� ������� �������� ��� � ������ �� ����������. */
	while (i != 0)
	{
		printf("Enter number: ");
		scanf("%d", &i);
		if (i != 0)
			printf("Num = %d\n", i);
	}
	return 0;
}