#include <stdio.h>
int main(void)
{
	int i, rem, flag, dig_times[10] = { 0 }; /* Σε αυτόν τον πίνακα αποθηκεύεται ο αριθμός εμφανίσεων κάθε ψηφίου. Για παράδειγμα, το dig_times[0] δηλώνει πόσες φορές εμφανίζεται το ψηφίο 0. */
	printf("Enter number: ");
	scanf("%d", &i);
	if (i == 0) /* Ελέγχουμε αν ο χρήστης εισήγαγε το 0.*/
		dig_times[0] = 1;
	while (i != 0)
	{
		rem = i % 10;
		if (rem < 0)
			rem = -rem;
		dig_times[rem]++;
		i /= 10;
	}
	flag = 0;
	for (i = 0; i < 10; i++)
	{
		if (dig_times[i] > 1)
		{
			printf("Digit %d appears %d times\n", i, dig_times[i]);
			flag = 1;
		}
	}
	if (flag == 0)
		printf("No digit appears multiple times\n");
	return 0;
}