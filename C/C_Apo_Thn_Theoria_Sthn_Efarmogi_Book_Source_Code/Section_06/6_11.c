#include <stdio.h>
int main(void)
{
	int i, years, pop, pop_incr;
	double rate;

	printf("Enter population: ");
	scanf("%d", &pop);

	printf("Enter increase rate (%%): ");
	scanf("%lf", &rate);

	printf("Enter years: ");
	scanf("%d", &years);
	printf("\nYear\tIncrease\tPopulation\n");
	printf("----------------------------------------\n");
	for (i = 1; i <= years; i++)
	{
		pop_incr = pop*rate / 100; /* Υπολογισμός αύξησης πληθυσμού. */
		pop += pop_incr; /* Υπολογισμός νέου πληθυσμού. */
		printf("%d\t%d\t\t%d\n", i, pop_incr, pop);
	}
	return 0;
}