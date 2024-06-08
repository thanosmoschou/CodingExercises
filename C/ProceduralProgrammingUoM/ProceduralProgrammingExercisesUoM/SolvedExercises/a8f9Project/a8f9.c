#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>
#define DIM 50

//Function declaration
void Read_Write_Data(FILE *infile, FILE *outfile);

int main()
{
	FILE *infile, *outfile;


	infile=fopen("i8f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s. Execution terminated.\n", "i8f9.dat");
		exit(1);
	}

	outfile=fopen("o8f9.dat", "w");

	Read_Write_Data(infile,outfile);

	fclose(infile);
	fclose(outfile);

	system("pause");
	return 0;
}

//Function definition
void Read_Write_Data(FILE *infile, FILE *outfile)
{
	int nscan,line=0,code;
	double money;
	char termch;

	while(1)
	{
		nscan=fscanf(infile, "%d %lf%c", &code, &money, &termch);

		if(nscan==EOF)break;
		line++;

		if(nscan!=3 || termch!='\n')
		{
			printf("Error in line %d.\n", line);
			exit(1);
		}

		money*=1.2;

		fprintf(outfile, "%7d %13.11f\n", code,money);
	}

}
