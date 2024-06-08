#include <stdio.h>
int main(void)
{
	int clas;
	double cost, weight;

	printf("Enter class (1-Eco, 2-Business, 3-VIP): ");
	scanf("%d", &clas);

	printf("Enter weight: ");
	scanf("%lf", &weight);

	cost = 0; /* Καλύπτει όλες τις περιπτώσεις που ο επιβάτης δεν πληρώνει. */
	switch (clas)
	{
	case 1:
		if (weight > 40)
			cost = 22.5 + 2 * (weight - 40); /* 22.5 = 1.5 * 15. */
		else if (weight > 25)
			cost = 1.5*(weight - 25);
		break;

	case 2:
		if (weight > 50)
			cost = 18.75 + 1.5*(weight - 50); /* 18.75 = 1.25 * 15. */
		else if (weight > 35)
			cost = 1.25*(weight - 35);
		break;

	case 3:
		if (weight > 60)
			cost = 30;
		break;

	default:
		printf("Error: Wrong traffic class\n");
		return 0;
	}
	printf("Total cost = %.2f\n", cost);
	return 0;
}