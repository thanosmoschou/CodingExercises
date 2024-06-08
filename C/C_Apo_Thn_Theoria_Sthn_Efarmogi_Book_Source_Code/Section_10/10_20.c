#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char ch, max_ch, str[100];
	int i, len, max_times, low_let[26] = { 0 }; /* �� ������� ��� ������ ����� 26 ������, ��� ��� �� ���� �������� ��� ��������� ���������. �� ����� ��� ������ ������������� �� ������� ���������� ��� ���� ���������. �.�. �� low_let[0] ������� ��� ������ ���������� ��� 'a', ��� �� low_let[25] ��� ���������� ��� 'z'. */
	int dig[10] = { 0 }; /* ��������, �� dig[0] ������� ��� ������ ���������� ��� ������ 0, ��� �� dig[9] ��� ���������� ��� 9. */
	printf("Enter text: ");
	len = read_text(str, sizeof(str), 1);

	max_ch = max_times = 0;
	for (i = 0; i < len; i++)
	{
		if ((str[i] >= 'a') && (str[i] <= 'z'))
		{
			ch = str[i] - 'a';
			low_let[ch]++; /* �.�. �� � ���������� ����� �� 'a', � ���� low_let['a'�'a'] = low_let[0], � ����� ������� ��� ���������� ��� 'a', �� ������� ���� ���. */
			if (low_let[ch] > max_times)
			{
				max_times = low_let[ch];
				max_ch = str[i];
			}
		}
		else if ((str[i] >= '0') && (str[i] <= '9'))
			dig[str[i] - '0']++;
	}
	printf("***** Lower case letters appearances\n");
	for (i = 0; i < 26; i++)
	if (low_let[i] != 0) /* ������� ��� �� �� ������� ��� ����������� �������� ��� ���������. */
		printf("Letter %c appeared %d times\n", 'a' + i, low_let[i]);

	printf("***** Digits appearances\n");
	for (i = 0; i < 10; i++)
	if (dig[i] != 0)
		printf("Digit %d appeared %d times\n", i, dig[i]);
	if (max_times != 0)
		printf("'%c' appears %d times\n", max_ch, max_times);
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