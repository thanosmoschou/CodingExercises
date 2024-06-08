#include <stdio.h>
int main(void)
{
	double g1, g2, g3, fin_grd, avg, min, max, x;

	printf("Enter grades: ");
	scanf("%lf%lf", &g1, &g2);

	printf("Enter difference: ");
	scanf("%lf", &x);
	if (g1 < g2)
	{
		min = g1;
		max = g2;
	}
	else
	{
		min = g2;
		max = g1;
	}
	avg = (g1 + g2) / 2;
	if ((max - min) < x)
		fin_grd = avg;
	else
	{
		printf("Enter third grade: ");
		scanf("%lf", &g3);
		if (g3 == avg) /* Για απλότητα, κάνουμε μία απλή σύγκριση. Όπως αναφέραμε στο Κ.2, αυτή η σύγκριση δεν είναι ασφαλής. */
			fin_grd = avg;
		else if (g3 < min)
			fin_grd = min;
		else
		{
			if (g3 > avg) /* Πλησιέστερα ειναι η max τιμή*/
				fin_grd = (g3 + max) / 2;
			else
				fin_grd = (g3 + min) / 2;
		}
	}
	printf("%f\n", fin_grd);
	return 0;
}