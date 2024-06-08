#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>
#define DIM 100
#define ASCII0 48
#define ASCII9 57

int main()
{
	char *word, *num;
	int i,ctr=0;

	word=(char *)malloc(DIM*sizeof(char));

	printf("Insert a string: ");
	scanf(" %[^\n]s", word);
	word[strlen(word)]='\0';

	num=(char *)malloc(DIM*sizeof(char));

	for(i=0; word[i]!='\0'; i++) //or i<strlen(word)
	{
		if(word[i]>=ASCII0 && word[i]<= ASCII9)
		{
			num[ctr]=word[i];
			ctr++;
		}
	}

	num[ctr]='\0'; //At the last loop the ctr increased so i must not increase it again

	//int conv[strlen(num)];

	ctr=0;

	if(strlen(num)==0)
	{
		printf("No digits in input.\n");
	}
	else if(strlen(num)==1)
	{
		printf("%c = %d\n", num[0], num[0]-ASCII0);
	}
	else
	{
		for(i=0; num[i]!='\0'; i++)
		{
			if(i<strlen(num)-1)
			{
				printf("%c + ", num[i]);
				ctr+=(int)num[i]-ASCII0;
			}
			else if(i==strlen(num)-1)
			{
				printf("%c ", num[i]);
				ctr+=(int)num[i]-ASCII0;
			}
		}

		printf("= %d\n", ctr);

	}

	free(word);
	free(num);

	system("PAUSE");
}
