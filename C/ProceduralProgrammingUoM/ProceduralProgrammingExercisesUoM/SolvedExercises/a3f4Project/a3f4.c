#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

//Function declaration
double ceil_dec(double number, int places);


int main()
{
	double number;
	int places;

	//Input
	printf("Dwse arithmo gia stroggylopoihsh:");
	number=GetReal();

	printf("Dwse ton arithmo dekadikwn psifiwn gia stroggulopoihsh:");
	places=GetInteger();

	//Output
	printf("O arithmos stroggilopoihmenos einai:%g" , ceil_dec( number, places));

	return 0;
}

double ceil_dec(double number,int places)
{

	double result, power;;

	//ypsono to 10 eis thn places dil ta psifia poy edosa gia na pollaplasiaso meta to noumero number kai na kano
	//stroggulopoihsh kai meta na kano thn antitheti diadikasia dil to 10 eis thn -places kai meta epi to number

	power= pow(10.0, (double)places);
	result=ceil( (double)number*power);
	power=pow(10.0, - (double)places);
	result=result*power;

	return result;
}
