#include <stdio.h>

#define SIZE 10

int main(void)
{
	int i, j, cnt, arr1[SIZE], arr2[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter number for the 1st array: ");
		scanf("%d", &arr1[i]);

		printf("Enter number for the 2nd array: ");
		scanf("%d", &arr2[i]);
	}
	cnt = 0; /* ��������� ��� ������� �� ����� ��������. */
	for (i = 0; i < SIZE; i++)
	{
		for (j = 0; j < SIZE; j++) /* ����� � ������ ������� �� �� �������� ��� ������ ������ ������� ���� �������. */
		{
			if (arr1[i] == arr2[j])
			{
				cnt++;
				printf("Common = %d (Pos_1 = %d Pos_2 = %d)\n", arr1[i], i, j);
			}
		}
	}
	if (cnt == 0)
		printf("No common elements were found\n");
	return 0;
}