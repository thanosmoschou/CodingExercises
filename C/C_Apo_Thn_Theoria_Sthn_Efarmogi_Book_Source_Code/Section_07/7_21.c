#include <stdio.h>

#define MAX_CARS 20

int main(void)
{
	int i, tmp, cars, car_mins[MAX_CARS], car_hours[MAX_CARS];
	double bill, total_bill;

	do
	{
		printf("Enter number of cars [1-%d]: ", MAX_CARS);
		scanf("%d", &cars);
	} while (cars <= 0 || cars >= MAX_CARS);

	for (i = 0; i < cars; i++)
	{
		do
		{
			printf("Enter hours for car_%d [max=24h]: ", i + 1);
			scanf("%d", &car_hours[i]);
		} while (car_hours[i] > 24 || car_hours[i] < 0);

		if (car_hours[i] == 24) /* Μέγιστη διάρκεια. */
		{
			car_mins[i] = 0;
			continue;
		}
		do
		{
			printf("Enter minutes for car_%d [max=59min]: ", i + 1);
			scanf("%d", &car_mins[i]);
		} while (car_mins[i] > 59 || car_mins[i] < 0);
	}
	total_bill = 0;

	printf("\nCar\tTime\tCharge\n");
	for (i = 0; i < cars; i++)
	{
		bill = 6; /* Για τις πρώτες 3 ώρες. */
		tmp = (car_hours[i] - 3);
		if (tmp >= 0)
		{
			bill += tmp*1.5; /* Για τις πρόσθετες ώρες. */
			if (car_mins[i] > 0)
				bill += 1.5;
			if (bill > 12)
				bill = 12;
		}
		printf("%d\t%d.%d'\t%.2f\n", i + 1, car_hours[i], car_mins[i], bill);
		total_bill += bill;
	}
	printf("SUM\t\t%.2f\n", total_bill);
	return 0;
}