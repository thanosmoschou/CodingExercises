#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *realloc_mem(int *ptr, int old_size, int new_size);

int main(void)
{
	int *arr, i;

	/* �������� ������ ��� 10 ���������. */
	arr = (int*)malloc(10 * sizeof(int));
	if (arr == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < 10; i++)
		arr[i] = i + 100;

	arr = realloc_mem(arr, 10, 20); /* � ��������� ���������� ���� ������ ���� ���� ��� ���� ������, � ������ ������������ ���� ������ arr. */
	printf("\n***** Array elements *****\n");
	for (i = 0; i < 20; i++)
		printf("%d\n", arr[i]);

	free(arr); /* ������������ ��� ���� ������. */
	return 0;
}

int *realloc_mem(int *old_mem, int old_size, int new_size)
{
	int *new_mem;

	/* �������� ���� ������ ��� new_size ���������. */
	new_mem = (int*)malloc(new_size * sizeof(int));
	if (new_mem == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	/* ��������� ��� ���������� ��������� ��� ��� �����. */
	memcpy(new_mem, old_mem, old_size * sizeof(int));
	free(old_mem); /* ����������� ������ ������. */
	return new_mem; /* ��������� ������ ���� ���� ��� ���� ������. */
}