#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	FILE *fp;
	int i, grd_num;
	float *grd_arr, grd;

	fp = fopen("test.bin", "rb");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	if (fread(&grd_num, sizeof(int), 1, fp) != 1)
	{
		fclose(fp);
		printf("Error: fread() failed\n");
		exit(EXIT_FAILURE);
	}
	grd_arr = (float*)malloc(grd_num * sizeof(float)); /* Δέσμευση μνήμης για την αποθήκευση των βαθμών. */
	if (grd_arr == NULL)
	{
		fclose(fp);
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	/* Διάβασμα των βαθμών και έλεγχος ότι δεν συνέβη κάποιο λάθος. */
	if (fread(grd_arr, sizeof(float), grd_num, fp) == grd_num)
	{
		printf("Enter grade: ");
		scanf("%f", &grd);
		for (i = 0; i < grd_num; i++)
		if (grd_arr[i] > grd)
			printf("%f\n", grd_arr[i]);
	}
	else
		printf("Error: fread() failed to read grades\n");

	free(grd_arr);
	fclose(fp);
	return 0;
}