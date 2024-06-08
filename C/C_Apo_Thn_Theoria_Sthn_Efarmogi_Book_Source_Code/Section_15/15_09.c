#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	FILE *fp;
	char str[100];
	int ch, lines;

	printf("Enter file name: ");
	read_text(str, sizeof(str), 1);

	fp = fopen(str, "r");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	printf("\nLine contents\n");
	lines = 1;
	while (1)
	{
		ch = getc(fp);
		if ((ch == EOF) || (lines > 2))
			break;
		if (ch == '\n') /* Όταν διαβαστεί ο χαρακτήρας νέας γραμμής αυξάνεται η μεταβλητή που μετράει τις γραμμές του αρχείου. */
			lines++;
		if (lines == 2) /* Μόνο οι χαρακτήρες της δεύτερης γραμμής εμφανίζονται στην οθόνη. */
			printf("%c", ch);
	}
	fclose(fp);
	return 0;
}

int read_text(char str[], int size, int flag)
{
	int len;

	if (fgets(str, size, stdin) == NULL)
	{
		printf("Error: fgets() failed\n");
		exit(EXIT_FAILURE);
	}
	len = strlen(str);
	if (len > 0)
	{
		if (flag && (str[len - 1] == '\n'))
		{
			str[len - 1] = '\0';
			len--;
		}
	}
	else
	{
		printf("Error: No input\n");
		exit(EXIT_FAILURE);
	}
	return len;
}