#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int read_text(char str[], int size, int flag);

int main(void)
{
	char str[100];
	int i, len, cnt;

	printf("Original text  : ");
	len = read_text(str, sizeof(str), 1);

	printf("Compressed text: ");
	i = 0;
	while (i < len)
	{
		cnt = 1;
		if (str[i] < '0' || str[i] > '9') /* Σύμφωνα με την εκφώνηση να μην γίνεται συμπίεση ψηφίων. */
		{
			while (str[i + cnt] == str[i]) /* Έλεγχος αν ο συγκεκριμένος χαρακτήρας, δηλαδή ο str[i], επαναλαμβάνεται στις επόμενες θέσεις. */
				cnt++;

			if (cnt == 1)
				printf("%c", str[i]);
			else
				printf("%d%c", cnt, str[i]);
		}
		else
			printf("%c", str[i]);

		i += cnt;
	}
	return 0;
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