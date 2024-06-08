#include <stdio.h>
int main(void)
{
	int set_prc;
	float min, max, prc, sum_prc;

	set_prc = 0; /* Σε αυτή τη μεταβλητή αποθηκεύεται το πλήθος των προϊόντων με τιμή στο συγκεκριμένο διάστημα τιμών. */
	sum_prc = 0; /* Σε αυτή τη μεταβλητή αποθηκεύεται το άθροισμα των τιμών στο συγκεκριμένο διάστημα. */
	min = 100;
	max = 0;
	while (1)
	{
		printf("Enter price: ");
		scanf("%f", &prc);
		if (prc == -1)
			break;

		if (prc >= 5 && prc <= 30)
		{
			sum_prc += prc;
			set_prc++;
		}
		if (max < prc)
			max = prc;
		if (min > prc)
			min = prc;
	}
	printf("\nMin = %f, Max = %f\n", min, max);
	if (set_prc != 0)
		printf("Avg = %.2f\n", sum_prc / set_prc);
	else
		printf("No product is included\n");
	return 0;
}