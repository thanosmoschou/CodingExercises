#include <stdio.h>
int main(void)
{
	int i, ans, points;

	points = 0;
	for (i = 0; i < 10; i++)
	{
		printf("Enter answer [1-3]: ");
		scanf("%d", &ans);

		switch (ans)
		{
		case 1:
			points += 3;
			break;

		case 2:
			points += 1;
			break;

		case 3:
			points += 2;
			break;

		default:
			printf("Error: Wrong answer ...\n");
			break;
		}
	}
	printf("Candidate gets %d points in total\n", points);
	return 0;
}