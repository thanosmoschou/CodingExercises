#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define DIM 100

//Structure definition
typedef struct
{
    char name[40];
    long upol;
    float epitok;
    int date;
}Clients;

typedef struct
{
    char name[40];
    long upol;
}DifferenceT;

//Function declaration
void Read_Data(FILE *infile, Clients tab[], int *dim);
void Find_Difference(int row1, Clients tabnew[], int row2, Clients tabold[], DifferenceT tab[], int *diff);
void Print_After_2000(FILE *outfile,int row, Clients tab[]);
float Find_tax(int row, Clients tab[]);
Clients Find_Max(int row, Clients tab[]);

int main()
{
    Clients tabold[DIM], tabnew[DIM];
    FILE *infile1, *infile2,*outfile;
    float sum=0;
    int dimold=0,dimnew=0, diff=0,i;
    DifferenceT cl[DIM];
    Clients clientnew, clientold;

    infile1=fopen("bank_new.dat", "r");
    if(infile1==NULL)
    {
        printf("Cannot open file %s.Execution terminated.\n", "bank_new.dat");
        exit(1);
    }

    infile2=fopen("bank_old.dat", "r");
    if(infile2==NULL)
    {
        printf("Cannot open file %s.Execution terminated.\n", "bank_old.dat");
        exit(1);
    }

    outfile=fopen("mztfgm.dat", "w");

    Read_Data(infile1, tabnew, &dimnew);
    Read_Data(infile2,tabold,&dimold);
    Find_Difference(dimnew,tabnew,dimold,tabold,cl, &diff);

    printf("Clients in List New not in Old\n");
    for(i=0; i<diff;i++)
        printf("-%s %ld\n", cl[i].name,cl[i].upol);

    Print_After_2000(outfile, dimnew, tabnew);
    sum=Find_tax(dimnew, tabnew);
    printf("Expected Tax New %.2f\n",sum);

    sum=0;
    sum=Find_tax(dimold, tabold);
    printf("Expected Tax Old %.2f\n",sum);

    clientnew=Find_Max(dimnew,tabnew);
    printf("Max in New: %s %d\n", clientnew.name, clientnew.date);

    clientold=Find_Max(dimold,tabold);
    printf("Max in Old: %s %d\n", clientold.name, clientold.date);


    fclose(infile1);
    fclose(infile2);
    fclose(outfile);
    return 0;
}

//Function definition


void Read_Data(FILE *infile, Clients tab[], int *dim)
{
    int nscan,line=0;
    char termch;

    while(1)
    {
        nscan=fscanf(infile,"%40[^,], %ld, %f,%d%c", tab[*dim].name, &tab[*dim].upol, &tab[*dim].epitok, &tab[*dim].date, &termch);

        if(nscan==EOF)break;
        line++;

        if(nscan!=5 || termch!='\n')
        {
            printf("error in line %d.\n", line);
            exit(1);
        }
        (*dim)++;
    }
}

void Find_Difference(int row1, Clients tabnew[], int row2, Clients tabold[], DifferenceT tab[], int *diff)
{
    int i,j,ctr,k;
    char dname1[40],dname2[40];

    for(i=0; i<row1; i++)
    {
        ctr=0;
        strcpy(dname1, tabnew[i].name);

        for(j=0; j<row2; j++)
        {
             strcpy(dname2, tabold[j].name);

             for(k=0; k<strlen(tabnew[i].name); k++)
             {
                 if(dname1[k]!=dname2[k])
                 {
                     ctr++;
                    // ctr=0;
                     break;
                 }
             }
        }

        if(ctr>=row2)
        {
           strcpy(tab[*diff].name, tabnew[i].name);
           tab[*diff].upol=tabnew[i].upol;
           (*diff)++;
        }
    }

}


void Print_After_2000(FILE *outfile,int row, Clients tab[])
{
    int i;

    for(i=0; i<row; i++)
    {
        if(tab[i].date>=2000)
            fprintf(outfile, "%s, %ld, %f, %d\n", tab[i].name, tab[i].upol, tab[i].epitok, tab[i].date);
    }
}

float Find_tax(int row, Clients tab[])
{
    int sum=0,i;

    for(i=0; i<row; i++)
        sum+=(tab[i].upol);

    return (0.4*sum);

}


Clients Find_Max(int row, Clients tab[])
{
    Clients max=tab[0];
    int i;

    for(i=1; i<row; i++)
    {
        if(tab[i].upol>max.upol)
            max=tab[i];
    }

    return max;
}
