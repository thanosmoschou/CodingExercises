#include <stdio.h>
int main(void)
{
	int i, mon, mon_days, day, rows;

	while (1)
	{
		printf("\n\nEnter month: ");
		scanf("%d", &mon);

		if (mon < 1 || mon > 12)
			break;

		if (mon == 2)
		{
			printf("Enter Feb days: ");
			scanf("%d", &mon_days);
		}
		else if (mon == 4 || mon == 6 || mon == 9 || mon == 11)
			mon_days = 30;
		else
			mon_days = 31;

		printf("Enter start day (1=Mon,7=Sun): ");
		scanf("%d", &day);

		printf("Mon\tTue\tWed\tThu\tFri\tSat\tSun\n");
		for (i = 1; i < day; i++) /* Προσθέτουμε μερικά κενά μέχρι την πρώτη μέρα του μήνα για τη μορφοποίηση της εξόδου. */
			printf("\t");

		rows = 0;
		for (i = 1; i <= mon_days; i++)
		{
			printf("%d\t", i);
			if (i == 8 - day + (rows * 7))
			{
				printf("\n");
				rows++;
			}
		}
	}
	return 0;
}