#include <stdio.h>

typedef unsigned char BYTE; /* Επειδή η πληροφορία των πεδίων αποθηκεύεται σε bytes προτιμούμε να χρησιμοποιούμε αυτό το όνομα. */

struct header
{
	BYTE pd;
	BYTE crv[3];
	BYTE mt;
};

struct setup
{
	BYTE bc[12];
	BYTE cpn[20];
	BYTE llc[18];
	BYTE hlc[5];
	BYTE dt[8];
};

struct connect
{
	BYTE bc[4];
	BYTE ci[6];
};
struct alerting
{
	BYTE bc[8];
	BYTE pi[4];
	BYTE sig[3];
	BYTE hlc[5];
};

struct isdn_msg
{
	struct header hdr; /* Κοινή επικεφαλίδα για όλα τα μηνύματα. */
	union
	{
		struct setup set;
		struct connect con;
		struct alerting alrt;
	};
};

int main(void)
{
	BYTE pkt[100];
	int i;
	struct isdn_msg msg;

	for (i = 0; i < 100; i++)
	{
		printf("Enter octet: ");
		scanf("%d", &pkt[i]);
		if (pkt[i] == -1)
			break;
	}
	msg.hdr.pd = pkt[0];
	for (i = 0; i < 3; i++)
		msg.hdr.crv[i] = pkt[i + 1];
	msg.hdr.mt = pkt[4];

	if (msg.hdr.mt == 5) /* SETUP. */
	{
		for (i = 0; i < 12; i++)
			msg.set.bc[i] = pkt[5 + i];
		for (i = 0; i < 20; i++)
			msg.set.cpn[i] = pkt[17 + i];
		for (i = 0; i < 18; i++)
			msg.set.llc[i] = pkt[37 + i];
		for (i = 0; i < 5; i++)
			msg.set.hlc[i] = pkt[55 + i];
		for (i = 0; i < 8; i++)
			msg.set.dt[i] = pkt[60 + i];
	}
	else if (msg.hdr.mt == 7) /* CONNECT. */
	{
		for (i = 0; i < 4; i++)
			msg.con.bc[i] = pkt[5 + i];
		for (i = 0; i < 6; i++)
			msg.con.ci[i] = pkt[9 + i];
	}
	else if (msg.hdr.mt == 1) /* ALERT. */
	{
		for (i = 0; i < 8; i++)
			msg.alrt.bc[i] = pkt[5 + i];
		for (i = 0; i < 4; i++)
			msg.alrt.pi[i] = pkt[13 + i];
		for (i = 0; i < 3; i++)
			msg.alrt.sig[i] = pkt[17 + i];
		for (i = 0; i < 5; i++)
			msg.alrt.hlc[i] = pkt[20 + i];
	}
	return 0;
}