#include <stdio.h>

#define SIZE 100

int main(void)
{
	int *p1, *p2, arr[SIZE];

	p1 = arr;
	while (p1 < arr + SIZE)
	{
		printf("Enter code_%d: ", p1 - arr + 1);
		scanf("%d", p1);
		if (*p1 == -1)
			break;

		for (p2 = arr; p2 < p1; p2++) /* ���������� ��� ��� ���� ��� ������, ��������� �� � ������� ���� ��� �����������. */
		{
			if (*p1 == *p2)
			{
				printf("Error: Code %d exists\n", *p1);
				break;
			}
		}
		/* �� � ������� ��� ������� ���� ������ ��������� ��� ������. */
		if (p2 == p1)
			p1++;
	}
	/* �������� �������. */
	for (p2 = arr; p2 < p1; p2++)
		printf("C: %d\n", *p2);
	return 0;
}