#include <stdio.h>
int main(void)
{
	int i;
	double arr[5];

	for (i = 0; i < 5; i++)
		arr[i] = 1.1 + (i*0.1);
	for (i = 4; i >= 0; i--)
		printf("%f\n", arr[i]);
	return 0;
}