#include <stdio.h>
int main(void)
{
	int num, sum, dig;

	sum = dig = 0;
	printf("Enter number: ");
	scanf("%d", &num);

	if (num == 0)
		dig = 1;
	else
	{
		while (num != 0)
		{
			sum += num % 10; /* ��������� �� ��������� ����� ��� ������� ��� �� �����������. */
			num /= 10; /* ������������� �� ��������� �����. */
			dig++;
		}
	}
	if (sum < 0)
		sum = -sum;
	printf("%d digits and their sum is %d\n", dig, sum);
	return 0;
}