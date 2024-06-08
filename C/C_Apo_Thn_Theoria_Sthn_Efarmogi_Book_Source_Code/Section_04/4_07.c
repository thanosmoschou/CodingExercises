#include <stdio.h>
int main(void)
{
	int num, key;

	printf("Enter key: ");
	scanf("%d", &key);

	printf("Enter number: ");
	scanf("%d", &num);

	num = num ^ key;
	printf("Encrypted : %d\n", num);

	num = num ^ key;
	printf("Original: %d\n", num);
	return 0;
}