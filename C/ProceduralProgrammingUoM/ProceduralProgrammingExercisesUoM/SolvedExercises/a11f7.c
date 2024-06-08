#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include"genlib.h"
#include"simpio.h"
#define LEN 80


void RemoveSpaces(char table[]);


int main()
{
    char name[LEN],address[LEN], server[LEN];
    int i,ctr;

    printf("Give address:");
    gets(address);

    RemoveSpaces(address);
    printf("original address: %s\n", address);

    i=0;
    while(address[i]!='@')
    {
        name[i]=address[i];
        i++;
    }

    name[i]='\0';

    ctr=0;
    for(i++; address[i]!='\0'; i++)
    {
        server[ctr]=address[i];
        ctr++;
    }
    server[ctr]='\0';

    printf("User's name:%s with length: %d\n", name, (int)strlen(name));
    printf("Server's name: %s with length: %d\n", server, strlen(server));

    /*Alternative solution for copying the server's name. Strcpy func copies everything i tell AND the last terminal character \0 of the table that i put my string previously
    strcpy(server,address+i+1);*/

    return 0;
}

void RemoveSpaces(char table[])
{
    /*
    int i,ctr=0;
    char temp[strlen(table)];

    strcpy(temp, table);

    for(i=0; i<=strlen(temp); i++)
    {
        if(temp[i]!=' ')
        {
            table[ctr]= temp[i];
            ctr++;
        }
    }*/


    int i,j=0,len;
    len=(int)strlen(table);
    for(i=0; i<=len ; i++) //vazo <= giati h strlen den metraei to \0.... an doso abc h strlen tha vgalei 3 omos oi theseis ksekinane apo 0 ara tha paei a=0, b=1, c=2 ara to \0 einai sthn thesi 3 opote me <= strlen eimai kalimmenos
    {
        if(table[i]!= ' ')
        {
            table[j]= table[i];
            j++;
        }
    }

}
