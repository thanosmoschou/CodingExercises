#include<stdio.h>
#include<ctype.h>
#include<string.h>
#define DIM 25
#define COUNT 7

//Func declar
void RegularPluralForm(int row, char word[]);


int main()
{
	int i;
	char word[DIM], wordref[COUNT][DIM]={{"play"},
																	{"cry"},
																	{"fry"},
																	{"accomplish"},
																	{"fox"},
																	{"watch"},
																	{"baby"}};

	printf("Insert a word and the program will show the plural form:");
	scanf(" %[^\n]s", word);

	RegularPluralForm(DIM,word);
	printf("The plural form is: %s\n\n", word);

	for(i=0; i<COUNT; i++)
	{
		printf("The given word is %s\n", wordref[i]);
		RegularPluralForm(DIM,wordref[i]);
		printf("The plural form is %s\n\n", wordref[i]);
	}


	return 0;
}

//Func defin
void RegularPluralForm(int row, char word[])
{
	int counter=strlen(word); //Where the \0 is placed so i want to go on previous positions to check

	switch(word[counter-1])
	{
		case 's': case 'x':
			word[counter]='e';
			word[counter+1]='s';
			word[counter+2]='\0';
			break;
		case 'h':
			if(word[counter-2]=='c' || word[counter-2]=='s')
			{
				word[counter]='e';
				word[counter+1]='s';
				word[counter+2]='\0';
				break;
			}
		case 'y':
			switch(word[counter-2])
			{
				case 'a':case 'e': case 'i': case 'o': case 'u':
					word[counter]='s';
					word[counter+1]='\0';
					break;
				default:
					word[counter-1]='i';
					word[counter]='e';
					word[counter+1]='s';
					word[counter+2]='\0';
					break;
			}
			break;
		default:
			word[counter]='s';
			word[counter+1]='\0';
			break;
	}
}
