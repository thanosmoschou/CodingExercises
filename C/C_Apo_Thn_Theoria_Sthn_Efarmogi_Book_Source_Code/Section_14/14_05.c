#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *str_cpy(char *trg, const char *src);
int read_text(char str[], int size, int flag);

int main(void)
{
	char *trg, src[100];
	int len;

	printf("Enter text: ");
	len = read_text(src, sizeof(src), 1);
	/* Δυναμική δέσμευση μνήμης ίση με το μήκος του αλφαριθμητικού και μίας επιπλέον οκτάδας για τον τερματικό  χαρακτήρα. */
	trg = (char*)malloc(len + 1);
	if (trg == NULL)
	{
		printf("Error: Not available memory\n");
		exit(EXIT_FAILURE);
	}
	printf("Copied text: %s\n", str_cpy(trg, src));
	free(trg);
	return 0;
}

char *str_cpy(char *trg, const char *src)
{
	int i = 0;
	while (*(src + i) != '\0') /* Αλλιώς, while(src[i] != '\0')*/
	{
		*(trg + i) = *(src + i); /* Αλλιώς, trg[i] = src[i]; */
		i++;
	}
	*(trg + i) = '\0'; /* Αποθήκευση τερματικού χαρακτήρα στην τελευταία θέση. */
	return trg;
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