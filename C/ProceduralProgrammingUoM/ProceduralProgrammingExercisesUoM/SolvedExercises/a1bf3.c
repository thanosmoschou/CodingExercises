#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
    long Arithmo_Aytok,Orio,years;
    double Rythmos;

    years=0;

    printf("Dwse ton arxiko arithmo autokinhtwn:");
    Arithmo_Aytok=GetLong();

    printf("Dwse ton ethsio rythmo ayxhshs:");
    Rythmos=GetReal();

    printf("Dwse to orio:");
    Orio=GetLong();

    while (Arithmo_Aytok<=Orio)
    {
        Arithmo_Aytok = ceil(Arithmo_Aytok*(1+Rythmos));
        years++;
    }

    printf("%ld\n",years);
    printf("%ld\n",Arithmo_Aytok);

    return 0;
}

