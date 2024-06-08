#include<stdio.h>
#include"genlib.h"
#include<ctype.h>
#include<string.h>


int main()
{
	char *Message;
	int dim,i,j=0;

	printf("Give the dimensions of your string message:");
	scanf("%d", &dim);

	Message= (char *)malloc((dim+1)*sizeof(char));
	printf("Insert your message within %d characters:", dim);
	scanf(" %[^\n]s", Message);
	Message[dim]='\0';

	for(i=0; i<=strlen(Message); i++)
	{
		if (Message[i] !=' ')
		{
			Message[j]=Message[i]; //edo pao mexri to \0 afou to strlen den paei mexri to \0 omos
			j++;                              // px an vrei 4 stoixeia oi theseis pane apo 0 os 3 kai stin 4h uparxei to \0 ara an thelo na min
		}	                                    //  valo sto telos \0 alla na antigrafei vazo mexri iso na paei dil i=strlen dil px i=4....an tora h proti thesi
		                                      //   exei keno kai h deyteri oxi tote thn timh ths deuteris thesis (  thn xeirizomai me to i afou prospelauno ton pinaka na vro kena)
		                                       //     tha tin valo stin proti thesi tou pinaka( pou thn xeirizomai me j afou thelo na valo
												//	ta grammata pros tis kenes theseis pros ta piso) dil ekei pou eixe keno
	}

	printf("Original String: %s with lenght: %d", Message,(int) strlen(Message));
	free(Message);
	return 0;
}
