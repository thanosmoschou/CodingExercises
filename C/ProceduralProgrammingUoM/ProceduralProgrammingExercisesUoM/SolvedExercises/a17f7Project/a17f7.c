#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define DIM 40
#define ASCIIa  97
#define ASCIIA 65

int main()
{
		int i;
		char *onoma, *epith, *onomatep;

		onoma = (char *)malloc(DIM*sizeof(char));
		epith = (char *)malloc(DIM*sizeof(char));

		printf("Dwse onoma: ");
		scanf(" %[^\n]s", onoma);
		onoma[strlen(onoma)]='\0';

		printf("Dwse eponymo: ");
		scanf(" %[^\n]s", epith);
		epith[strlen(epith)]='\0';

		printf("\n");
		printf("Onoma = %s\n", onoma);
		printf("Eponymo = %s\n", epith);

		for(i=0; onoma[i]!='\0'; i++)
			onoma[i]= onoma[i]-(ASCIIa-ASCIIA);

		for(i=0; epith[i]!='\0'; i++)
			epith[i]= epith[i]-(ASCIIa-ASCIIA);


		onomatep = (char *)malloc(strlen(onoma)*strlen(epith)*sizeof(char));
		strncpy(onomatep, onoma, strlen(onoma));

		onomatep[strlen(onoma)]=' ';

		strcpy(onomatep+strlen(onoma)+1, epith);
		printf("Onomateponymo = %s\n", onomatep);

		free(onoma);
		free(epith);
		free(onomatep);


	system("PAUSE");
}
