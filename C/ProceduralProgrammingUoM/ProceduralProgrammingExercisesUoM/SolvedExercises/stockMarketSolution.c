/* Stock Market Analysis
 */

#include <stdio.h>
#include"genlib.h"
#include"simpio.h"

//Function declaration

float CalcMaxVal(int row, float tab[]);
int Interest(int row, float inter[], float pric[],float max) ;
void PrintInteresting(int row, int ni, float interesting[]);
void PrintDash(int dim);
void PrintMax(int row, float max, float prices[]);
float Assess(float cds, int risk);
void high_low(int row, int col, float matrix[row][col], int i, int *high, int *low);
bool element(float value, int row, int *pos, int r, int c, float table[r][c]) ;


int main(){
   float stock_prices[10] = {34.5, 22.4, 77.8, 22.1, 10.0, 11.25, 12, 13, 16, 20.5 };
   float deriv_prices[5] = {30.5, 21.4, 89.8, 20.1, 10.0};
   float cds_prices[11] = {38.5, 33.4, 67.8, 12.1, 16.0, 10.25, 11, 23, 36, 10.1 ,30.4};
   int risk[11] = {90,10,20,30,50,60,30,30,30,10,10}, high, low;
   bool result;
   float value;
   int pos;

   float deriv_day_data[5][10] = {
                {30.5,25,22,32.3,30.5,32.6,38.9,40,22,30.5},
                {22.5,21.4,14,40.3,22.5,12.6,38.9,40,39,21.4},
                {30.5,25,22,89.8,34.5,89.8,38.9,40,30,89.8},
                {20.2,35,20.1,12.3,20.1,32.6,38.9,40,22,20.1},
                {45.5,10.0,22,10.0,14.5,23.6,48.9,8,10.0,10.0}
   };


   float interesting_stock[10];
   int ni_stock;
   float interesting_cds[11];
   int ni_cds;

   int i;
   float max_stock, max_deriv, max_cds;


   /* Calculating Max Values */
   max_stock=CalcMaxVal(10, stock_prices) ;

   max_deriv = CalcMaxVal(5, deriv_prices);

   max_cds = CalcMaxVal(11, cds_prices);


   /* Finding Interesting Values */
   ni_stock=Interest(10, interesting_stock, stock_prices, max_stock);


   ni_cds=Interest(11, interesting_cds, cds_prices,max_cds);



   /* Printing */

   printf("Stock Prices.\n");

   PrintDash(30);


   PrintMax(10, max_stock, stock_prices);

   printf("Interesting Stock Prices:");

   PrintInteresting(10,ni_stock, interesting_stock);


   PrintDash(10);
   /* Derivatives */
   printf("Derivative Prices.\n");

   PrintDash(30);

   PrintMax(5, max_deriv, deriv_prices);

   PrintDash(10);

   /* Cds Prices */

   printf("CDS Prices.\n");

   PrintDash(30);



   PrintMax(11, max_cds, cds_prices);



   printf("Interesting CDS Prices:");
   PrintInteresting(11, ni_cds, interesting_cds);

   PrintDash(30);

   /* ****New Functions**** */

   printf("CDS assessment\n");
   for(i=0; i<11; i++)
   {
      printf("CDS assessment: cds %4.2f Risk %d Value %5.2f\n",cds_prices[i], risk[i], Assess(cds_prices[i], risk[i]) );

   }
   PrintDash(30);

   printf("Derivative Low High\n");
   for(i=0; i<5; i++)
   {

       high_low(5,10,deriv_day_data,i, &high, &low );
       printf("Devirative %d, high %d / low %d values.\n", i, high, low);

   }

   PrintDash(30);

   printf("Give a value with the specific line you want to search in order to search it and return the column index: \n");
   printf("Give the value:");
   value=GetReal();
   printf("Give the line");
   pos=GetInteger();

   result=element(value, 5, &pos, 5, 10, deriv_day_data) ;

   if(result)
		printf("Found it in column %d\n", pos);
   else
		printf("Value does not exist in this line\n");

   return 0;
}


//Func definit
float CalcMaxVal(int row, float tab[])
{
    int i;
    float max_val;
    max_val= tab[0];

    for(i=0; i<row; i++)
        if(tab[i]>max_val) max_val= tab[i];

    return max_val;
}

int Interest(int row, float inter[], float pric[], float max)
{
   int i,ni=0;
   for(i=0; i<row; i++)
       if(pric[i]> max/2)
        {inter[ni++]= pric[i];}

   return ni;
}

void PrintDash(int dim)
{
	int i;
	for(i=0; i<dim; i++) printf("-");
	printf("\n");
}

void PrintMax(int row, float max, float prices[])
{
	int i;
	printf("Max Price:: %4.2f \n",max);
	for(i=0; i<row; i++)
				printf("%s(%3.2f) ",(max == prices[i] ? "-Max-" : ""),prices[i]);
	printf("\n");
}


void PrintInteresting(int row, int ni, float interesting[])
{
	int i;

	for(i=0; i<ni; i++)  printf("[%4.2f] ",interesting[i]);
	printf("\n");
}

float Assess(float cds, int risk)
{
    if(cds<20 && risk<50) return 20;
    if(cds>=20 && risk<80) return (10 + (cds * risk)/100);
    return (100 + (cds*risk)/100);

}

void high_low(int row, int col, float matrix[row][col], int i, int *high, int *low)
{
    int j;
    float last;
    (*high)=(*low)=0;
    last= matrix[i][col-1];


    for(j=0; j<col; j++)
    {
        if (matrix[i][j] > last) (*high)++;
        if(matrix[i][j]< last) (*low)++;
    }
}

bool element(float value, int row, int *pos, int r, int c, float table[r][c])
{
	int i, j;

	printf("\n");
	printf("Closing\n");
	for(i=0; i<r; i++)
	{
		printf("Devirative %d, closing value at :: ",i);
		for(j=0; j<c; j++)
		{
			if(table[i][c-1]==table[i][j]) printf("%d ", j);
		}
		printf("\n");
	}

	for(j=0; j<c; j++)
	{
		if (table[*pos][j]==value)
		{
			*pos=j;
			return TRUE;
		}
	}

	return FALSE;
}
