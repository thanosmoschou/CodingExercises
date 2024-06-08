#include <stdio.h>
int main(void)
{
	int studs;
	float sum_grd, stud_grd, grd_exc, grd_exam;

	studs = 0;
	sum_grd = 0;
	while (1)
	{
		printf("--------------------------------\n");

		printf("Enter exercise grade [0-10]: ");
		scanf("%f", &grd_exc);

		printf("Enter exam grade [0-10]: ");
		scanf("%f", &grd_exam);

		if (grd_exc == -1 || grd_exam == -1)
			break;

		if ((grd_exc < 0) || (grd_exc > 10) ||
			(grd_exam < 0) || (grd_exam > 10))
		{
			printf("Error: Grades should be in [0-10]\n");
			continue;
		}
		studs++;
		if (grd_exc >= 5 && grd_exam >= 5)
			stud_grd = 0.3*grd_exc + 0.7*grd_exam;
		else
		{
			if (grd_exc <= grd_exam)
				stud_grd = grd_exc;
			else
				stud_grd = grd_exam;
		}
		printf("Student grade = %.2f\n", stud_grd);
		sum_grd += stud_grd;
	}
	if (studs)
		printf("\nAverage grade = %.2f\n", sum_grd / studs);
	return 0;
}