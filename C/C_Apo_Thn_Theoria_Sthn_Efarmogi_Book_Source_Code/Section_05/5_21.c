#include <stdio.h>
int main(void)
{
	char sign;
	int i, j; 
	
	printf("Enter math sign and two integers: ");
	scanf("%c%d%d", &sign, &i, &j);

	switch(sign)
	{
		case '+':
			printf("Sum = %d\n", i+j);
		break;

		case '-':
			printf("Diff = %d\n", i-j);
		break;

		case '*':
			printf("Product = %d\n", i*j);
		break;
		case '/':
			if(j != 0)
				printf("Div = %.3f\n", (float)i/j);
			else
				printf("Second num should not be 0\n");
		break;

		default:
			printf("Unacceptable operation\n");
		break;
	}
	return 0;
}