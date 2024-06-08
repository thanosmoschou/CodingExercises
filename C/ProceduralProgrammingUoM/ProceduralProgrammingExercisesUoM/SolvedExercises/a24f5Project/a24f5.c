#include<stdio.h>
#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#include <math.h>

//Function declaration
void Reading_Polynomial(int row, int Tab[row]);
void Printing_Polynomial(int row, int Tab[row]);
void Adding_Polynomials(int row, int Tab1[row], int Tab2[row],int  coefficientsSum[row]);
int Calculate_Polynomial_Value(int row, int Tab[row], double x);



int main()
{

    int degree;
    int coefficientsA[10], coefficientsB[10], coefficientsSum[10];
    double x, value1, value2, valueSum;

    //Ανάγνωση βαθμού πολυωνύμων
    printf("Ti vathmo exoyn ta polywnyma?\n");
    degree = GetInteger();

    //Ανάγνωση συντελεστών πρώτου πολυωνύμου
   Reading_Polynomial(degree, coefficientsA);

    //Εκτύπωση πρώτου πολυωνύμου
   Printing_Polynomial(degree, coefficientsA);

    //Ανάγνωση συντελεστών δεύτερου πολυωνύμου
   Reading_Polynomial(degree, coefficientsB);

    //Εκτύπωση δεύτερου πολυωνύμου
   Printing_Polynomial(degree, coefficientsB);

    //πρόσθεση πολυωνύμων
   Adding_Polynomials(degree, coefficientsA, coefficientsB, coefficientsSum);

    //Εκτύπωση αθροίσματος
   Printing_Polynomial(degree, coefficientsSum);

    printf("Dwse mia timi gia to x: ");
    x = GetReal();

    //Εκτύπωση τιμών πολυωνύμων
    value1=Calculate_Polynomial_Value(degree, coefficientsA,x);

    value2 = Calculate_Polynomial_Value(degree, coefficientsB,x);

    valueSum = Calculate_Polynomial_Value(degree, coefficientsSum,x);

    printf("Value1: %g  Value2: %g  Value of Sum: %g", value1, value2, valueSum);

    return 0;
}

//Function definition

void Reading_Polynomial(int row, int Tab[row])
{
	 int i;
	 for(i=0; i<=row; i++)
	 {
        printf("Eisagete to syntelesti tou orou %d: ", i);
        Tab[i] = GetInteger();
     }
}


void Printing_Polynomial(int row, int Tab[row])
{
	int i=row;

    while(i>=1)
	{
        printf("%dx^%d + ", Tab[i], i);
        i--;
    }

    printf("%d\n", Tab[0]);
}

void Adding_Polynomials(int row, int Tab1[row], int Tab2[row], int coefficientsSum[row])
{
	 int i=row;

	 for(i=0; i<=row; i++)
	{
        coefficientsSum[i] = Tab1[i] + Tab2[i];
    }
}

int Calculate_Polynomial_Value(int row, int Tab[row], double x)
{
	int value1,i;

	value1 = 0;

    for(i=0; i<=row; i++)
	{
		value1 += Tab[i]*pow(x, (double)i);
	}

	return value1;
}
