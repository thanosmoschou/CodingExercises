#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#include "math.h"

#define sinol_kostos 20000
#define discount 0.1
#define ticket 350


int main()
{
	int motion_code,num_people;
	long poso_eispr,kathar_kerd,kostos;

	kathar_kerd=0;
	poso_eispr=0;

	//Prompt messages with  while loop for validation control
	printf("Dwse kwdiko: ");
	motion_code=GetInteger();
	while (motion_code!=1 && motion_code!=2)
	{
		printf("Lathos!\n");
		printf("Dwse kwdiko: ");
		motion_code=GetInteger();
	}


	//Computation with while loop
	while (motion_code==1)
	{
		printf("Dwse arithmo atomwn: ");
		num_people=GetInteger();

		if (num_people<=10)
		{
			kostos= num_people*ticket;
		}
		else
		{
			kostos=ceil((ticket-(ticket*discount)))*num_people;
		}

		printf("Kostos: %ld\n",kostos);
		poso_eispr+=kostos;

		//Update of my logical condition so i won't have an infinite loop
		printf("Dwse kwdiko: ");
		motion_code=GetInteger();

		//Validation process
		while (motion_code!=1 && motion_code!=2)
		{
			printf("Lathos!\n");
			printf("Dwse kwdiko: ");
			motion_code=GetInteger();
		}


	}

	kathar_kerd=poso_eispr-sinol_kostos;
	//Output
	printf("Kerdos: %ld",kathar_kerd);

	return 0;
}
