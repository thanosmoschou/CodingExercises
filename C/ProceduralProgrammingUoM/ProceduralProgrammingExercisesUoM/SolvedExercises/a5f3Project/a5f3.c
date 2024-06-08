#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int n,kwd,filo,var,ypsos,age,maxyps=0,maxcod,maxilik,maxvaros,maxfilo;

	printf("Dwse plithos n gia tis pentades arithmwn pou tha dwseis(px 2 pentades ara n=2:");
	n=GetInteger();

	for(int i=0;i<n;i++)
	{

			printf("Kwdikos:");
			kwd=GetInteger();

			printf("Filo:");
			filo=GetInteger();

			printf("Varos:");
			var=GetInteger();

			printf("Ypsos:");
			ypsos=GetInteger();

			printf("Hlikia:");
			age=GetInteger();

			if( filo==0 && ypsos>maxyps)
			{
				maxcod=kwd;
				maxfilo=filo;
				maxilik=age;
				maxvaros=var;
				maxyps=ypsos;
			}

	}

	printf("%d %d %d %d %d",maxcod,maxfilo,maxvaros,maxyps,maxilik);



	return 0;
}
