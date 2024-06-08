#include <stdio.h>

#define LESSONS	3
#define STUDENTS	5

int main(void)
{
	int i, j;
	float grd, stud_grd, sum_grd;

	sum_grd = 0;
	for (i = 0; i < STUDENTS; i++)
	{
		printf("***** Student_%d\n", i + 1);
		stud_grd = 0; /* Αυτή η μεταβλητή μετράει το άθροισμα των βαθμών του κάθε φοιτητή σε όλα τα μαθήματα. Μηδενίζεται για κάθε φοιτητή. */
		for (j = 0; j < LESSONS; j++)
		{
			printf("Enter grade for lesson %d: ", j + 1);
			scanf("%f", &grd);
			stud_grd += grd;
			sum_grd += grd; /* Αυτή η μεταβλητή μετράει το συνολικό άθροισμα όλων των βαθμών. */
		}
		printf("Average grade for student_%d is %.2f\n",
			i + 1, stud_grd / LESSONS);
	}
	printf("\nTotal average grade is %.2f\n",
		sum_grd / (STUDENTS*LESSONS));
	return 0;
}