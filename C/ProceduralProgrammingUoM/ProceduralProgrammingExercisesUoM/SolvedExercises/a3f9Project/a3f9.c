#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define M 100


typedef struct
{
	char name[30];
	long promith;
}employee;

void read_data(FILE *infile, employee Empl[M], int *dim, long *sum);
void write_data(FILE *outfile, int row, employee Empl[],long sum);

int main()
{
	FILE *infile, *outfile;


	infile=fopen("i3f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s...Execution terminated.\n", "i3f9.dat");
		exit(1);
	}

	employee Empl[M];
	int dim=0;
	long sum=0;


	outfile=fopen("o3f9.dat", "w");

	read_data(infile, Empl, &dim, &sum);
	write_data(outfile,dim, Empl,sum);

	fclose(infile);
	fclose(outfile);

	system("PAUSE");
	return 0;
}


void read_data(FILE *infile, employee Empl[M], int *dim, long *sum)
{
	int nscan,line=0;
	long  prom;
	char name[30], comments[68], termch;

	while(1)
	{
		nscan=fscanf(infile, "%30[^,], %ld, %68[^\n]%c", name, &prom, comments, &termch);
		if(nscan==EOF) break;
		line++;

		if(nscan!=4 || termch!='\n')
		{
			printf("Error in line %d...Execution terminated.\n", line);
			exit(1);
		}

		if(prom>300000)
		{
			Empl[*dim].promith=(0.05*prom);
			(*sum)+=Empl[*dim].promith;
		}
		else
		{
			Empl[*dim].promith=(0.03*prom);
			(*sum)+=Empl[*dim].promith;
		}

		strcpy(Empl[*dim].name, name);
		(*dim)++; //Increase the amount of employees

	}

}

void write_data(FILE *outfile, int row, employee Empl[],long sum)
{
	fprintf(outfile, "%-30s%-9s\n", "ONOMATEPWNYMO", "PROMHTHEIA");

	for(int i=0; i<40; i++)
		fputc('-', outfile);
	fputc('\n',outfile);

	for(int i=0; i<row; i++)
		fprintf(outfile, "%-30s%9ld\n", Empl[i].name, Empl[i].promith);

	for(int i=0; i<40; i++)
		fputc('-', outfile);
	fputc('\n',outfile);

	fprintf(outfile, "%-30s%9ld\n", "SYNOLO PROMITHEIWN:", sum);

}
