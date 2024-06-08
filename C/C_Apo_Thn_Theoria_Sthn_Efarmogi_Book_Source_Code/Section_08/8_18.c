#include <stdio.h>

#define SIZE 31

int main(void)
{
	int i;
	double temp, arr[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter temperatures: ");
		scanf("%lf", arr + i);
	}
	printf("Enter temperature to check: ");
	scanf("%lf", &temp);
	for (i = 0; i < SIZE; i++)
	{ /* Τα άγκιστρα δεν χρειάζονται. Τα προσθέτουμε για λόγους ευαναγνωσιμότητας. */
		if (*(arr + i) < temp)
			break;
	}
	if (i == SIZE)
		printf("No temperature less than %.1f\n", temp);
	else
		printf("The first temperature less than %.1f was %.1f in day %d\n", temp, *(arr + i), i + 1);
	return 0;
}