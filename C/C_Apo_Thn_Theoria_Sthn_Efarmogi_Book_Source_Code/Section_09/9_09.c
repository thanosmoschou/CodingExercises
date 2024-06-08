#include <stdio.h>
int main(void)
{
	int ch, dots, bytes, temp;
	dots = bytes = temp = 0;
	printf("Enter IP address (x.x.x.x): ");

	while ((ch = getchar()) != '\n' && ch != EOF)
	{
		if (ch < '0' || ch > '9')
		{
			if (ch == '.')
			{
				dots++;
				if (temp != -1)
				{
					if (temp > 255)
					{
						printf("Error: The value of each byte should be in [0, 255]\n");
						return 0;
					}
					bytes++;
					temp = -1; /* Η τιμή -1 σημαίνει ότι η τελευταία οκτάδα ελέγχθηκε. */
				}
			}
			else
			{
				printf("Error: Acceptable chars are only digits and dots\n");
				return 0;
			}
		}
		else
		{
			if (temp == -1)
				temp = 0; /* Γίνεται ίση με 0, ώστε να ξεκινήσουμε τον υπολογισμό της νέας οκτάδας. */
			temp = 10 * temp + (ch - '0');
		}
	}
	if (temp != -1) /* Ελέγχουμε την τιμή της τελευταίας οκτάδας. */
	{
		if (temp > 255)
		{
			printf("Error: The value of each byte should be in [0, 255]\n");
			return 0;
		}
		bytes++;
	}
	if (dots != 3 || bytes != 4)
		printf("Error: The IP format should be x.x.x.x\n");
	else
		printf("The input address is a valid IPv4 address\n");
	return 0;
}