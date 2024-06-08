#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<math.h>
#include<stdlib.h>
#include<time.h>


int main()
{
	char *word, temp;
	int dim,i,lim,a,b;

	printf("Insert the dimension of your word:");
	scanf("%d", &dim);

	word=(char *)malloc(dim*sizeof(char));
	printf("Word to shuffle :");
	scanf(" %[^\n]s", word);
	word[strlen(word)]='\0';

	printf("Initial Word: %s,", word);

	//Change the letters
	srand(time(NULL));

	lim=rand() % dim;

	//It creates random numbers for condition and indexes so sometimes it is possible not to change anything
	for(i=0; i<lim; i++)
	{
		//srand(time(NULL));
		a=rand()%lim;
		//srand(time(NULL));
		b=rand()%lim;

		temp= word[a];
		word[a]=word[b];
		word[b]=temp;
	}
	word[strlen(word)]='\0';

	printf(" New Word: %s\n", word);
	free(word);

	system("PAUSE");
}
