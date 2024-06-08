#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int i, j, flag, sel, num, dist, host_byte;

	do
	{
		printf("Enter last host byte [0-255]: ");
		scanf("%d", &host_byte);
	} while (host_byte < 0 || host_byte > 255);

	do
	{
		flag = 0;
		printf("Enter mask (0: 255.255.255.x form or 1: /bits form): ");
		scanf("%d", &sel);
		if (sel == 0)
		{
			printf("Enter last mask octet 255.255.255.");
			scanf("%d", &num);
			if (num != 252 && num != 248 && num != 240
				&& num != 224 && num != 192 && num != 128)
			{
				printf("Last octet should be one of {128, 192, 224, 240, 248, 252}\n");
				flag = 1;
			}
			else
				dist = 256 - num;
		}
		else if (sel == 1)
		{
			printf("Enter network bits: /");
			scanf("%d", &num);

			if (num < 25 || num > 30)
			{
				printf("Enter valid mask /25-/30\n");
				flag = 1;
			}
			else
			{
				num = 32 - num;
				dist = 1;
				for (i = 0; i < num; i++)
					dist = dist * 2; /* Για πιο γρήγορη υλοποίηση θα μπορούσαμε να αντικαταστήσουμε τον βρόχο με dist = 1 << num; */
			}
		}
	} while (flag == 1);

	printf("\nThe mask 255.255.255.%d produces %d subnets, each with %d hosts\n", 256 - dist, 256 / dist, dist - 2);

	printf("\nNetwork  :  ");
	for (i = 0; i < 256; i += dist)
		printf(".%d\t", i);

	printf("\nBroadcast:  ");
	for (i = dist - 1; i < 256; i += dist)
		printf(".%d\t", i);

	for (i = j = 0; i < 256; i += dist, j++)
	{
		if (host_byte >= i && host_byte < i + dist)
		{
			if (host_byte == i)
				printf("\n\nThe x.x.x.%d address is the network address of subnet_%d\n", host_byte, j + 1);
			else if (host_byte == i + dist - 1)
				printf("\n\nThe x.x.x.%d address is the broadcast address of subnet_%d\n", host_byte, j + 1);
			else
				printf("\n\nThe x.x.x.%d address belongs in subnet %d\n", host_byte, j + 1);
			break;
		}
	}
	return 0;
}