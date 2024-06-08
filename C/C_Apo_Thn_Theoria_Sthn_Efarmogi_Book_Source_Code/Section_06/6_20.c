#include <stdio.h>
int main(void)
{
	int i, num;

	printf("Enter number (>1): ");
	scanf("%d", &num);

	if (num > 1)
	{
		if (num % 2 == 0)
		{
			if (num == 2)
				printf("%d is prime\n", num);
			else
				printf("%d is not prime\n", num);
			return 0;
		}
		for (i = 3; i <= num / 2; i += 2)
		{
			if (num % i == 0)
			{
				printf("%d is not prime\n", num);
				return 0; /* Αφού βρήκαμε έναν διαιρέτη,  δεν χρειάζεται να ψάξουμε και για άλλους διαιρέτες, οπότε το πρόγραμμα τερματίζεται άμεσα. */
			}
		}
		printf("The number %d is prime\n", num);
	}
	else
		printf("Error: Not valid number\n");
	return 0;
}