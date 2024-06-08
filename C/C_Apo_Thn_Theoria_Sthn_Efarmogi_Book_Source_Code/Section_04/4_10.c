#include <stdio.h>
int main(void)
{
	int num;

	printf("Enter number: ");
	scanf("%d", &num);

	if ((num & 1) == 1) /* Θα μπορούσαμε να γράψουμε και if(num & 1) */
		printf("The number %d is odd\n", num);
	else
		printf("The number %d is even\n", num);
	return 0;
}