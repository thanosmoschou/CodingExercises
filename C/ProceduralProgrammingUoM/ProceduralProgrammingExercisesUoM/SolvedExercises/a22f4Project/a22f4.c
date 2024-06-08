#include <stdio.h>
#include "simpio.h"
#include "genlib.h"


//Function declaration
double dapan( int category, int plith, double price);
double fpa(double price, int plith, int category);

int main()
{
	int plithos,katig_fpa;
	double timi_monad, sum_dap=0, sum_fpa=0;

	for (int i=1; i<=5; i++)
   {
		printf("Dwse to plithos temaxiwn  apo to proion %d:",i);
		plithos=GetInteger();

		printf("Dwse timi gia to proion %d:",i);
		timi_monad=GetReal();

		printf("Dwse kathgoria FPA gia to proion %d:",i);
		katig_fpa=GetInteger();

		sum_dap=sum_dap+ dapan(katig_fpa, plithos,timi_monad);
		sum_fpa=sum_fpa+fpa(timi_monad,plithos,katig_fpa);

	}

	printf("Synoliko kostos:%g\n",sum_dap);
	printf("Synoliko fpa:%g\n",sum_fpa);


	return 0;
}


//Functions

double dapan( int category, int plith, double price)
{

	if(category<1 || category >4)
	{
		printf("Lathos kathgoria FPA\n");
		return plith*price;
	}

	return (plith*price) + fpa(price, plith, category);

}


double fpa(double price, int plith, int category)
{
	switch (category)
	{
		case 2:
			return 0.06*(plith*price);
		case 3:
			return 0.13*(plith*price);
		case 4:
			return 0.19*(plith*price);
		default:
			return 0;
	}
}
