#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	int vathm_a,vathm_b,vathm_c,MO;

	printf("Dwse vathmo A triminou?");
	vathm_a=GetInteger();

	printf("Dwse vathmo B triminou?");
	vathm_b=GetInteger();

	printf("Dwse vathmo C triminou?");
	vathm_c=GetInteger();

	MO=(vathm_a+vathm_b+vathm_c)/3;

	printf("O mesos oros tou mathiti einai:%d",MO);
	return 0;
}
