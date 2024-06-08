#include <stdio.h>
#include <string.h>
int main(int argc, char *argv[])
{
	int i, len;

	if (argc != 2)
	{
		printf("Wrong number of arguments\n");
		return 0;
	}
	if (strncmp(argv[1], "www.", 4) != 0)
	{
		printf("Name must begin with www.\n");
		return 0;
	}
	len = strlen(argv[1]);
	for (i = 4; i < len; i++)
	if (argv[1][i] == '.')
		break;

	if (i == len)
	{
		printf("Second . is missing\n");
		return 0;
	}
	if ((len - i - 1) != 2 && (len - i - 1) != 3)
	{
		printf("The last part should be two or three characters long\n");
		return 0;
	}
	printf("The hostname %s is valid\n", argv[1]);
	return 0;
}