#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define DIM 100

//Function declaration
void Read_Write(FILE *infile, FILE *outfile);


int main()
{
	FILE *infile, *outfile;


	infile=fopen("i7f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s. Execution terminated.\n", "i7f9.dat");
		exit(1);
	}

	outfile=fopen("o7f9.dat", "w");

	Read_Write(infile,outfile);

	fclose(infile);
	fclose(outfile);

	system("pause");
	return 0;
}


//Function definition
void Read_Write(FILE *infile, FILE *outfile)
{
	char things[DIM];
	int ctr=0;

	fgets(things,DIM, infile);
	while(things[ctr]!='\0')
	{
		if(things[ctr]>='0' && things[ctr]<='9')
		{
			fputc(things[ctr],outfile); //If it is a number insert it to my file
			if(things[ctr+1]==' ' || things[ctr+1]<'0' || things[ctr+1]>'9')//if the next one is different than number then my number is over so put \n first and then take the next char
			{
				fputc('\n',outfile);
			}
		}

		ctr++;
	}
}
