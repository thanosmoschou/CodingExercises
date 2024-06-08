#include <stdio.h>
#include "genlib.h"
#include "simpio.h"


int main()
{
	int ypsos,platos,i,k,ctr;

	printf("Dwse ypsos:");
	ypsos=GetInteger();

	printf("Dwse platos:");
	platos=GetInteger();

	for(ctr=0;ctr<2;ctr++) //Tn evala giati thelo na bgalo orizonties grammes 2 fores gia na mhn grafo kwdika ksana
	{

		for (i=1;i<=platos;i++) //Tyono orizonties kai an ftaso sto orio pou mou edose tote allazo grammi kai ksekinao na tipono tis kathetes
		{
			printf("*");
			if (i==platos)
			{
				printf("\n");
			}
		}

		if(ctr==0) //To evala giati tis kathetes tis tipono mazi diladi *   * allazo grammi kai pali to idio kai etsi vgainoun oi grammes. Omos thelo 1 fora na to kano oste na bgei to sxhma
		{
			for(i=2;i<=ypsos-1;i++) //To evala 2 giati upotithetai apo tin 1h grammh exo 1 * kai gia tin katheti ara pao apo kato tou gia na ektiposo kai ypsos -1 gia ton idio logo oti exo apo kato ena ara thelo to apo pano
			{
				for (k=1;k<=platos;k++) //Thelo tin diadikasia ektuposis gia oso ypsos edose
				{
					if(k==1)
					{
						printf("*");
					}
					else if(k==platos)
					{
						printf("*\n"); //Prepei na allakso grammi kai na sunexiso apo kato thn ektyposi
					}
					else
					{
						printf(" "); //edo thelo na ektupothei keno giati oi pleures tiponontai parallila kai thelo na kleinei orthii gonia me tis orizonties ara tha ektuposo * otan ftaso sto telos
					}

				}
			}
		}
	}

	return 0;
}
