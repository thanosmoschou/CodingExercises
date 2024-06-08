#include<stdio.h>
#include<ctype.h>
#include<string.h>


int main()
{
	int numtochar;
	char let;

	printf("Insert a value from 1 to 26:");
	scanf("%d", &numtochar);

	printf("Number: %d Capital  Letter: %c  Lowercase Letter: %c\n", numtochar, numtochar+64, numtochar+96);

	printf("Insert a letter in lowercase:");
	scanf(" %c", &let);

	printf("Letter's row in alphabet: %d", let-96);
	//system("pause");
}
