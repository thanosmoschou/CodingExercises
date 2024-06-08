#include <stdio.h>
#include <stdlib.h>

typedef unsigned char BYTE;

void Build_Pkt(int IP_src[], int IP_dst[], int port);
void Save_Pkt(BYTE pkt[], int len);

int main(void)
{
	int IP_src[4], IP_dst[4], TCP_dst_port;

	do
	{
		printf("Enter dst port [1-65535]: ");
		scanf("%d", &TCP_dst_port);
	} while (TCP_dst_port < 1 || TCP_dst_port > 65535);

	printf("Enter dst IP (x.x.x.x): ");
	scanf("%d.%d.%d.%d", &IP_dst[0], &IP_dst[1], &IP_dst[2], &IP_dst[3]);

	if (TCP_dst_port == 80)
	{
		if (IP_dst[0] == 130 && IP_dst[1] == 140)
		{
			printf("It isn't allowed to connect to network 130.140.x.x\n");
			return 0;
		}
		else if (IP_dst[0] == 160 && IP_dst[1] == 170)
		{
			printf("It isn't allowed to connect to network 160.170.x.x\n");
			return 0;
		}
	}
	printf("Enter src IP (x.x.x.x): ");
	scanf("%d.%d.%d.%d", &IP_src[0], &IP_src[1], &IP_src[2], &IP_src[3]);

	Build_Pkt(IP_src, IP_dst, TCP_dst_port);
	return 0;
}

void Build_Pkt(int IP_src[], int IP_dst[], int port)
{
	BYTE pkt[40] = { 0 }; /* Τα πεδία αρχικοποιούνται με την τιμή 0. */
	int i, j;

	pkt[0] = 0x45; /* Version, IHL. */
	pkt[8] = 255; /* Time to Live. */
	pkt[9] = 6; /* Protocol = TCP. */
	for (i = 12, j = 0; i < 16; i++, j++)
		pkt[i] = IP_src[j]; /* IP Source. */
	for (i = 16, j = 0; i < 20; i++, j++)
		pkt[i] = IP_dst[j]; /* IP Destination. */
	pkt[20] = 1500 >> 8; /* TCP Source Port. */
	pkt[21] = 1500 & 0xFF;
	pkt[22] = port >> 8; /* TCP Dest Port. */
	pkt[23] = port & 0xFF;
	pkt[33] = 2; /* SYN bit. */
	pkt[34] = 0xFF; /* Η μέγιστη τιμή για το πεδίο Window είναι 16 bits άσσοι. */
	pkt[35] = 0xFF;
	/* Στις θέσεις 36-40 είναι οι τιμές των πεδίων CheckSum και Urgent Pointer, άρα το συνολικό μήκος του ΙΡ πακέτου είναι 40 οκτάδες. */
	pkt[2] = 0; /* IP Total Length. */
	pkt[3] = 40;

	Save_Pkt(pkt, 40);
}

void Save_Pkt(BYTE pkt[], int len)
{
	FILE *fp;
	char name[100];
	int i;

	printf("Enter file name: ");
	scanf("%s", name);

	fp = fopen(name, "w");
	if (fp == NULL)
	{
		printf("Error: fopen() failed\n");
		exit(EXIT_FAILURE);
	}
	for (i = 0; i < len; i++)
	{
		if (i % 16 == 0)
			putc('\n', fp);
		fprintf(fp, "%02X ", pkt[i]);
	}
	fclose(fp);
}