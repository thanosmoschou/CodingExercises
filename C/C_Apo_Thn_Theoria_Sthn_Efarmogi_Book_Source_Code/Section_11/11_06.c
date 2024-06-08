#include <stdio.h>

char check(char ch);

int main(void)
{
	char ch;

	printf("Enter character: ");
	scanf("%c", &ch);

	printf("%c\n", check(ch));
	return 0;
}
char check(char ch)
{
	switch (ch)
	{
	case 'a':
	case 'b':
	case 'c':
		return ch;

	default:
		return 'z';
	}
}