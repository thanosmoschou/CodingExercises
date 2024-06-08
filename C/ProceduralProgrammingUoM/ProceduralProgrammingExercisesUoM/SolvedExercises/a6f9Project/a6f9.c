/*This program ignores all spaces between words and puts all the words vertically*/

#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>

//Function declaration
void Read_Write_File(FILE *infile, FILE *outfile);

int main()
{
	FILE *infile, *outfile;


	infile=fopen("i6f9.dat", "r");
	if(infile==NULL)
	{
		printf("Cannot open file %s.Execution terminated.\n", "i6f9.dat");
		exit(1);
	}

	outfile=fopen("o6f9.dat","w");

	Read_Write_File(infile, outfile);

	fclose(infile);
	fclose(outfile);
	system("pause");
	return 0;
}

//Function definition

void Read_Write_File(FILE *infile, FILE *outfile)
{
	int ch1;
	int ch2=65;

	while((ch1=fgetc(infile))!=EOF)
	{
 		if(ch1!=' ' )
		{
			if(ch2==' ' )
			{
				fputc('\n',outfile);//In this part ch2 counts as the previous letter but in the else part if this condition counts as the current letter
				fputc(ch1,outfile); //definitely a letter
				ch2=95;//If i use ch2 previously i don't want to put a \n again so i put this ASCII code
			}
			else
				fputc(ch1,outfile); //definitely a letter

		}
		else
		{
			//check the next char..if it is a space continue but is is a letter put a \n and then the letter

				ch2=fgetc(infile);
				if(ch2!=' ')
				{
					fputc('\n',outfile);
					fputc(ch2,outfile);
				}
		}
	}

}
