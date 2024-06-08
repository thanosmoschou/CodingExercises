#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	//Var. Declaration
	int real_time,estimated_time,time_difference,acceptable_time_difference;
	//string indication;

	//Input
	printf("Dose problepomeno xrono:");
	estimated_time=GetInteger();

	printf("Dose pragmatiko xrono:");
	real_time=GetInteger();

	//Computation
	time_difference=real_time-estimated_time;


	/*Elegxo an o provlepomenos xronos einai  sta oria kai se kathe orio ekxoro se metavliti
	ton antistoixo apodekto xrono kai elegxo an h diafora pragmatikoy kai provlepomenou xronou
	einai megaliteri,mikroteri h isi me ton apodekto xrono kai ekxoro se string var. mia endiksi*/
	if(estimated_time<=29)
	{
		acceptable_time_difference=1;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		/*edo elegxo tin diafora.. an px h apodekti diafora einai 1 tote ennoei +-1 dhl 1 pano ena kato
		ego omos thelo an einai pio kato apo 1 na emfanizo big(px an h problepomeni oraa einai 20
		kai ego doso 18 tote eimai big o problepomenos xronos eno an doso 22 eimai small os problepomenos xronos..opote gia ayto pairnei kai arnhtikes times
		h time_difference oste na do an eimai noris.. fisika 2 lepta pali kathistero alla prepei na exo arnitikes times gia to noris..
		kai min valeis apolites times giati tha uparxei thema)kai an einai pano apo 1 na emfanizo small kathos o provlepomenos xronos htan mikroteros
		auto to kano elegxontas an h metavliti time_difference einai sto analogo diasthma pou kathoristike
		px an h epitrepti diafora einai 1 ennoeitai oti einai to +-1 diladi -1<=time_difference<=1 oste o xronos na einai good.
		An einai pio kato paei big kai an einai pio pano paei small. Fusika auto tha to katalaveis kalytera an valeis tis ores oste na deis
		pos phgainei.. Me analogo tropo oles oi periptoseis*/
		if(time_difference>1 )
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-1 )
		{
			//indication="BIG";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}
	else if(estimated_time<=59)
	{
		acceptable_time_difference=2;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		if(time_difference>2  )
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-2 )
		{
			//indication="BIG";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}
	else if(estimated_time<=89)
	{
		acceptable_time_difference=3;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		if(time_difference>3  )
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-3  )
		{
			//indication="";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}
	else if(estimated_time<=119)
	{
		acceptable_time_difference=4;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		if(time_difference>4 )
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-4)
		{
			//indication="BIG";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}
	else if(estimated_time<=179)
	{
		acceptable_time_difference=6;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		if(time_difference>6)
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-6)
		{
			//indication="BIG";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}
	else if(estimated_time<=239)
	{
		acceptable_time_difference=8;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		if(time_difference>8)
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-8)
		{
			//indication="BIG";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}
	else if(estimated_time<=359)
	{
		acceptable_time_difference=13;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		if(time_difference>13)
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-13)
		{
			//indication="BIG";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}
	else
	{
		acceptable_time_difference=17;
		printf("Apodekth diafora:%d\n",acceptable_time_difference);
		printf("Diafora eisodou:%d\n",time_difference);

		if(time_difference>17)
		{
			//indication="SMALL";
			printf("SMALL");
		}
		else if(time_difference<-17)
		{
			//indication="BIG";
			printf("BIG");
		}
		else
		{
			//indication="GOOD";
			printf("GOOD");
		}
	}

	//Output....Mporousa na ta emfanizo kathe fora apla einai pleonasmos
	//printf("Apodekth diafora:%d\n",acceptable_time_difference);
	//printf("Diafora eisodou:%d\n",time_difference);
	//printf(indication);


	return 0;

}
