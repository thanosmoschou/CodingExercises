#include <stdio.h>
#include <stdlib.h>

FILE *open_file(char name[], int *f);

int main(void)
{
	FILE *fp;
	char name[100];
	int flag, sel;

	flag = 0;
	do
	{
		printf("Enter file name: ");
		scanf("%s", name);

		fp = fopen(name, "r"); /* Ελέγχουμε αν υπάρχει το αρχείο. Αν δεν υπάρχει, το ανοίγουμε για εγγραφή. Αλλιώς, το κλείνουμε και γίνεται ερώτηση στο χρήστη. */
		if (fp == NULL)
			fp = open_file(name, &flag);
		else
		{
			fclose(fp);
			printf("Would you like to overwrite existing file (Yes:1 - No:0)? ");
			scanf("%d", &sel);
			if (sel == 1) /* Υπερεγγραφή αρχείου. */
				fp = open_file(name, &flag);
		}
	} while (flag == 0);

	fputs("One", fp);
	fclose(fp);
	return 0;
}
FILE *open_file(char name[], int *f)
{
	FILE *fp;

	fp = fopen(name, "w");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	*f = 1;
	return fp;
}