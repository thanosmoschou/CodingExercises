#include <stdio.h>
int main(void)
{
	int i;

	for (i = 0; i < 26; i++)
		printf("%c(%d)-%c(%d)\n", 'a' + i, 'a' + i, 'A' + i, 'A' + i);
	return 0;
}