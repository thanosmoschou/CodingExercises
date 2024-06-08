#include <stdio.h>
#include <stdlib.h>

#define LESSONS 5

int main(void)
{
	FILE *fp;
	int i, j, stud_num;
	float **grd_arr, sum_grd;

	fp = fopen("test.bin", "rb");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	if (fread(&stud_num, sizeof(int), 1, fp) != 1)
	{
		fclose(fp);
		printf("Error: fread() failed to read number\n");
		exit(EXIT_FAILURE);
	}
	/* Θα αποθηκεύσουμε τους βαθμούς σε έναν διδιάστατο πίνακα με stud_num γραμμές και LESSONS στήλες. Αρχικά, δεσμεύουμε μνήμη για τις γραμμές του πίνακα και στη συνέχεια δεσμεύουμε μνήμη για κάθε γραμμή. Έτσι, σε κάθε γραμμή αποθηκεύονται οι βαθμοί του φοιτητή σε LESSONS μαθήματα. */
	grd_arr = (float**)malloc(stud_num * sizeof(float*));
	if (grd_arr == NULL)
	{
		fclose(fp);
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < stud_num; i++)
	{
		grd_arr[i] = (float*)malloc(LESSONS * sizeof(float));
		if (grd_arr[i] == NULL)
		{
			fclose(fp);
			printf("Error: Not available memory\n");
			exit(EXIT_FAILURE);
		}
	}
	for (i = 0; i < stud_num; i++)
	{
		sum_grd = 0;
		if (fread(grd_arr[i], sizeof(float), LESSONS, fp) == LESSONS)
		{
			for (j = 0; j < LESSONS; j++)
				sum_grd += grd_arr[i][j];

			printf("%d. %f\n", i + 1, sum_grd / LESSONS);
		}
		else
		{
			printf("Error: fread() failed\n");
			break; /* Δεν υπάρχει λόγος να συνεχίσουμε το διάβασμα. */
		}
	}
	for (i = 0; i < stud_num; i++)
		free(grd_arr[i]);

	free(grd_arr);
	fclose(fp);
	return 0;
}