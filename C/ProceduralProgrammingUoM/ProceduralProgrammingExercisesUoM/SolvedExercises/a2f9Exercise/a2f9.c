#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<string.h>
#include<ctype.h>
#define M 100

typedef struct
{
    char name[30];
    int apousies;

}studentT;

//Function declaration
void readInput(FILE *infile, studentT students[], int *pApousies, int *pStudents);
void writeOutput(FILE *outfile , int size, studentT students[], int total);

int main()
{
    FILE *infile, *outfile;
    int pApousies, pStudents;

    infile=fopen("i2f9.dat", "r");

    if(infile==NULL)
    {
        printf("Cannot open input file i2f9.dat");
        exit(1);
    }

    outfile=fopen("o2f9.dat", "w");
    studentT students[M];

    readInput(infile, students, &pApousies, &pStudents);
    writeOutput(outfile, pApousies, students, pStudents);

    fclose(infile);
    fclose(outfile);
    return 0;
}

//Function definition
 void readInput(FILE *infile, studentT students[], int *pApousies, int *pStudents)
 {
     int nscan, apousies,line;
     char name[30], comments[68], termch;

     *pApousies=0;
     *pStudents=0;
     line=0;
     while(TRUE)
     {
         nscan= fscanf(infile, "%30[^,], %d, %68[^\n]%c", name, &apousies, comments, &termch);
         if(nscan==EOF) break;
         line++;
         if(nscan!=4 || termch!='\n')
         {
             printf("Error in line %d. Program termination\n", line);
             exit(1);
         }

         if(apousies>100)
         {
             strcpy(students[*pApousies].name, name);
             students[*pApousies].apousies=apousies;
             (*pApousies)++;
         }
         (*pStudents)++;
     }
 }

 void writeOutput(FILE *outfile , int size, studentT students[], int total)
 {
     int i;

     fprintf(outfile, "%-30s%-9s\n", "ONOMATEPWNYMO", "APOYSIES");

     for(i=1; i<=39; i++)
         fputc('-', outfile);
     fputc('\n', outfile);

     for(i=0; i<size; i++)
         fprintf(outfile, "%-30s%9d\n", students[i].name, students[i].apousies);

     for(i=1; i<=39; i++)
         fputc('-', outfile);
     fputc('\n', outfile);

     fprintf(outfile, "%-30s%9d\n", "SYNOLO MATHITWN:", total);
     fprintf(outfile, "%-30s%9d\n", "SYNOLO APONTWN:", size);

 }
