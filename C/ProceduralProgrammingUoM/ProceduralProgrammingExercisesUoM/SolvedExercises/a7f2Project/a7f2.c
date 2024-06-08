#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
   int working_hours;
   long code;
   double salary,rate, weekly_salary;

   printf ("Dwse ton kwdiko:");
   code=GetLong();

   if (code>=1000)
   {
       printf ("Dwse ton ethsio mistho:");
       salary=GetReal ();
       weekly_salary=salary/52;

   }
   else
   {
       printf ("Dwse tis wres ebdomadiaias ergasias:");
       working_hours=GetInteger();
       printf ("Dwse thn amoibh ana wra:");
       rate=GetReal ();

       if (working_hours<40)
       {
           weekly_salary= rate*working_hours;

       }
       else
       {
           weekly_salary= rate*40+(working_hours-40)*1.5*rate;

       }
   }



   printf ("H ebdomadiaia amoibh einai:%g", weekly_salary);

   return 0;


}

