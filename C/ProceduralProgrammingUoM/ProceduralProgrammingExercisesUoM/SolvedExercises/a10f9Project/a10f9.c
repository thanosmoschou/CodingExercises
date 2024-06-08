#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<string.h>
#include<ctype.h>
#include<stdlib.h>
#define DIM 200

//Function declaration
void read_and_write_data(FILE *infile, FILE *outfile);

int main()
{
	FILE *infile, *outfile;


	infile=fopen("i10f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s. Execution terminated.\n", "i10f9.dat");
		exit(1);
	}

	outfile=fopen("o10f9.dat", "w");

	read_and_write_data(infile,outfile);

	fclose(infile);
	fclose(outfile);

	/*system("PAUSE");*/
	return 0;
}

//Function definition
void read_and_write_data(FILE *infile, FILE *outfile)
{
	char comments[DIM],ch;
	int ctr;

	while(fgets(comments,DIM, infile)!=NULL)
	{
		ctr=0;

		while((ch=comments[ctr])!='\0')
		{
			if(ch!=',' && ch!='.')
			{
				fputc(ch,outfile);
			}
			else
			{
				fputc(ch,outfile);
				if(comments[ctr+1]!=' ')
				{
					fputc(' ',outfile);
				}
			}

			ctr++;
		}
	}
}
