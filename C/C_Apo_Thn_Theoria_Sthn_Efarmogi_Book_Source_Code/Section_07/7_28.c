#include <stdio.h>

#define STUDS   100
#define COURSES 10

int main(void)
{
	int i, j, min_pos, max_pos;
	float sum, min_grd, max_grd, avg_grd, min_avg_grd, max_avg_grd, grd[STUDS][COURSES];

	min_pos = max_pos = 0;
	max_avg_grd = 0; /* Αρχικοποίηση με τη μικρότερη δυνατή τιμή. */
	min_avg_grd = 10; /* Αρχικοποίηση με τη μεγαλύτερη δυνατή τιμή. */
	for (i = 0; i < STUDS; i++)
	{
		sum = 0;
		max_grd = 0;
		min_grd = 10;
		for (j = 0; j < COURSES; j++)
		{
			do
			{
				printf("Enter grade of student_%d for lesson_%d: ", i + 1, j + 1);
				scanf("%f", &grd[i][j]);
			} while (grd[i][j] < 0 || grd[i][j] > 10);

			sum += grd[i][j];
			if (grd[i][j] >= max_grd)
				max_grd = grd[i][j];
			if (grd[i][j] <= min_grd)
				min_grd = grd[i][j];
		}
		avg_grd = sum / COURSES;
		if (avg_grd > max_avg_grd)
		{
			max_avg_grd = avg_grd;
			max_pos = i;
		}
		if (avg_grd < min_avg_grd)
		{
			min_avg_grd = avg_grd;
			min_pos = i;
		}
		printf("Student_%d: Avg = %.2f Max = %.2f Min = %.2f\n", i + 1, avg_grd, max_grd, min_grd);
	}
	printf("\nStudent_%d has the higher average %.2f and student_%d has the lower average %.2f\n", max_pos, max_avg_grd, min_pos, min_avg_grd);
	return 0;
}