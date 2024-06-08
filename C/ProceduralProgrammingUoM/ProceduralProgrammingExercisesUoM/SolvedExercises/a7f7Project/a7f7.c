/*Scrabble game point program*/

#include<stdio.h>
#include<ctype.h>
#include<string.h>
#define WORDDIMEN 20

/*Function declaration*/
int ScrabbleScore(int dimen, char word[]);

int main()
{
	char word[WORDDIMEN+1],choice;

	while(1)
	{
		printf("Give your word within 20 characters: ");
		gets(word);

		printf("Your word: %s deserves: %d points!!!\n", word, ScrabbleScore(strlen(word)+1, word));
		/*strlen +1 because i want to pass also \0 for my computation and strlen doesn't count \0 to the length*/

		printf("Do you want to continue counting?(Y/N)");
		scanf(" %c", &choice); /* The first character in the string element is a space character for the compiler in order to ignore white spaces */
		if(choice!='Y' && choice!='y') break;
		else getchar(); /* read the remaining input of the stdin from the previous input because choice remains to the stdin*/
		printf("\n");

	}


	return 0;
}

/*Function definition*/

int ScrabbleScore(int dimen, char word[])
{
	int sum=0,i;

	for(i=0; word[i]!='\0'; i++)
	{
		switch(word[i])
		{
			case 'A':case 'E':case 'I':case 'L':case 'N':case 'O':case 'R':case 'S':case 'T':case 'U':
				(sum++);
				break;
			case 'D':case 'G':
				(sum+=2);
				break;
			case 'B':case 'C':case 'M':case 'P':
				(sum+=3);
				break;
			case 'F':case 'H':case 'V':case 'W':case 'Y':
				(sum+=4);
				break;
			case 'K':
				(sum+=5);
				break;
			case 'J':case 'X':
				(sum+=8);
				break;
			case 'Q':case 'Z':
				(sum+=10);
				break;
		}
	}

	return sum;
}
