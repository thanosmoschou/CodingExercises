#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	int b,result1,a,p,r,q,x,y;

	/*Xrisimopoio ton telesti " , " poy dexetai px 2 orismata ,upologizei kai tis 2 parastaseis
	alla epistrefei mono tin timh ths  deuteris .Stin megali parenthesi exo 2 orismata ena print kai mia parenthesi
	 kai sthn mikrh exo 2, sthn mikrh parenthesi epistrefetai to apotelesma ths deuteris parastasis dhladi oli h parastash
	 ths parenthesis apotimatai sthn timh ths deuteris parastasis  kai tora sthn megali
	 exo 2 orismata kai tha epistrafei to apotelesma ths deyteris kai tha ekxorithei sthn metavliti*/

	result1=(printf("Dwse arithmo:"),(b= GetInteger() ,b>=2 && b<=5));
	printf("%d\n",result1);

	result1= (printf("Dwse arithmo:"),a=GetInteger(),(a<6 || a>10));
	printf("%d\n",result1);

	result1=(printf("Dwse 3 arithmous:"),p=GetInteger(),r=GetInteger(),q=GetInteger(),(p==r && r==q && p==q));
	printf("%d\n",result1);

	result1=((x=GetInteger(),y=GetInteger()),((x<3)^(y<3)) ); //xor giati prepei x<3 h y<3 oxi omos kai ta dyo mazi
	printf("%d",result1);

	result1=((x=GetInteger(),y=GetInteger()),((x<3) && !(y<3)) || (!(x<3) && (y<3))); //enallaktiki xoris xor bazeis to ena na isxuei kai to allo oxi giati den thes na
	//isxuoun tautoxrona ara x<3 kai oxi y<3 olo se parenthesi  kai meta vazeis to antitheto se parenthesi me ton telesti h anamesa
	//stis parenthesis

	printf("%d",result1);

	return 0;
}
