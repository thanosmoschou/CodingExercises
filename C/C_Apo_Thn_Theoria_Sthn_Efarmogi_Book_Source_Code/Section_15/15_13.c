#include <stdio.h>
#include <stdlib.h>

#define SIZE 5 

int main(void)
{
	FILE *fp;
	int i, arr[SIZE] = { 10, 20, 30, 40, 50 };

	fp = fopen("test.bin", "w+b"); /* ’νοιγμα δυαδικού αρχείου για εγγραφή και ανάγνωση. */
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	fwrite(arr, sizeof(int), SIZE, fp);

	printf("Enter new value: ");
	scanf("%d", &i);
	fseek(fp, 2 * sizeof(int), SEEK_SET); /* Αφού κάθε ακέραιος καταλαμβάνει 4 οκτάδες, η fseek() μετατοπίζει τον δείκτη θέσης του αρχείου 2*sizeof(int) = 8 οκτάδες από την αρχή του αρχείου, ώστε να μεταφερθεί στη θέση που βρίσκεται ο τρίτος ακέραιος. */
	fwrite(&i, sizeof(int), 1, fp);

	fseek(fp, 0, SEEK_SET);
	if (fread(arr, sizeof(int), SIZE, fp) != SIZE)
	{
		fclose(fp);
		printf("Error: fread() failed\n");
		exit(EXIT_FAILURE);
	}
	printf("\n***** File contents *****\n");
	for (i = 0; i < SIZE; i++)
		printf("%d\n", arr[i]);

	fclose(fp);
	return 0;
}