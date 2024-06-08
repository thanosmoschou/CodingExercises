#include <stdio.h>
int main(void)
{
	unsigned int tmp, new_code;

	printf("Enter code: ");
	scanf("%d", &tmp);

	if (tmp == 1234)
	{
		printf("Enter new code: ");
		scanf("%d", &tmp);

		printf("Enter new code once more: ");
		scanf("%d", &new_code);

		if (new_code == tmp)
			printf("New code is stored\n");
		else
			printf("Different codes are entered\n");
	}
	else
		printf("Wrong code\n");
	return 0;
}