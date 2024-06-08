#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NUM 10

int read_text(char str[], int size, int flag);

int main(void)
{
	char tmp[40], str[NUM][40] = { 0 };
	int i, j, ch, num, len, max_len, cnt, max_cnt, col;

	num = max_len = 0;
	for (i = 0; i < NUM; i++)
	{
		printf("Enter text: ");
		len = read_text(tmp, sizeof(tmp), 1);
		if (tmp[0] == 'a' && tmp[len - 1] == 's')
		{
			strcpy(str[num], tmp);
			num++;
			if (len > max_len)
				max_len = len;
		}
	}
	if (num == 0)
	{
		printf("None string is stored\n");
		return 0;
	}
	printf("Enter character: ");
	ch = getchar();

	max_cnt = 0;
	/* Χρησιμοποιούμε το μήκος του μεγαλύτερου αλφαριθμητικού και τον αριθμό των αλφαριθμητικών που έχουν αποθηκευτεί, ώστε να αναζητούμε τον χαρακτήρα μόνο στις γραμμές και στήλες που γνωρίζουμε ότι έχουν αποθηκευτεί χαρακτήρες. */
	for (j = 0; j < max_len; j++)
	{
		cnt = 0;
		for (i = 0; i < num; i++)
		{
			if (str[i][j] == ch)
				cnt++;
		}
		if (cnt > max_cnt)
		{
			max_cnt = cnt;
			col = j;
		}
	}
	if (max_cnt == 0)
		printf("%c is not stored\n", ch);
	else
		printf("Max appearances of %c is %d in col_%d\n", ch, max_cnt, col + 1);
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