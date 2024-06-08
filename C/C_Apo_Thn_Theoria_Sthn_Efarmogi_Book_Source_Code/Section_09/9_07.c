#include <stdio.h>
int main(void)
{
	int ch, dig, arr[26] = { '2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9' }; /* ���������� ���� ������ ��� �� ������� ����� ��� ��������������. */
	dig = 0;
	printf("Enter digit or letter: ");
	while ((ch = getchar()) != '\n' && ch != EOF)
	{
		if (ch >= 'A' && ch <= 'Z')
		{
			dig++;
			putchar(arr[ch - 'A']); /* ������� �� ��� ���� ��� ch ����������� �� ���������� �����. ��� ����������, �� � ������� ������� 'I' �� ���������� �� arr[73-65] = 4. */
		}
		else if (ch >= '0' && ch <= '9')
		{
			dig++;
			putchar(ch); /* �� ����� ������������ ���� �����. */
		}
		else
		{
			printf("Error: Not valid character\n");
			return 0;
		}
		if (dig == 10)
			break;
	}
	if (dig == 10)
		printf("\nNumber completed\n");
	return 0;
}