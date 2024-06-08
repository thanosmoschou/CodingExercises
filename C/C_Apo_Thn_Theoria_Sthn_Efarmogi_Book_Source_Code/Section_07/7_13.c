#include <stdio.h>
int main(void)
{
	int i, k, m;
	float grd, sum_suc, sum_fail, arr1[100], arr2[100];

	sum_suc = sum_fail = 0;
	k = m = 0;
	for (i = 0; i < 100; i++)
	{
		printf("Enter grade: ");
		scanf("%f", &grd);
		if (grd == -1)
			break;

		if (grd >= 5 && grd <= 10)
		{
			sum_suc += grd;
			arr1[k] = grd;
			k++; /* Η μεταβλητή k αυξάνεται κατά ένα, για να αποθηκεύσουμε στον πίνακα τον επόμενο βαθμό. Ταυτόχρονα,  δηλώνει και το πλήθος των ήδη αποθηκευμένων αριθμών. Θα μπορούσε να γραφεί κατευθείαν ως arr1[k++] = grd; Με δύο εντολές είναι πιο ευανάγνωστο. */
		}
		else if (grd >= 0 && grd < 5)
		{
			sum_fail += grd;
			arr2[m] = grd;
			m++;
		}
	}
	if (k != 0)
		printf("\nSuccess_Avg: %.2f\n", sum_suc / k);
	else
		printf("\nAll students failed\n");

	if (m != 0)
		printf("\nFail_Avg: %.2f\n", sum_fail / m);
	else
		printf("\nAll students passed\n");
	return 0;
}