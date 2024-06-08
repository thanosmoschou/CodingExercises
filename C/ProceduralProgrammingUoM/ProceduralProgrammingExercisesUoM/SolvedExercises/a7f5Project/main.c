#include <stdio.h>
#include <stdlib.h>
#include "simpio.h"
#include "genlib.h"
#define dimens 50

//Function declaration
void Filling_matrix(int row, int col, long matrix[row][col], int num_of_matr);
bool Find_add(int row1,int col1, int row2, int col2, long matrix1[row1][col1], long matrix2[row2][col2], long add[col1][row1]);
bool Find_sub(int row1,int col1, int row2, int col2, long matrix1[row1][col1], long matrix2[row2][col2], long sub[row1][col1]);
bool Find_mul(int row1,int col1, int row2, int col2, long matrix1[row1][col1], long matrix2[row2][col2], long mul[row1][col2]);
void Print_results(int row, int col, long matrix[row][col]);




int main()
{
    int m1,n1,m2,n2;
    long matrix1[dimens][dimens],matrix2[dimens][dimens],add[dimens][dimens]={0},sub[dimens][dimens]={0},mul[dimens][dimens]={0};
    bool ad1,sub1,mul1;

    //Input

    printf("Dwse to plhthos twn grammwn m1:");
    m1=GetInteger();

    printf("Dwse to plhthos twn sthlwn n1:");
    n1=GetInteger();

    printf("Dwse to plhthos twn grammwn m2:");
    m2=GetInteger();

    printf("Dwse to plhthos twn sthlwn n2:");
    n2=GetInteger();

    Filling_matrix(m1,n1, matrix1, 1);
    Filling_matrix(m2,n2,matrix2,2);

   //Computation

   //Bool function, an tirountai oi proipothesis kanei praksi kai epistrefei true allios vgazei message kai returns false, evala bool
   //giati thelo stin print function an einai true na ektiponei

   ad1= Find_add(m1,n1,m2,n2,matrix1,matrix2,add);
   sub1=Find_sub(m1,n1,m2,n2,matrix1,matrix2,sub);
   mul1=Find_mul(m1,n1,m2,n2,matrix1,matrix2,mul);


   //Output

   if(ad1)
   {
		 Print_results(m1,n1,add);
   }

  printf("\n");

  if(sub1)
  {
		Print_results(m1,n1,sub);
  }

  printf("\n");

  if(mul1)
 {
	Print_results(m1,n2, mul);
 }

    return 0;
}


//Function definition

void Filling_matrix(int row, int col, long matrix[row][col], int num_of_matr)
{
	int i,j;

	 for(i=0; i<row; i++)
	{
		for(j=0; j<col; j++)
		{
			printf("Dwse to [%d,%d] stoixeio tou matrix%d:",i,j,num_of_matr);
			matrix[i][j]=GetLong();
		}
	}
}

bool Find_add(int row1,int col1, int row2, int col2, long matrix1[row1][col1], long matrix2[row2][col2], long add[row1][col1])
{
	//long add[dimens][dimens];

	if(row1==row2 && col1==col2)
	{
		for(int i=0; i<row1; i++)
		{
			for(int j=0; j<col1; j++)
			{
				add[i][j]=matrix1[i][j]+matrix2[i][j];
			}
		}

		return TRUE;
	}
	else
	{
		printf("ERROR +\n");
	}

	return FALSE;
}

bool Find_sub(int row1,int col1, int row2, int col2, long matrix1[row1][col1], long matrix2[row2][col2], long sub[row1][col1])
{
	//long sub[dimens][dimens];

	if(row1==row2 && col1==col2)
	{
		for(int i=0; i<row1; i++)
		{
			for(int j=0; j<col1; j++)
			{
				sub[i][j]=matrix1[i][j]-matrix2[i][j];
			}
		}
		return TRUE;
	}
	else
	{
		printf("ERROR -\n");
	}

	return FALSE;
}

bool Find_mul(int row1,int col1, int row2, int col2, long matrix1[row1][col1], long matrix2[row2][col2], long mul[row1][col2])
{
	int i,j;
	long sum;
	//long mul[dimens][dimens];

	if(col1==row2) //stiles 1ou ises me grammes 2ou kai o neos pinakas pairnei tis grammes tou 1ou kai tis stiles tou 2ou
	{
		int ctr=0;

		for(int k=0;k<row1; k++)
		{

			for(int l=0; l<col2; l++)
			{

				sum=0;
				for(i=0; i<row2; i++)
				{
						sum+= matrix1[k][i]*matrix2[i][k]; //pollaplasiasmos pinakwn, kathe stoixeio einai to eswter ginom i-ostis gramm kai j-ostis stilis
				}

				mul[k][l]=sum;
				ctr+=1;
			}

		}


		return TRUE;
	 }

	else
	{
		printf("ERROR *\n");
	}

	return FALSE;

}


void Print_results(int row, int col, long matrix[row][col])
{

		for(int i=0; i<row; i++)
		{
		for(int j=0; j<col; j++)
		{
			printf("%5ld  ", matrix[i][j]);
		}
		printf("\n");
		}
}




