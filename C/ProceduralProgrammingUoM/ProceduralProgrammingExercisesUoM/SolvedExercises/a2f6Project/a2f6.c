#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#define DIMENS 100

//Func declar
void FillFunc(int rows, int table[rows], int *count);
void FindBorders(int rows, int table[], int *max, int *min);



int main()
{
	int tab1[DIMENS], ctr, maxel,minel;

	FillFunc(DIMENS, tab1, &ctr);
	FindBorders(ctr, tab1, &maxel, &minel);

	printf("The range of values is %d-%d\n", minel, maxel);

	return 0;
}

//Func definition
void FillFunc(int rows, int table[rows], int *count)
{
	int num;

	*count=0;

	printf("Enter the elements of the array, one per line. \n");
	printf("Use -1 to signal the end of the list. \n");

	while(TRUE)
	{
		printf("? ");
		num=GetInteger();

		if(num== -1)
		{
			break;
		}
		else
		{
			table[*count]= num; //I take the value from the reference of my variable and this is my index to my table, then i increase the index by 1
			(*count)++;
		}

	}

}

void FindBorders(int rows, int table[], int *max, int *min)
{
	int i;

	*max=*min=table[0]; //I use pointers to set the max and min value with the 1st element off my table..

	for(i=0; i<rows; i++)
	{
		if(table[i]> *max)
		{
			*max= table[i];
		}

		if(table[i]< *min)
		{
			*min= table[i]; //With pointers i store immediately the min value every time straight to the reference of my
			//real variable and i don't have to create a local variable and store the result and then return it. Pointers help a lot
			//especially when i have to return more than 1 values something i can't do with functions cause they return only 1 value
		}
	}


}
