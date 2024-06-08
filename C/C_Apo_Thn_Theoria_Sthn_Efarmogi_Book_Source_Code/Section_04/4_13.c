#include <stdio.h>
int main(void)
{
	unsigned char temp, urg, ack, syn, fin;

	printf("Enter FIN bit: ");
	scanf("%d", &fin);

	printf("Enter SYN bit: ");
	scanf("%d", &syn);

	printf("Enter ACK bit: ");
	scanf("%d", &ack);

	printf("Enter URG bit: ");
	scanf("%d", &urg);

	temp = fin + (syn << 1) + (ack << 4) + (urg << 5);
	printf("\nEncoding: %d\n", temp);

	fin = temp & 1;
	syn = (temp >> 1) & 1;
	ack = (temp >> 4) & 1;
	urg = (temp >> 5) & 1;
	printf("FIN = %d, SYN = %d, ACK = %d, URG = %d\n", fin, syn, ack, urg);
	return 0;
}