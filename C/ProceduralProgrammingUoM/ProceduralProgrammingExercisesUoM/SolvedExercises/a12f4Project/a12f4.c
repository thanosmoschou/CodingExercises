#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

//Function declaration
long Parag(int num);
double calculate_sin(double x);


int main()
{
	double x;

	//Input
	printf("Dwse to x se aktinia: ");
	x=GetReal();

	printf("sinx: %12.10f",(calculate_sin(x)));


	return 0;
}


//Functions
long Parag(int numb)
{
	int result=1;

	for (int i=1;i<=numb;i++)
	{
		result=result*i;
	}

	return result;

}

double calculate_sin(double x)
{
	int i;
	double sinx=x,sinprev=0,apol;

	for( i=3;i<=11;i+=2)
	{

		if(i==3 || i==7 || i==11) //gia genikeusi dil an den ksero se poion oro na stamathso alla na stamatao mono otan den allazei poli to
		{                                     /*noumero mou tote bazo metriti kai ruthmizo sta mona na menei to + kai sta zuga to -
		                                       Otan leo mona zyga ennoo o oros ths akolouthias dhl o prwtos exei + o deyteros - klp*/
			sinx =sinx - (pow(x, (double) i ))/ (double)Parag(i);
		}
		else
		{
			sinx= sinx  + (pow(x, (double) i))/(double)Parag(i);
		}

		apol=(sinx-sinprev); //h diafora tou neou sinx kai tou prohgoumenou

		if(apol<0) //to metatrepo se thetiko gia logous ypologismou
		{
			apol= -apol;
		}

		if (apol<0.0001 || i==11)
		{
			break;
		}

		sinprev=sinx;// kratao to prohgoumeno apotelesma gia na sugkrino tin diafora me to neo sinx


	}

	printf("n: %d\n",i);
	return sinx;
}
