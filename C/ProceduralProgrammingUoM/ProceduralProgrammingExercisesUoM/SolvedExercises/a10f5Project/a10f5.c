#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

#define NumCont 4
#define Cont2 5
#define Cont3 20
#define Cont4 50


int main()
{
	long Containers[NumCont], devices;


	//Input

	printf("Dwse plithos syskeuwn: ");
	devices=GetLong();

	//Computation

	Containers[3] = devices / Cont4; /*Anti na apothikeuso to devices%Cont4 se metavliti to vazo kateuthian stin epomeni praksi
	kai h idia diadikasia kai gia ta epomena diladi theorise to devices%Cont4 os mia timi apothikeumeni se metavliti kai kane /Cont3
	kai meta to neo  upoloipo einai oti eixa sthn dithen metavliti(devices%Cont4) % Cont3, meta theoro os mia timh se mia  metavliti
	to (devices%Cont4)%cont3 kai kano auto /Cont2 klp...*/
	Containers[2] = (devices%Cont4) / Cont3;
	Containers[1] = ((devices%Cont4)%Cont3) / Cont2;
	Containers[0] =( ((devices%Cont4)%Cont3)%Cont2);

	//Output
	printf("%2d %5ld\n", 1, Containers[0]);
	printf("%2d %5ld\n", 5, Containers[1]);
	printf("%2d %5ld\n", 20, Containers[2]);
	printf("%2d %5ld\n", 50, Containers[3]);

	return 0;
}
