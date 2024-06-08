#include <stdio.h>
#include "genlib.h"
#include "simpio.h"
#include <math.h>

int main() {

    int degree;
    int coefficientsA[10], coefficientsB[10], coefficientsSum[10];
    int i;
    double x, value1, value2, valueSum;

    //Ανάγνωση βαθμού πολυωνύμων
    printf("Ti vathmo exoyn ta polywnyma?\n");
    degree = GetInteger();

    //Ανάγνωση συντελεστών πρώτου πολυωνύμου
    for(i=0; i<=degree; i++) {
        printf("Eisagete to syntelesti tou orou %d: ", i);
        coefficientsA[i] = GetInteger();
    }

    //Εκτύπωση πρώτου πολυωνύμου
    i=degree;
    while(i>=1) {
        printf("%dx^%d + ", coefficientsA[i], i);
        i--;
    }
    printf("%d\n", coefficientsA[0]);

    //Ανάγνωση συντελεστών δεύτερου πολυωνύμου
    for(i=0; i<=degree; i++) {
        printf("Eisagete to syntelesti tou orou %d: ", i);
        coefficientsB[i] = GetInteger();
    }

    //Εκτύπωση δεύτερου πολυωνύμου
    i=degree;
    while(i>=1) {
        printf("%dx^%d + ", coefficientsB[i], i);
        i--;
    }
    printf("%d\n", coefficientsB[0]);

    //πρόσθεση πολυωνύμων
    for(i=0; i<=degree; i++) {
        coefficientsSum[i] = coefficientsA[i] + coefficientsB[i];
    }

    //Εκτύπωση αθροίσματος
    i=degree;
    while(i>=1) {
        printf("%dx^%d + ", coefficientsSum[i], i);
        i--;
    }
    printf("%d\n", coefficientsSum[0]);

    printf("Dwse mia timi gia to x: ");
    x = GetReal();

    //Εκτύπωση τιμών πολυωνύμων
    value1 = 0;
    for(i=0; i<=degree; i++)
        value1 += coefficientsA[i]*pow(x, (double)i);

    value2 = 0;
    for(i=0; i<=degree; i++)
        value2 += coefficientsB[i]*pow(x, (double)i);

    valueSum = 0;
    for(i=0; i<=degree; i++)
        valueSum += coefficientsSum[i]*pow(x, (double)i);
    printf("Value1: %g  Value2: %g  Value of Sum: %g", value1, value2, valueSum);

    return 0;
}
