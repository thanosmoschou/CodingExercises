#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NUM  20 
#define SIZE 100 

char *find_name(char name[][SIZE], char str[]);
int read_text(char str[], int size, int flag);

int main(void)
{
	char *ptr, str[SIZE], name[NUM][SIZE]; /* ������ ������ NUM ������� ��� SIZE ������, ���� ���� ���� ������ ������������� �� ���������� ��� ����������� ��������. */
	int i;

	for (i = 0; i < NUM; i++)
	{
		printf("Enter name: ");
		read_text(name[i], sizeof(name[i]), 1); /* �������������� �� name[i] ��� ������ ���� ��� ���������� i ������ ��� SIZE ����������. */
	}
	printf("Enter name to search: ");
	read_text(str, sizeof(str), 1);

	ptr = find_name(name, str);
	if (ptr == NULL)
		printf("%s is not contained\n", str);
	else
		printf("%s is contained\n", ptr);
	return 0;
}

char *find_name(char name[][SIZE], char str[])
{
	int i;
	for (i = 0; i < NUM; i++)
	if (strcmp(name[i], str) == 0)
		return name[i]; /*�� name[i] ������� ���� ����� ��������� ��� ������� ��� �������� �� ������������ �����*/
	return NULL; /* �� � �������� ��� ������ ������ �� ���� �� ������ �������� ��� �� ����� ��� ������� ���� ������. */
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