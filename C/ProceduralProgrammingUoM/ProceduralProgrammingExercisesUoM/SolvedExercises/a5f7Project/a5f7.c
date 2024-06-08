#include<stdio.h>
#include"genlib.h"
#include<ctype.h>
#include<string.h>


//Function declaration
bool IsConsonant(char a);

int main()
{
	char i;

	for(i='A'; i<='z'; i++)
	{
		if(IsConsonant(i))
		{
			if(i<91 ||  i>96)
			{
				printf("%c ", i);
			}
			else
			{
				continue;
			}
		}

		if(i=='Z') printf("\n");
	}

	return 0;
}

//Function definition
bool IsConsonant(char a)
{
		switch(a)
		{
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				return FALSE;

		}
		return TRUE;
}
