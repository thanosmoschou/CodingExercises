#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);
void find(char *p, int ch, int cnt);

int main(void)
{
	char ch, str[100];

	printf("Enter text: ");
	read_text(str, sizeof(str), 1);

	printf("Enter character: ");
	ch = getchar();
	find(str, ch, 0);
	return 0;
}

void find(char *p, int ch, int cnt)
{
	p = strchr(p, ch);
	if (p == NULL)
		printf("%d\n", cnt);
	else
		find(p + 1, ch, cnt + 1);
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