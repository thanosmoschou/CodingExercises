//ASKHSH 3 FYLLADIO 1
#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	//Variable declaration
	int syskeues,rest,fifty,twenty,five,one;

	//Prompt Messages
	printf("Dose plithos syskeuwn:");
	syskeues=GetInteger();

	//Computation process
	//DIAIRW TIS SYSKEUES ME TON ARITHMO CONTEINER OSTE NA DO POSA XWRAEI TO KATHENA, ENW TO YPOLOIPO THS DIAIRESIS TO
	//PERNAW SE ALLH VARIABLE WSTE NA DIAIRETHEI KSANA ME PIO MIKRO ARITHMO CONTEINER
	fifty=syskeues/50;
	rest=syskeues%50;
	twenty=rest/20;
	rest=rest%20;
	five=rest/5;
	one=rest%5;

	//Output messages
	printf("50 %d\n",fifty);
	printf("20 %d\n",twenty);
	printf("5 %d\n",five);
	printf("1 %d\n",one);

	return 0;
}
