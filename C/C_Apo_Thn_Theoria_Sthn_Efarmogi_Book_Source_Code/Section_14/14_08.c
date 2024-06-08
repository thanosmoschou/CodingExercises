#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 20

int read_text(char str[], int size, int flag);

int main(void)
{
	char *ptr[SIZE], str[100];
	int i, pos, len, max_len; /* � ��������� pos ������� �� �������� ��� ������ ptr ��� ������� ��� ���������� �������������. �� ����� ��� ������������ ��� ��������� max_len*/
	pos = max_len = 0;
	for (i = 0; i < SIZE; i++)
	{
		printf("Enter text: ");
		len = read_text(str, sizeof(str), 1);
		/* ��� ���� ������ ���������� ��� ����������� �����. */
		ptr[i] = (char*)malloc(len + 1);
		if (ptr[i] == NULL)
		{
			printf("Error: Not available memory\n");
			exit(EXIT_FAILURE);
		}
		/* ���������� ��� �������������� ��� ����� ��� ���������� ��� ��� ���������� ������. */
		strcpy(ptr[i], str);
		/* ����������� �� ����� ���� �������������� �� ��� ���� ��� max_len ��� �� ������ ��� ������������� �� ���������� ����� ������������ ���� pos �� ���� ��� ������ ��� ���� max_len �� ����� ���. */
		if (len > max_len)
		{
			pos = i;
			max_len = len;
		}
	}
	printf("Longer string: %s\n", ptr[pos]);
	for (i = 0; i < SIZE; i++)
		free(ptr[i]);
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