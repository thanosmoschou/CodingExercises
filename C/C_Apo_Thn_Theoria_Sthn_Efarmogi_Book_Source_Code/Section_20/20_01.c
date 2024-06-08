#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char *tot_str;
	int i, tot_chars;

	if (argc == 1) /* Ελέγχουμε αν η γραμμή εντολών περιέχει μόνο το όνομα του προγράμματος. */
	{
		printf("Missing arguments ...\n");
		exit(EXIT_FAILURE);
	}
	tot_chars = 0; /* Μεταβλητή που μετράει το πλήθος των χαρακτήρων όλων των αλφαριθμητικών. */
	for (i = 1; i < argc; i++) /* Υπενθυμίζεται ότι ο δείκτης argv[1] δείχνει στο πρώτο αλφαριθμητικό, ο argv[2] στο δεύτερο, κ.ο.κ. Ο δείκτης argv[0] δείχνει στο όνομα του προγράμματος. */
		tot_chars += strlen(argv[i]);

	tot_str = (char*)malloc(tot_chars + 1); /* Δεσμεύουμε μία επιπλέον θέση για τον χαρακτήρα '\0'. */
	if (tot_str == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	*tot_str = '\0'; /* Απαραίτητη αρχικοποίηση της μνήμης με τον τερματικό χαρακτήρα. */
	for (i = 1; i < argc; i++)
		strcat(tot_str, argv[i]);

	printf("The merged string is: %s\n", tot_str);
	free(tot_str);
	return 0;
}