#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char str[100], new_str[200]; /* ���� ������ new_str �� ������������� �� ��� �������������. �� ������� ��� ����� �������� ��� ������ str ��� �� ��������� ��� ��������� ��� ���� �� ������ ��� str ��������� ��� ��������� '*'. */
	int i, j, len, small_let, big_let;

	while (1)
	{
		printf("Enter text: ");
		len = read_text(str, sizeof(str), 1);

		if (str[0] == 'e' && str[1] == 'n' && str[2] == 'd')
			break;

		j = small_let = big_let = 0;
		for (i = 0; i < len; i++)
		{
			if (str[i] >= 'a' && str[i] <= 'z')
			{
				str[i] -= 32; /* ������� �� ��� ASCII ������ � ������� ���� ��������� ��������� ��� ��� ���������� ���� ����� 32. */
				big_let++;
			}
			else if (str[i] >= 'A' && str[i] <= 'Z')
			{
				str[i] += 32;
				small_let++;
			}
			new_str[j] = str[i]; /* ��������� ���� ��������� ��� ���� ��� ����������� � ��������� j. */
			if (str[i] == '*')
			{
				j++; /* ������ ��� j ��� ��� ���������� ���� ����� ��������� '*'. */
				new_str[j] = '*';
			}
			j++; /* ������ ��� j ��� ��� ���������� ��� �������� ���������. */
		}
		new_str[j] = '\0';
		printf("%s contains %d lower case and %d upper case letters\n", new_str, small_let, big_let);
	}
	return 0;
}

int read_text(char str[], int size, int flag)
{
	int len;

	if (fgets(str, size, stdin) == NULL)
	{
		printf("Error: fgets() failed\n");
		exit(EXIT_FAILURE);
	}
	len = strlen(str);
	if (len > 0)
	{
		if (flag && (str[len - 1] == '\n'))
		{
			str[len - 1] = '\0';
			len--;
		}
	}
	else
	{
		printf("Error: No input\n");
		exit(EXIT_FAILURE);
	}
	return len;
}