#include <stdio.h>

#define SIZE 100

int main(void)
{
	int i, min_pos, max_pos;
	float sum, min_grd, max_grd, grd[SIZE];

	sum = max_grd = 0; /* Αρχικοποιούμε την max_grd με τη μικρότερη δυνατή τιμή. */
	min_grd = 10; /* Αρχικοποίηση με τη μεγαλύτερη δυνατή τιμή. */
	for (i = 0; i < SIZE; i++)
	{
		printf("Enter grade in [0-10]: ");
		scanf("%f", &grd[i]);
		/* Θα μπορούσαμε να ελέγξουμε την τιμή με πολλούς τρόπους. Στην Κ.7.14 χρησιμοποιοιούμε do-while. */
		while (grd[i] < 0 || grd[i] > 10)
		{
			printf("Error - Enter new grade in [0-10]: ");
			scanf("%f", &grd[i]);
		}
		sum += grd[i];
		if (grd[i] > max_grd)
		{
			max_grd = grd[i];
			max_pos = i; /* Αποθήκευση της θέσης με τον μεγαλύτερο βαθμό. */
		}
		if (grd[i] < min_grd)
		{
			min_grd = grd[i];
			min_pos = i; /* Αποθήκευση της θέσης με τον μικρότερο βαθμό. */
		}
	}
	printf("Avg: %.2f H(%d): %.2f L(%d): %.2f\n", sum / SIZE, max_pos, max_grd, min_pos, min_grd);
	return 0;
}