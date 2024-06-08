#include <stdio.h>

#define SIZE 10 

void sel_sort(int arr[], int size);
void add_sort(int arr[], int size, int num);

int main(void)
{
	int i, num, a[SIZE];

	for (i = 0; i < SIZE - 1; i++) /* ���������� 9 ��������. */
	{
		printf("Enter number: ");
		scanf("%d", &a[i]);
	}
	sel_sort(a, SIZE - 1); /* ���������� ��� 9 ���������. */

	printf("Insert number in sorted array: ");
	scanf("%d", &num);

	add_sort(a, SIZE - 1, num); /* �������� ��� 10�� �������� ���� ������. */
	for (i = 0; i < SIZE; i++)
		printf("%d\n", a[i]);
	return 0;
}

void add_sort(int arr[], int size, int num)
{
	int i, pos;

	if (num <= arr[0])
		pos = 0;
	else if (num >= arr[size - 1]) /* �� ����� ����������� ��� ��� ��������� �������, ��� ������������ ���� ��������� ���� ��� � ��������� ����������. */
	{
		arr[size] = num;
		return;
	}
	else
	{
		for (i = 0; i < size - 1; i++)
		{
			/* ��������� �� ���� ��� ������ �� �������� � ���� �������, ���������� ��� �� ��������� �������� ����� �� ��������� ������� ��� ��������� ���� ������ [SIZE-3] ��� [SIZE-2]. */
			if (num >= arr[i] && num <= arr[i + 1])
				break;
		}
		pos = i + 1;
	}
	for (i = size; i > pos; i--)
		arr[i] = arr[i - 1]; /* �� ����� ��� ��������� ������������� ��� ���� �����, ���������� ��� ��� ��������� ���� ��� ������ [SIZE-1] ����� �� ���� ��� �� �������� � ���� �������. �.�. ���� ��������� ��������� ��� ������ ��� i = pos+1, �� ����� arr[pos+1] = arr[pos]. */
	arr[pos] = num; /* ���������� ��� ���� �������. */
}

void sel_sort(int arr[], int size)
{
	int i, j, temp;

	for (i = 0; i < size - 1; i++)
	{
		for (j = i + 1; j < size; j++)
		{
			if (arr[i] > arr[j])
			{
				/* ������������ �����. */
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}