/*This program reads a file and shows the amount of lines, words and letters of it*/

#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define MAX 150

//Function declaration
void Read(FILE *infile, int *lines, int *words, int *letters);
void Print(int lines, int words, int letters);

int main()
{
	FILE *infile;
	int lines,words,letters;

	lines=words=letters=0;

	infile=fopen("i5f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s. Execution terminated.\n", "i5f9.dat");
		exit(1);
	}

	Read(infile,&lines, &words, &letters);
	Print(lines,words,letters);

	fclose(infile);
	system("pause");
	return 0;
}

//Function definition
void Read(FILE *infile, int *lines, int *words, int *letters)
{
	char things[MAX];
	int ctr;

	while(fgets(things,MAX,infile)!=NULL)
	{
		ctr=0; //Initialize the counter for the new line of text
		while(things[ctr]!='\0')
		{
			if(things[ctr]=='\n')(*lines)++;	/*Now a line has ended so i have to increase the counter for lines*/
			else if(things[ctr]!=' ' )
			{
				if((things[ctr]!=',' && things[ctr]!='.' && things[ctr]!='\n' && things[ctr]!='\''))(*letters)++; //I can see a word so i increase the amount of letters that i have
				//if(things[ctr]=='\n')(*lines)++;	/*Now a line has ended so i have to increase the counter for lines*/
			}
			else
			{ /*I have a space so i have to check the next characters..
			   If i still have i space i continue but if i have a letter then a new words begins
			   so i increase the counter or my words BUT for my previous word and i can now see what is going on with the new one*/
				if(things[ctr+1]!=' ')
					(*words)++;
				//if(things[ctr]=='\n')(*lines)++;	/*Now a line has ended so i have to increase the counter for lines*/
			}

			ctr++; //Increase the index of my table to get a new character
		}

	}
}

void Print(int lines, int words, int letters)
{

	printf("Total amount of lines: %d\n", lines);
	printf("Total amount of words: %d\n", words);
	printf("Total amount of letters: %d\n", letters);

}
