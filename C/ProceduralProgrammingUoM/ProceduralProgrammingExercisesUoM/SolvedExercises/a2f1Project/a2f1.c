#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int mikos1,mikos2,emv;

	printf("Dwse to mhkos ths 1hs kathetis pleuras:");
	mikos1=GetInteger();

	printf("Dwse to mhkos ths 2hs kathetis pleuras:");
	mikos2=GetInteger();

	emv=(mikos1*mikos2)/2;

	printf("To emvado einai:%d",emv);


	return 0;
}
