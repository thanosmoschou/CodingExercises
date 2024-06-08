#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
	int choice;

	printf("PROCESSING STUDENTS' DATA \n");
	printf("1.INSERT\n");
	printf("2.EDIT\n");
	printf("3.DELETE\n");
	printf("4.SHOW\n");
	printf("4.SHOW\n\n");
	printf("CHOICE: ");
	choice=GetInteger();
	printf("\n");
	printf("PRESS ENTER TO CONTINUE...");
	return 0;
}
