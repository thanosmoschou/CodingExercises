#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
#define N 25
#define DIM 200

//Structure definition
typedef struct
{
	int code;
	char name[N];
	float total;
	float promitheia;

}Employees;

//Function declaration
void Read_Data(FILE *infile, Employees tab[], int *empl);
void Write_Data(FILE *outfile, int row, Employees tab[]);


int main()
{
	FILE *infile, *outfile;
	int emplo;

	infile=fopen("i4f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s...Execution terminated.\n", "i4f9.dat");
		exit(1);
	}

	Employees em[DIM];

	outfile=fopen("o4f9.dat", "w");

	Read_Data(infile, em, &emplo);
	Write_Data(outfile, emplo, em);

	fclose(infile);
	fclose(outfile);

	system("PAUSE");
	return 0;
}


//Function definition
void Read_Data(FILE *infile, Employees tab[], int *empl)
{
	int nscan,line=0;
	char content[DIM],termch;
	*empl=0;

	while(1)
	{
		nscan=fscanf(infile,"%d,%25[^,],%f%c", &tab[*empl].code, tab[*empl].name, &tab[*empl].total, &termch);
		if((nscan==EOF)) break;
		line++;

		if(nscan!=4 || termch!='\n')
		{
			printf("Error in line %d...Execution terminated.\n", termch);
			exit(1);
		}

		if(tab[*empl].code==11)
			tab[*empl].promitheia=(tab[*empl].total*0.03);
		else if(tab[*empl].code==12)
			tab[*empl].promitheia=(tab[*empl].total*0.05);
		else if(tab[*empl].code==13)
			tab[*empl].promitheia=(tab[*empl].total*0.08);
		else if(tab[*empl].code==14)
			tab[*empl].promitheia=(tab[*empl].total*0.11);

		(*empl)++;
	}
}


void Write_Data(FILE *outfile, int row, Employees tab[])
{
	int i;

	fprintf(outfile, "%-25s%-10s\n", "ONOMATEPWNYMO", "PROMITHEIA");

	for(i=0; i<35; i++)
		fputc('-', outfile);
	fputc('\n',outfile);

	for(i=0; i<row; i++)
		fprintf(outfile, "%-25s%10.2f\n", tab[i].name, tab[i].promitheia);

}
