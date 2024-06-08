#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define DIM 400

int main()
{
	FILE *infile, *outfile;
	char words[DIM];


	infile=fopen("i1f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open this file...Execution terminated.\n");
		exit(1);
	}

	outfile=fopen("o1f9.dat", "w");

	int ctr,i ;
	while(fgets(words,DIM, infile)!=NULL)
	{
		ctr=0;
		i=0;
		while(words[ctr]!='\0')
		{
			if(words[ctr]!=' ')
			{
				fputc(words[ctr], outfile);
				i=0; //Initialize again the counter because i haven't a space
			}
			else
			{
				if(i==0) //I have a space now but previous i haven't
				{
					fputc(words[ctr],outfile);
					i++; //Increase the counter for spaces because i added one to my file
				}
			}
			ctr++;
		}

	}

	fclose(infile);
	fclose(outfile);

	system("PAUSE");
	return 0;
}
