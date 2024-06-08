#include <stdio.h>

double sum_cube(int num);

int main(void)
{
	int i;

	do
	{
		printf("Enter number: ");
		scanf("%d", &i);
	} while (i < 0 || i > 1000);
	printf("Result = %.0f\n", sum_cube(i));
	return 0;
}

double sum_cube(int num)
{
	int i;
	double sum; /* Δηλώνεται σαν double και όχι int για να μπορούμε να αποθηκεύσουμε μεγαλύτερους αριθμούς. */
	sum = 0;
	for (i = 1; i <= num; i++)
		sum += i*i*i;

	return sum;
}