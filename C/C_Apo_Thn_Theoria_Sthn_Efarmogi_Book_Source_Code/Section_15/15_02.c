#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE *fp;
	double prc;

	fp = fopen("test.txt", "w");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	while (1)
	{
		printf("Enter price: ");
		scanf("%lf", &prc);
		if (prc == -1)
			break;
		if (prc > 10 && prc < 20)
			fprintf(fp, "%f\n", prc);
	}
	fclose(fp);
	return 0;
}