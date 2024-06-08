#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

#define cars 80000
#define rate 0.07
#define limit 160000


int main()
{
    long no_cars,years;
    no_cars=cars;
    years=0;

    while (no_cars<=limit)
    {
        no_cars = ceil(no_cars*(1+rate));
        years++;
    }

    printf("%ld\n",years);
    printf("%ld\n",no_cars);

    return 0;
}
