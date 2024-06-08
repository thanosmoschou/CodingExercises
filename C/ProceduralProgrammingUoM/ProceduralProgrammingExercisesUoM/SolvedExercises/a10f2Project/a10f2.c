#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int code,pagio;
	long indication_now,indication_old,katanal_reum,axia_reum_lepta;
	double fpa,final_price;


	printf("Dwse ton kwdiko kathgorias timologiou: ");
	code=GetInteger();

	printf("Dwse thn parousa endeixh toy metrhth: ");
	indication_now=GetLong();

	printf("Dwse thn prohgoumenh endeixh toy metrhth: ");
	indication_old=GetLong();

	katanal_reum= indication_now-indication_old;

	if(katanal_reum<=200)
	{
		axia_reum_lepta=12*katanal_reum;
	}
	else if(katanal_reum<=500)
	{
		axia_reum_lepta=200*12+(katanal_reum-200)*15;
	}
	else if(katanal_reum<=1500)
	{
		axia_reum_lepta=200*12+300*15+(katanal_reum-500)*20;
	}
	else
	{
		axia_reum_lepta=200*12+300*15+1000*20+(katanal_reum-1500)*30;
	}

	if(code==1 || code==2)
	{
		pagio=20;
	}
	else
	{
		pagio=100;
	}

	fpa=(axia_reum_lepta/100+pagio)*0.18;
	final_price=axia_reum_lepta/100+pagio+fpa;

	printf("Katanalwsh reumatos se monades:%ld\n",katanal_reum);
	printf("Axia reumatos (cent): %ld\n",axia_reum_lepta);
	printf("Pagio (eyro): %d\n",pagio);
	printf("FPA (euro): %g\n",fpa);
	printf("Synoliko poso plhrwmhs (euro):%g\n",final_price);

	return 0;
}
