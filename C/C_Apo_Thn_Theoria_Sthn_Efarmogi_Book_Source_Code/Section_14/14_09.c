#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char *rvs_str;
	int i, j, len;

	if (argc == 1) /* Ελέγχουμε αν η γραμμή εντολών περιέχει μόνο το όνομα του προγράμματος. */
	{
		printf("Missing string arguments ...\n");
		exit(EXIT_FAILURE);
	}
	for (i = 1; i < argc; i++)
	{
		len = strlen(argv[i]);
		rvs_str = (char*)malloc(len + 1); /* Δεσμεύουμε μία επιπλέον θέση για τον τερματικό χαρακτήρα. */
		if (rvs_str == NULL)
		{
			printf("Error: Not available memory\n");
			exit(EXIT_FAILURE);
		}
		for (j = 0; j < len; j++)
			rvs_str[j] = argv[i][len - 1 - j]; /* Ο τελευταίος χαρακτήρας είναι αποθηκευμένος στη θέση len-1. */

		rvs_str[j] = '\0'; /* Τερματισμός αλφαριθμητικού. */
		printf("Reverse of %s is: %s\n", argv[i], rvs_str);
		free(rvs_str);
	}
	return 0;
}