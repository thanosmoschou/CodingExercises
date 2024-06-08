#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{

	for(int i=1;i<=10;i++) //oli h propaideia apo to 1 os to 10 apla thelo 2 for gia na kano ta ginomena pou thelo
   {                                  //px i=1 ara 1*1, 1*2 klp oso auxanetai to j meta 2*1,2*2 klp
		printf("%4d",i);
		for(int j=1;j<=10;j++)
		{
			printf("%4d",i*j);
		}
		printf("\n");
	}


	system("pause");
}
