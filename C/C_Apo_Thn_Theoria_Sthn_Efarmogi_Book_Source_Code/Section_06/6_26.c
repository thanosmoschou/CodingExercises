#include <stdio.h>
int main(void)
{
	int i = 1; /* Θέτουμε μία αρχική τιμή, εκτός από μηδέν, ώστε να είμαστε σίγουροι ότι ο βρόχος θα εκτελεστεί. */
	while (i != 0)
	{
		printf("Enter number: ");
		scanf("%d", &i);
		if (i != 0)
			printf("Num = %d\n", i);
	}
	return 0;
}