#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<ctype.h>
#include<string.h>
#define DIMEN 26

int main()
{
	char word[DIMEN];
	int ctr=0,i;

	printf("GIve a word within 25 words:");
	//gets(word);
	scanf("%s", word);

	for(i=0; word[i]!='\0'; i++)
	{

		if(word[i]=='A') ctr++;
	}

	printf("The Capital A's in ypur word are: %d\n", ctr);

	return 0;
}
