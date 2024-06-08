#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 10

int main(void)
{
	int i;
	double sum, arr[SIZE];

	sum = 0; /* ������ ���� ��� ��� ���������� ��� ����������� ��� ��������� ��� ������. */
	srand(time(NULL)); /* ������������ ��� ���������� ��������� ������� ��������. */
	for(i = 0; i < SIZE; i++)
	{
		arr[i] = (double)rand()/RAND_MAX; 
		sum += arr[i];
	}
	printf("Avg = %f\n", sum/SIZE); 
	return 0;
}