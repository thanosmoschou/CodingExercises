#include <stdio.h>

int main(void)
{
#if !defined(VER_1) && !defined(VER_2)
	printf("One\n");
#elif defined(VER_3) || defined(VER_4)
	printf("Two\n");
#else
	printf("Three\n");
#endif
	return 0;
}