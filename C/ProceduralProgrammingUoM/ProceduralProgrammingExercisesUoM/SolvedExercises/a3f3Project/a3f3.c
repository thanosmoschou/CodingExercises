#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

#define telies 3500
#define teliex 5000

int main()
{
	long kiv_es,kiv_ex,gen_sin=0,gensin_es=0,gensin_ex=0, sin_es,sin_ex,sinol;

	//Input
	printf("Arithmos kibwtiwn eswterikou?");
	kiv_es=GetLong();

	if(kiv_es>=0)
	{
		printf("Arithmos kibwtiwn exwterikou?");
		kiv_ex=GetLong();
	}

	while(kiv_es>=0 && kiv_ex >=0)
	{
		sin_es=telies*kiv_es;
		sin_ex=teliex*kiv_ex;
		sinol= sin_es+sin_ex;

		gensin_es+=sin_es;
		gensin_ex+=sin_ex;
		gen_sin+=sinol;

		printf("%10ld %10ld %10ld\n",sin_es,sin_ex,sinol);


		printf("Arithmos kibwtiwn eswterikou?");
		kiv_es=GetLong();

		if(kiv_es<0)
		{
			break;
		}
		else
		{
			printf("Arithmos kibwtiwn exwterikou?");
			kiv_ex=GetLong();
		}

	}

	printf("%10ld %10ld %10ld\n", gensin_es,gensin_ex,gen_sin);


	return 0;
}
