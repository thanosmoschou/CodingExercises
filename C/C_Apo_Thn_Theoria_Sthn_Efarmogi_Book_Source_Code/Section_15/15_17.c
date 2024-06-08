#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 5

int main(void)
{
	FILE *fp;
	int i, found, len, back, buf[SIZE], pat[SIZE];

	fp = fopen("test.dat", "rb");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	printf("Enter virus signature (%d integers)\n", SIZE);
	for (i = 0; i < SIZE; i++)
	{
		printf("Enter number: ");
		scanf("%d", &pat[i]);
	}
	len = sizeof(pat);
	found = 0;
	back = len - sizeof(int);
	while (1)
	{
		if (fread(buf, sizeof(int), SIZE, fp) != SIZE)
			break;
		if (memcmp(buf, pat, len) == 0)
		{
			found = 1;
			break;
		}
		else
			fseek(fp, -back, SEEK_CUR); /* Πηγαίνουμε πίσω για να ελέγξουμε την επόμενη πεντάδα. */
	}
	if (found == 1)
		printf("SOS: Virus found\n");
	else
		printf("That virus signature isn't found\n");

	fclose(fp);
	return 0;
}