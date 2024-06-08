#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char *tot_str;
	int i, tot_chars;

	if (argc == 1) /* ��������� �� � ������ ������� �������� ���� �� ����� ��� ������������. */
	{
		printf("Missing arguments ...\n");
		exit(EXIT_FAILURE);
	}
	tot_chars = 0; /* ��������� ��� ������� �� ������ ��� ���������� ���� ��� ��������������. */
	for (i = 1; i < argc; i++) /* ������������� ��� � ������� argv[1] ������� ��� ����� �������������, � argv[2] ��� �������, �.�.�. � ������� argv[0] ������� ��� ����� ��� ������������. */
		tot_chars += strlen(argv[i]);

	tot_str = (char*)malloc(tot_chars + 1); /* ���������� ��� �������� ���� ��� ��� ��������� '\0'. */
	if (tot_str == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	*tot_str = '\0'; /* ���������� ������������ ��� ������ �� ��� ��������� ���������. */
	for (i = 1; i < argc; i++)
		strcat(tot_str, argv[i]);

	printf("The merged string is: %s\n", tot_str);
	free(tot_str);
	return 0;
}