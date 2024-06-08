#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

//Function declaration
int cube(int n);
int Sum_Cube(int n);
bool IsArmstrong(int n);

int main()
{
    int i;

    //Input
    // printf("Dwse arithmo:");
    //num=GetInteger();

   for(i=1;i<=999;i++)
   {
        if(IsArmstrong(i))
        {
            printf("%d\n",i);
        }
   }

    return 0;
}


bool IsArmstrong(int x)
{

    if(x == Sum_Cube(x))
    {
        return TRUE;
    }
    /*else
    {
        return FALSE;
    }*/
    return FALSE;
}



int Sum_Cube(int n)
{
    int d1,d2,d3;

    d1=n%10;
    d2= (n/10)%10;
    d3=n/100;

   return cube(d1)+cube(d2)+cube(d3);
}

int cube(int n)
{
    int i,prod;
    prod=1;

    for(i=0;i<3;i++)
    {
        prod=prod*n;
    }
    return prod;
}

