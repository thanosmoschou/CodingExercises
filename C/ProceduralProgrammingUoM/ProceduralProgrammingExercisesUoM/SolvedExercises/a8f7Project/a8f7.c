#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>

//Function declaration
void Capitalize(int dimen, char str[]);



int main()
{
	int charac;
	char *st, choice;

	while(1)
	{
		printf("How many characters do you want? ");
		scanf("%d", &charac);
		//getchar();

		st=(char*)malloc(charac*sizeof(char));

		printf("Insert your string within %d characters:", charac);
		scanf(" %[^\n]", st);

		Capitalize(strlen(st)+1, st);
		printf("Your message with the first letter capital is: %s\n", st);

		free(st);

		getchar();
		printf("Do you want to continue?(Y/N)");
		scanf("%c", &choice);

		if(choice!='Y' && choice!='y') break;
		else getchar(); //Read the remaining input from the stdin in order to insert new input...if i won't read the remaining the next reading command will take the remaining element of the stdin as input

		printf("\n");
	}
	return 0;
}

//Function definition

void Capitalize(int dimen, char *str)
{
	int i;

	for(i=0; str[i]!='\0'; i++)
		if(i==0 && islower(str[i]))
			str[i]=toupper(str[i]);
		else if(i !=0 && isupper(str[i]))
			str[i]=tolower(str[i]);
}
