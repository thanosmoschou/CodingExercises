#include <stdio.h>

#define SIZE 10

int main(void)
{
	int i, num, arr[SIZE] = { 0 }; /* Αφού η τιμή 0 δεν είναι αποδεκτή τιμή, τη χρησιμοποιούμε σαν ένδειξη ότι δεν έχει γίνει ανάθεση κάποιας τιμής. */
	for (i = 0; i < SIZE; i++)
	{
		do
		{
			printf("Enter number: ");
			scanf("%d", &num);
			if (num == 0 || num == -1)
				printf("Not valid input !!!\n");
		} while (num == 0 || num == -1);

		if (i & 1) /* Ελέγχουμε αν ο δείκτης θέσης είναι περιττός. */
		{
			if (num & 1) /* Αν ο δείκτης θέσης και ο ακέραιος που εισήγαγε ο χρήστης είναι περιττοί, ο ακέραιος αποθηκεύεται στον πίνακα. */
				arr[i] = num;
		}
		else
		{
			if ((num & 1) == 0) /* Αν ο δείκτης θέσης και ο ακέραιος που εισήγαγε ο χρήστης είναι άρτιοι, ο ακέραιος αποθηκεύεται στον πίνακα. */
				arr[i] = num;
		}
	}
	printf("\n*** Array elements ***\n");
	for (i = 0; i < SIZE; i++)
	{
		if (arr[i] == 0)
			arr[i] = -1;
		printf("%d\n", arr[i]);
	}
	return 0;
}