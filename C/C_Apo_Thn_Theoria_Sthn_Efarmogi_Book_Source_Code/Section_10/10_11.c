#include <stdio.h>

#define MIN_SIZE 5
#define MAX_SIZE 100

int main(void)
{
	char str[MAX_SIZE];
	int i, ch;

	printf("Enter text (> %d && < %d): ", MIN_SIZE, MAX_SIZE);
	while (1)
	{
		i = 0;
		while ((ch = getchar()) != '\n' && ch != EOF)
		{
			if (i < MAX_SIZE - 1)
			{
				str[i] = ch;
				i++;
			}
			else
				i++;
		}
		if ((i > MAX_SIZE - 1) || (i <= MIN_SIZE))
			printf("Enter text (> %d && < %d): ", MIN_SIZE, MAX_SIZE);
		else
		{
			str[i] = '\0';
			break;
		}
	}
	printf("%s\n", str);
	return 0;
}