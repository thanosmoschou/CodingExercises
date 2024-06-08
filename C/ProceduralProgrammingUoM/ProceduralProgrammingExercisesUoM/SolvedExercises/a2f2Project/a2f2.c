#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int a,b,c,result;

	result=(a=GetInteger(),b=GetInteger(),c=GetInteger(),(a!=0 && b!=0) && c ==0);
	printf("%d\n",result);

	result=(a!=0 &&(b!=0 || c!=0));
	printf("%d\n",result);

	result=(a!=0 || b!=0);
	printf("%d",result);

	return 0;
}
