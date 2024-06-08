#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    int rate;
    long purchaseAmount;
    double saleAmount,profit;

    printf("Dose kathari axia: ");
    purchaseAmount=GetLong();
    printf("Dose pososto kerdous: ");
    rate=GetInteger();

    profit = purchaseAmount*(((double)rate)/100);
    saleAmount = purchaseAmount + profit;

    printf("Kerdos:%g\n", profit);
    printf("Synoliko poso:%g\n", saleAmount);

    return 0;
}
