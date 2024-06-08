#include <stdio.h>

#define SIZE 100

int main(void)
{
	int i, max_1, max_2, arr[SIZE];

	for (i = 0; i < SIZE; i++)
	{
		printf("Enter number: ");
		scanf("%d", &arr[i]);
	}
	max_1 = max_2 = arr[0];
	for (i = 1; i < SIZE; i++)
	{
		if (max_1 != arr[i])
		{
			max_2 = arr[i]; /* θέτουμε αυτή την τιμή στην max_2, για να τη συγκρίνουμε με τα υπόλοιπα στοιχεία. */
			break;
		}
	}
	if (i == SIZE)
	{
		printf("Array contains the same value: %d\n", max_1);
		return 0;
	}
	/* Συνεχίζουμε με την εκτέλεση του βρόχου από εκεί που σταματήσαμε προηγουμένως. */
	for (; i < SIZE; i++)
	{
		if (arr[i] > max_1)
		{
			max_2 = max_1; /* Η δεύτερη μεγαλύτερη τιμή γίνεται ίση με την έως τώρα μεγαλύτερη. */
			max_1 = arr[i];
		}
		else if (arr[i] > max_2 && arr[i] != max_1) /* Ψάχνουμε τη δεύτερη μεγαλύτερη τιμή που να είναι διαφορετική της πρώτης. */
			max_2 = arr[i];
	}
	printf("First_Max = %d and Sec_Max = %d\n", max_1, max_2);
	return 0;
}