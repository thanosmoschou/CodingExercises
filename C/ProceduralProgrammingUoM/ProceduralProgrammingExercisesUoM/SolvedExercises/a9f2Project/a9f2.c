#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	int code, items, last_two_digits_of_code;
	double discount,price ;


	printf("Dwse ton kwdiko tou proiontos:");
	code=GetInteger();

	printf("Dwse ton arithmo twn temaxiwn:");
	items=GetInteger();

	last_two_digits_of_code= code % 100;
	price=((code/100)+last_two_digits_of_code);

	printf("H timh pwlhshs toy proiontos einai: %g\n",price);

	if (items<=30)
	{
		discount=0.1;
	}
	else if (items<=70)
	{
		discount=0.2;
	}
	else
	{
		discount=0.35;
	}

	printf("H ekptwsh einai: %g\n", items*(price*discount));
	price= price*items -  (discount*price)*items;

	printf("H telikh timh ths paragelias einai: %g\n",price);

	return 0;
}
