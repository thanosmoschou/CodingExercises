#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#define ON 28
#define DIM 100

//Structure declaration
typedef struct
{
	long afm;
	char name[ON];
	float apodox;
	float foros;
}Employees;

void readDataFromFile(FILE *infile, Employees emp[], int *employee);
void writeToFile(FILE *outfile, int row, Employees emp[]);

int main()
{
	FILE *infile, *outfile;
	int empl;

	infile=fopen("i12f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s. Execution terminated.\n", "i12f9.dat");
		exit(1);
	}

	Employees emp[DIM];

	outfile=fopen("Foro12f9.dat", "w");

	readDataFromFile(infile, emp, &empl);
	writeToFile(outfile,empl, emp );

	fclose(infile);
	fclose(outfile);

	return 0;
}


//Function definition
void readDataFromFile(FILE *infile, Employees emp[], int *employee)
{
	int nscan,line=0;
	char termch;

	*employee=0;
	while(TRUE)
	{
		nscan=fscanf(infile, "%ld,%28[^,],%f%c", &emp[*employee].afm, emp[*employee].name, &emp[*employee].apodox, &termch);
		if(nscan==EOF)break;
		line++;

		if(nscan!=4 || termch!='\n')
		{
			printf("Error in line %d\n", line);
			exit(1);
		}

		if(emp[*employee].apodox<=10000) (emp[*employee].foros=emp[*employee].apodox*0.14);
		else if(emp[*employee].apodox<=23000) (emp[*employee].foros=emp[*employee].apodox*0.19);
		else if(emp[*employee].apodox<=55000) (emp[*employee].foros=emp[*employee].apodox*0.23);
		else  (emp[*employee].foros=emp[*employee].apodox*0.28);

		(*employee)++;
	}
}

void writeToFile(FILE *outfile, int row, Employees emp[])
{
	int i;
	float sum=0;

	fprintf(outfile, "%-10s%-30s%-7s\n", "AFM", "ONOMATEPWNYMO", "FOROS");

	for(i=0; i<47; i++)
		fputc('-',outfile);
	fputc('\n',outfile);

	for(i=0; i<row; i++)
	{
		sum+=emp[i].foros;
		fprintf(outfile, "%-10ld%-28s%8.2f\n", emp[i].afm, emp[i].name, emp[i].foros);
	}

	for(i=0; i<47; i++)
		fputc('-',outfile);
	fputc('\n',outfile);

	fprintf(outfile, "%-38s%-8.2f\n", "SYNOLO FOROY",sum);

}
