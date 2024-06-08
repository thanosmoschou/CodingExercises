#include<stdio.h>
#include<genlib.h>
#include<ctype.h>
#include<string.h>



int main()
{
	int L,i;
	char *num;

	printf("Insert a number and the length that you want to show it:\n");
	printf("Insert the length:");
	scanf("%d", &L);

	num=(char *)malloc((L+1)*sizeof(char));
	printf("Insert the number:");
	scanf(" %[^\n]s", num);
	char mat[L];
	strcpy(mat,num);

	num[L]='\0';

	if(strlen(num)<L)
	{
		int j=0;
		for(i=L-strlen(num); i<=L; i++)
		{
			mat[i]=num[j]; //Metafero ton arithmo stis teleutaies theseis oste na valo stin arxi 0
			j++;
		}

		for(i=0; i<L-strlen(num); i++)
		{
			mat[i]='0'; //Vazo 0 stin arxi tou arithmou mou
		}
	}

	printf("Your number is %s", mat);
	free(num);
	return 0;
}
