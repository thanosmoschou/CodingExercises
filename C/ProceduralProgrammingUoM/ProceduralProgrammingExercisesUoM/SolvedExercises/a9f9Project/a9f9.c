#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define DIM 100

//Structure definition
typedef struct
{
	char name[15];
	char surname[25];
	double grades[6];
	char gender;
	double AVG;
}Students;

//Function declaration
void Read_Data(FILE *infile, Students tab[], int *st, int *agor, int *kor, double *sumag, double *sumkor);
double Calc_Avg(int row,double gr[]);
Students FillStruct(char name[],char sur[],double gr[],char gend, double sum);
void Write_Data(FILE *outfile,int stud,Students st[],int ag,int kor,double sumarr,double sumkor);


int main()
{
	FILE *infile, *outfile;
	Students st[DIM];
	int stud=0,ag=0,kor=0;
	double sumarr=0,sumkor=0;
	//char name1[DIM],name2[DIM];

	/*printf("Enter the name of the input file for the school\n");
		gets(name1); Gets its dangerous...Use fgets instead and declare the bufsize yourself
		infile=fopen(name1, "r"); Use the same commands for the result file too! Just change the parameters
	*/

	infile=fopen("lyceum_1.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s. Execution terminated.\n", "lyceum_1.dat");
		exit(1);
	}

	outfile=fopen("results_1.dat", "w");

	Read_Data(infile, st, &stud,&ag, &kor, &sumarr, &sumkor);
	Write_Data(outfile, stud,st,ag,kor,sumarr,sumkor);


	fclose(infile);
	fclose(outfile); //When you create a stream remember before you use it to write the closing command because you may forget to do it if you do it at the end

	system("pause");
	return 0;
}


//Function definition
void Read_Data(FILE *infile, Students tab[], int *st, int *agor, int *kor, double *sumag, double *sumkor)
{
	int nscan,line=0,sag=0,skor=0;
	double sum, gr[6];
	char name[15], sur[15], gend,termch;


	while(1)
	{
		sum=0;
		nscan=fscanf(infile, "%15[^,], %25[^,], %lf,%lf,%lf,%lf,%lf,%lf,%c%c",
					name,sur,&gr[0], &gr[1],&gr[2], &gr[3],&gr[4], &gr[5],&gend, &termch);

		if(nscan==EOF)break;
		line++;

		if(nscan!=10 || termch!='\n')
		{
			printf("Error in line %d.\n", line);
			exit(1);
		}

		if(gend=='A')(sag)++; //Auksano to sunolo tou filou px agoria h koritsia
		else (skor)++;

		sum=(Calc_Avg(6, gr)/6);
		if(sum>=10)
		{
			tab[*st]=FillStruct(name,sur,gr,gend,sum);
			if(tab[*st].gender=='A')
			{
				//(*sumag)+=sum;
				(*agor)++; //Auksano ton arithmo ton agorion me MO>=10...To idio kai gia ta koritsia
			}
			else
			{
				//(*sumkor)+=sum;
				(*kor)++;
			}
			(*st)++;
		}
	}

	(*sumag)=((double)(*agor)/(sag)*100); //Pososto epitixontwn epitix/sunol_filou(px agoria h koritsia)
	(*sumkor)=((double)(*kor)/(skor)*100);
}

double Calc_Avg(int row,double gr[])
{
	double sum;
	int i;

	for(i=0; i<row; i++)
		sum+=gr[i];

	return sum;
}

Students FillStruct(char name[],char sur[],double gr[],char gend, double sum)
{
	Students student;
	int i;

	strcpy(student.name, name);
	strcpy(student.surname, sur);
	student.gender=gend;
	for(i=0;i<6;i++)
		student.grades[i]=gr[i];
	student.AVG=sum;

	return student;
}

void Write_Data(FILE *outfile,int stud,Students st[],int ag,int kor,double sumarr,double sumkor)
{
	int i;

	fprintf(outfile, "%-14s %-12s %-15s %-12s\n", "EPITYXOUSES", "POSOSTO", "EPITYXONTES", "POSOSTO");
	fprintf(outfile, "%-14d %-12.1lf %-15d %-12.1lf\n", kor,sumkor, ag,sumarr);

	for(i=0; i<70; i++)
		fputc('-',outfile);
	fputc('\n',outfile);

	for(i=0; i<stud; i++)
	{
		fprintf(outfile, "%-10s %-15s %.1lf  %.1lf  %.1lf  %.1lf  %.1lf  %.1lf  %.1lf %c\n",
					st[i].name,st[i].surname,st[i].grades[0], st[i].grades[1],st[i].grades[2], st[i].grades[3],st[i].grades[4], st[i].grades[5],st[i].AVG, st[i].gender);
	}
}
