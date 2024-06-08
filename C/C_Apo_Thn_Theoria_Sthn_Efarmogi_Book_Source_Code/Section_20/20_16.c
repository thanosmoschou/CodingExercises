#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char pad_ch, key_str[10], in_str[110] = { 0 }, out_str[110] = { 0 }; /* ��������� ���� ������� �� ������������� ��� 100 ����������, ��� �� ��������� ��� ��������� ��� ��������� ����������. */
	int i, j, tmp, seg, key_len, max_key_dig, msg_len;

	tmp = 1;
	while (tmp)
	{
		tmp = 0; /* � ������ ������������ ���� �� � ���� ��� tmp ���������� ��� 0. */
		printf("Enter 1 up to 9 different key digits: ");
		key_len = read_text(key_str, sizeof(key_str), 1);
		if (key_len < 1 || key_len > 9)
		{
			printf("Error: Length should be 1 to 9 different digits\n");
			tmp = 1;
			continue;
		}
		max_key_dig = '0'; /* �� ���� �� ��������� ������������ �� ���������� �����. */
		for (i = 0; (tmp != 1) && i < key_len; i++)
		{
			if (key_str[i] < '1' || key_str[i] > '9')
			{
				printf("Error: Only digits are allowed\n");
				tmp = 1;
				break;
			}
			if (key_str[i] > max_key_dig)
				max_key_dig = key_str[i];
			/* ��������� �� ���� ����� ����������� ���� ��� ����. */
			for (j = i + 1; j < key_len; j++)
			{
				if (key_str[i] == key_str[j])
				{
					printf("Error: Digits should be different\n");
					tmp = 1;
					break;
				}
			}
		}
		if (tmp == 0)
		{
			max_key_dig -= '0';
			if (key_len != max_key_dig) /* �.�., �� ������ 125 ��� ����� ��������, ����� � ���� ��� ����������� ������ ������ �� ����� ��� �� �� ����� ��� ��������, ������ �� 3. */
			{
				printf("Error: Digits should be from 1 to %d\n", key_len);
				tmp = 1;
			}
		}
	}
	printf("Enter padding character: ");
	pad_ch = getchar();

	getchar();
	while (1)
	{
		printf("Enter text: ");
		msg_len = read_text(in_str, sizeof(in_str), 1);
		if (msg_len >= key_len)
			break;
		else
			printf("Error: Text length must be greater than the key size\n");
	}
	seg = msg_len / key_len;
	tmp = msg_len - (seg*key_len);

	if (tmp != 0) /* �� �� ���������� ��� ����� �����, �������� ��� �� ����� ��� ��������� ��� ���������� ������� �� �� ����� ��� ��������. ��������, ����������� ��� ����� ��� ��������� ����� �������� ���������� �����������. ����������� ��� � ������������� ������� ��� �� ���� ��� ���������� ���������. */
	{
		seg++;
		for (i = 0; i < key_len - tmp; i++)
			in_str[msg_len + i] = pad_ch;
	}
	for (i = 0; i < seg; i++)
	{
		for (j = 0; j < key_len; j++)
		{
			tmp = key_str[j] - '1'; /* ��������� ��� ASCII ���� ��� 1, ��� �� ���������������� �� ����� ��� ������ ����� ��� ������ ������. */
			out_str[i*key_len + j] = in_str[i*key_len + tmp];
		}
	}
	printf("Encoded text: %s\n", out_str);
	for (i = 0; i < seg; i++)
	{
		for (j = 0; j < key_len; j++)
		{
			tmp = key_str[j] - '1';
			in_str[i*key_len + tmp] = out_str[i*key_len + j];
		}
	}
	printf("Decoded text: %s\n", in_str); /* �� ����� ��������� ������� ���������� �� ����������� ��� ����� ��� ������� ���������. */
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