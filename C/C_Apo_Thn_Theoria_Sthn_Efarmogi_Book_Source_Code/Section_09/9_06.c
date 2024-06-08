#include <stdio.h>
int main(void)
{
	char ch, end_ch;

	end_ch = 'z';
	for (ch = 'a'; ch <= end_ch; ch++)
	{
		printf("%c ", ch);
		if (ch == 'z')
		{
			ch = 'A' - 1; /* Αφαιρούμε 1, ώστε στην επόμενη επανάληψη του βρόχου με την εντολή ch++ να γίνει ίση με 'Α'. */
			end_ch = 'Z'; /* Αλλάζουμε τον τερματικό χαρακτήρα, ώστε ο βρόχος να εμφανίσει τα κεφαλαία γράμματα. */
			printf("\n");
		}
		else if (ch == 'Z')
		{
			ch = '0' - 1;
			end_ch = '9';
			printf("\n");
		}
	}
	return 0;
}