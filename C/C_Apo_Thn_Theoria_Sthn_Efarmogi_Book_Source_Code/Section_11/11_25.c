#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int str_cmp(const char *str1, const char *str2);
int read_text(char str[], int size, int flag);

int main(void)
{
	char str1[100], str2[100];
	int i;

	printf("Enter first string: ");
	read_text(str1, sizeof(str1), 1);

	printf("Enter second string: ");
	read_text(str2, sizeof(str2), 1);

	i = str_cmp(str1, str2);
	if (i == 0)
		printf("%s = %s\n", str1, str2);
	else if (i < 0)
		printf("%s < %s\n", str1, str2);
	else
		printf("%s > %s\n", str1, str2);
	return 0;
}


int str_cmp(const char *s1, const char *s2)
{
	while (*s1 == *s2)
	{
		if (*s1 == '\0')
			return 0;
		s1++;
		s2++;
	}
	return *s1 - *s2;
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