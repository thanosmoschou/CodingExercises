#include <stdio.h>

#define SEATS 300

int main(void)
{
	int sel, adults, tkts, rsvd_seats;
	float cost, tot_cost;

	rsvd_seats = 0;
	tot_cost = 0;
	while (1)
	{
		printf("\nMenu selections\n");
		printf("---------------\n");

		printf("1. Buy Ticket\n");
		printf("2. Show Information\n");
		printf("3. Exit\n");

		printf("\nEnter choice: ");
		scanf("%d", &sel);
		switch (sel)
		{
		case 1:
			printf("\nHow many tickets would you like to buy? ");
			scanf("%d", &tkts);
			if (tkts + rsvd_seats > SEATS)
			{
				printf("\nSorry, the available seats are %d\n", SEATS - rsvd_seats);
				break;
			}
			while (1)
			{
				printf("\nHow many adults? ");
				scanf("%d", &adults);

				if (adults <= tkts)
					break;
				else
					printf("Error: Wrong number of persons\n");
			}
			cost = adults * 15 + (tkts - adults) * 10;
			if (tkts > 3)
				cost *= 0.9;
			tot_cost += cost;
			rsvd_seats += tkts;
			if (rsvd_seats == SEATS)
			{
				printf("\nNot available seats. Income: %.2f\n", tot_cost);
				return 0;
			}
			break;

		case 2:
			printf("\nFree seats: %d Income: %.2f\n\n", SEATS - rsvd_seats, tot_cost);
			break;

		case 3:
			return 0;

		default:
			printf("\nWrong choice\n");
			break;
		}
	}
	return 0;
}