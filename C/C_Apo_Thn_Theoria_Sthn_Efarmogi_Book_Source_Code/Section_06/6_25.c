#include <stdio.h>
int main(void)
{
	int x, y, z, flag;
	
	flag = 1;
	for(x = -30; x <= 30; x++)
		for(y = -30; y <= 30; y++) 
			for(z = -30; z <= 30; z++) 
				if(3*x + 7*y – 5*z == 10)
				{
					printf("Solution: %d %d %d\n", x, y, z);
					flag = 0;
				}
	if(flag)
		printf("No solution\n");
	return 0;
}