#include <stdio.h>
int main(void)
{
	char ch1, ch2, ch3;

	printf("Enter characters: ");
	scanf("%c%c%c", &ch1, &ch2, &ch3);

	if ((ch1 + 1 == ch2) && (ch2 + 1 == ch3))
		printf("Consecutive\n");
	else
		printf("Not Consecutive\n");
	return 0;
}