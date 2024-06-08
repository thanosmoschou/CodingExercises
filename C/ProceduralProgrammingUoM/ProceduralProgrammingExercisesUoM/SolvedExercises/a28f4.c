#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"


//Function declaration

int get_code();
double discount_percentage(int code);
int product_points(int code, double price);

int main()
{
    int code, points;
    double price , total , discountSum , finalPrice , discount;

    total = discountSum = 0;
    points = 0;

    while( ( code=get_code() ) ) //o xristis dinei kwdiko kai h ekfrasi apotimatai me ton kwdiko..kai sozetai stin code..an dwsei 0 stop
    {
        //Input

        printf("Dwse thn timh: ");
        price=GetReal();

         //Computation
        discount = discount_percentage(code)*price;
        discountSum += discount;
        finalPrice = price - discount;
        total += finalPrice;
        points += product_points(code,finalPrice);

    }

    //Output
    printf("------------------\n");
    printf("Teliko synolo: %.2f Euro\n", total);
    printf("Ekptwsh: %.2f Euro\n", discountSum);
    printf("Pontoi: %d", points);


    return 0;
}


//Functions
int get_code()
{
    //Local variable declaration
    int code;


    //Input ton kwdiko kai validation control
    while(TRUE)
    {
        printf("Dwse ton kwdiko: ");
        code=GetInteger();

        if (code>=0 && code <=2000)
        {
            return code;
        }

        printf("Lathos Kwdikos (0-2000)\n");

    }

}

double discount_percentage(int code)
{
    if (code<=300)
    {
        return 0.05;
    }
    else if(code <=500)
    {
        return 0.1;
    }
    else if (code<=1000)
    {
        return 0.15;
    }
    else
    {
        return 0.2;
    }

}



int product_points(int code, double price)
{

    int points;

    points=1;

    if(code>=1000 && code<=1500)
    {
        points +=  ceil(price/5);
    }

    return points;

}
