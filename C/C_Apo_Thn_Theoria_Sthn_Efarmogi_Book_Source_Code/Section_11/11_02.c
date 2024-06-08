#include <stdio.h>

int square(int a);
int cube(int a);

int main(void)
{
	int i, j, k;

	printf("Enter number: ");
	scanf("%d", &i);

	j = square(i);
	k = cube(i);
	printf("sum = %d\n", j + k); /* Θα μπορούσαμε να μην χρησιμοποιήσουμε τις μεταβλητές j, k και να γράψουμε κατευθείαν printf("sum = %d\n", square(i)+cube(i)); */
	return 0;
}

int square(int a)
{
	return a*a;
}

int cube(int a)
{
	return a*a*a;
}