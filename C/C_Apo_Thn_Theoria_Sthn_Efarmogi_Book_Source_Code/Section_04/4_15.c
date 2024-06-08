#include <stdio.h>
int main(void)
{
	unsigned char data, ones, bit1, bit2, bit3, bit4, bit5, parity_bit;

	ones = 0;

	printf("Enter bit1: ");
	scanf("%d", &bit1);
	if (bit1 == 1)
		ones++;
	printf("Enter bit2: ");
	scanf("%d", &bit2);
	if (bit2 == 1)
		ones++;

	printf("Enter bit3: ");
	scanf("%d", &bit3);
	if (bit3 == 1)
		ones++;

	printf("Enter bit4: ");
	scanf("%d", &bit4);
	if (bit4 == 1)
		ones++;

	printf("Enter bit5: ");
	scanf("%d", &bit5);
	if (bit5 == 1)
		ones++;

	if (ones & 1) /* Σημαίνει ότι ο αριθμός των «1» είναι περιττός. */
		parity_bit = 1;
	else
		parity_bit = 0;

	data = (bit1 << 6) + (bit2 << 5) + (bit3 << 4) + (bit4 << 3) + (bit5 << 2) + (parity_bit << 1) + 1; /* Το τελευταίο 1 αντιστοιχεί στο stop_bit. */
	printf("%d\n", data);
	return 0;
}