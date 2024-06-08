#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	int i;

	//Typwnw olous tous arithmous apo to 1 ews to 100 me stoixisi 4 theseis deksia
	for (i=1;i<=100;i++)
	{
		printf("%4d",i);

		//Enas elegxos gia na dw an exw typwsei 10 arithmous ara prepei na allakso grammi
		if (i % 10 ==0)
		{
			printf("\n");
		}
	}

	return 0;
}
