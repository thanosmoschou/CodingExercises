#include <stdio.h>
int main(void)
{
	int i, num;

	while (1)
	{
		printf("\nEnter number: ");
		scanf("%d", &num);
		if (num < 0 || num > 255)
			break;

		for (i = 7; i >= 0; i--) /* Έλεγχος της τιμής του κάθε bit. */
		{
			if ((num >> i) & 1)
				printf("1");
			else
				printf("0");
		}
	}
	return 0;
}