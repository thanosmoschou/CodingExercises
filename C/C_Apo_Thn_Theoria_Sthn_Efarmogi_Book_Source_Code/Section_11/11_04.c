#include <stdio.h>

void show_char(int num, char ch);

int main(void)
{
	char ch;
	int i;

	printf("Enter character: ");
	scanf("%c", &ch);

	printf("Enter number: ");
	scanf("%d", &i);

	show_char(i, ch);
	return 0;
}

void show_char(int num, char ch)
{
	int i;

	for (i = 0; i < num; i++)
		printf("%c", ch);
}