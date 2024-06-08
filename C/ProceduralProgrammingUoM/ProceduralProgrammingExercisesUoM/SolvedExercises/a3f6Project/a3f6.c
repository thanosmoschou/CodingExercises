/*Να γραφεί πρόγραμμα το οποίο θα διαβάζει τρεις ακέραιους αριθμούς και θα τους καταχωρεί στις μεταβλητές Α, Β, C,
θα τους ταξινομεί κατά αύξουσα σειρά εναλλάσσοντας τις τιμές τους μεταξύ των μεταβλητών με τη βοήθεια της συνάρτησης swap(x,y),
 έτσι ώστε A<B<C. Tέλος θα εμφανίζει τις ταξινομημένες τιμές των μεταβλητών Α, Β και C.
 Η συνάρτηση swap(int *x, int *y) θα εναλλάσσει τις τιμές 2 ακεραίων μεταβλητών x και y
 (η τιμή της x θα δοθεί στην μεταβλητή y και της y στην x).*/


#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

//func decl
void swap(int *x, int *y);


int main()
{
	int A,B,C;

	printf("Insert A:");
	A=GetInteger();

	printf("Insert B:");
	B=GetInteger();

	printf("Insert C:");
	C=GetInteger();

	if(A>B && A>C)
	{
		swap(&A, &C); //Check the message above about how i want to sort the numbers
	}

	 if(B>C)
	{
		swap(&B, &C);
	}

	 if(A>B)
	{
		swap(&A, &B);
	}

	printf("Your numbers shorted are: %d %d %d\n", A,B,C);
	return 0;
}

//Func defin
void swap(int *x, int *y)
{
	int temp;

	temp= *x;
	*x= *y;
	*y = temp;
}
