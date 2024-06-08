#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int read_text(char str[], int size, int flag);
void parse_str(char str[]);

int main(void)
{
	char str[100];

	printf("Enter text: ");
	read_text(str, sizeof(str), 1);
	parse_str(str);
	return 0;
}

void parse_str(char s[])
{
	int dig, uplet_wrd, lowlet_wrd;

	dig = uplet_wrd = lowlet_wrd = 0;
	while (*s != '\0')
	{
		while (isspace(*s)) /* Προσπερνάμε τους κενούς χαρακτήρες μέχρι να αρχίσει κάποια λέξη. */
			s++;
		if (*s == '\0')
			break;
		/* Ελέγχουμε αν η λέξη αρχίζει από ψηφίο ή γράμμα.*/
		if (isdigit(*s))
			dig++;
		else if (isupper(*s))
			uplet_wrd++;
		else if (islower(*s))
			lowlet_wrd++;
		s++;
		if (*s == '\0')
			break;
		while (isspace(*s) == 0) /* Προσπερνάμε τους χαρακτήρες της λέξης, ελέγχοντας μόνο για ψηφία. */
		{
			if (isdigit(*s))
				dig++;
			s++;
			if (*s == '\0')
				break;
		}
	}
	printf("UL:%d LL:%d DG:%d\n", uplet_wrd, lowlet_wrd, dig);
}

int read_text(char str[], int size, int flag)
{
	int len;

	if (fgets(str, size, stdin) == NULL)
	{
		printf("Error: fgets() failed\n");
		exit(EXIT_FAILURE);
	}
	len = strlen(str);
	if (len > 0)
	{
		if (flag && (str[len - 1] == '\n'))
		{
			str[len - 1] = '\0';
			len--;
		}
	}
	else
	{
		printf("Error: No input\n");
		exit(EXIT_FAILURE);
	}
	return len;
}