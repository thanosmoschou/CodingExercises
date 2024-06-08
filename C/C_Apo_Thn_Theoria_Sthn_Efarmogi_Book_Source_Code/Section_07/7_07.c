#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 10

int main(void)
{
	int i;
	double sum, arr[SIZE];

	sum = 0; /* Αρχική τιμή για τον υπολογισμό του αθροίσματος των στοιχείων του πίνακα. */
	srand(time(NULL)); /* Αρχικοποίηση της γεννήτριας παραγωγής τυχαίων ακεραίων. */
	for(i = 0; i < SIZE; i++)
	{
		arr[i] = (double)rand()/RAND_MAX; 
		sum += arr[i];
	}
	printf("Avg = %f\n", sum/SIZE); 
	return 0;
}