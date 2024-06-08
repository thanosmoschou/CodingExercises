#include <stdio.h>
int main(void)
{
	float *ptr1, *ptr2, *ptr3, i, j, k;

	ptr1 = &i;
	ptr2 = &j;
	ptr3 = &k;

	printf("Enter grades: ");
	scanf("%f%f%f", ptr1, ptr2, ptr3);

	if ((*ptr1 >= 5) && (*ptr2 >= 5) && (*ptr3 >= 5))
	{
		if (*ptr1 <= *ptr2 && *ptr1 <= *ptr3)
		{
			printf("%f ", *ptr1);
			if (*ptr2 < *ptr3)
				printf("%f %f\n", *ptr2, *ptr3);
			else
				printf("%f %f\n", *ptr3, *ptr2);
		}
		else if (*ptr2 <= *ptr1 && *ptr2 <= *ptr3)
		{
			printf("%f ", *ptr2);
			if (*ptr1 < *ptr3)
				printf("%f %f\n", *ptr1, *ptr3);
			else
				printf("%f %f\n", *ptr3, *ptr1);
		}
		else
		{
			printf("%f ", *ptr3);
			if (*ptr2 < *ptr1)
				printf("%f %f\n", *ptr2, *ptr1);
			else
				printf("%f %f\n", *ptr1, *ptr2);
		}
	}
	else
		printf("Avg = %.2f\n", (*ptr1 + *ptr2 + *ptr3) / 3);
	return 0;
}