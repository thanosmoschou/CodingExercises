#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int disekto(int year);

int main()
{
	int y1,y2;

	printf("Dwse 2 eti:\n");
	printf("Dwse to proto:");
	y1=GetInteger();

	printf("Dwse to deutero:");
	y2=GetInteger();

	for(int i=y1; i<=y2; i++)
    {
    	if(disekto(i))
		{
			printf("%d Disekto\n",i);
		}
    }
	return 0;
}


int disekto( int year)
{
	return ( (year%4==0) || (year % 100 ==0 && year %400 ==0) ); //an isxuei to disekto tha epistrepsei 1 alliws 0
	//den vazo if gia na glitoso kwdika afou mporo kateytheian na epistrepso logikh synthiki poy epistrefei 0 h 1
}
