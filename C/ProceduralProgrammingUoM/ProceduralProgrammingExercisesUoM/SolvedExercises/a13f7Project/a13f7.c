#include<stdio.h>
#include<ctype.h>
#include<string.h>
#define DIM 100

//Func decl
void FindLett(int row, int lim1, int lim2, char word1[], char word2[]);


int main()
{

	char word1[DIM]={'\0'}, word2[DIM]={'0'};

	printf("Please insert two word to find the common characters. \n");

	printf("Word 1: ");
	scanf(" %[^\n]s", word1);
	//word1[strlen(word1)]='\0';

	printf("Word 2: ");
	scanf(" %[^\n]s", word2);
//	word1[strlen(word2)]='\0';

	FindLett(DIM, strlen(word1), strlen(word2), word1, word2);


	return 0;
}

//Func defin
void FindLett(int row, int lim1, int lim2, char word1[], char word2[])
{
	int i,k,ctr=0;
	char comm[row];

	for(k=0; word1[k]!='\0' ; k++)
	{
		for(i=0; word2[i]!='\0'; i++)
		{
			if(word1[k]==word2[i])
			{
				comm[ctr]=word1[k];
				ctr++;
				break;
			}
		}
	}
	comm[ctr]='\0';

	printf("Common Characters of %s in %s:%s \n", word1, word2, comm);


	char uniq[row];
	int ctr1=0,j,ct;


	for(i=0; comm[i]!='\0'; i++)
	{
		ct=0;
		for(j=0; j<strlen(uniq); j++)
		{
			if(comm[i]==uniq[j])
			{
				ct++;
				continue;
			}
		}
		if(ct==0)
		{
			uniq[ctr1]=comm[i];
			ctr1++;
		}
	}
	uniq[ctr1]='\0';

	for(i=0; i<4; i++) printf("-");
	printf("\n");
	printf("Set of (unique) Common Characters of %s and %s:%s \n", word1, word2, uniq);
	for(i=0; i<4; i++) printf("-");
	printf("\n");

}
