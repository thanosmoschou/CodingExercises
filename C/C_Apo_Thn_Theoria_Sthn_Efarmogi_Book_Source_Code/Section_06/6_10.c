#include <stdio.h>
int main(void)
{
	int i, num, sum;
	printf("Enter number > 0: ");
	scanf("%d", &num);

	sum = 0; /* ������� ������ ���� ��� �� �� �����, ��� �� ����� ����� � ����������� ��� �����������. */
	for (i = 1; i <= 2 * num - 1; i += 2)
		sum += i;
	if (sum == num*num)
		printf("Verified\n");
	else
		printf("Not Verified\n");
	return 0;
}