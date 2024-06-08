#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define DIM 26
#define LET 26
#define ASCIIA 65
#define ASCIIZ 90

//Function declaration
int freq(char let, int dim, char word[]);

int main()
{
	char *word;
	int findlet[LET],i;

	printf("Dose ena alfarithmitiko to poly 25 charaktiron: ");
	word=(char *)malloc(DIM*sizeof(char));
	scanf(" %[^\n]s", word);
	word[strlen(word)]='\0';

	for(i=ASCIIA; i<=ASCIIZ; i++)
	{
		findlet[i-ASCIIA]=freq(i,strlen(word),word);
	}

	for(i=0; i<LET; i++)
		if(findlet[i]>0) printf("%c --> %d\n", i+ASCIIA, findlet[i]);

	free(word);

	system("PAUSE");
}

//Function definition
int freq(char let, int dim, char word[])
{
	int i, ctr=0;

	for(i=0; i<dim; i++)
		if(word[i]==let) ctr++;
	return ctr;
}
