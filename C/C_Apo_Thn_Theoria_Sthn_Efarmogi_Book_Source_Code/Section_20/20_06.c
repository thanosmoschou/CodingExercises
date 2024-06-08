#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ORG 20

int read_text(char str[], int size, int flag);

int main(void)
{
	char org_name[MAX_ORG][100], tmp[100];
	int i, j, k, found, tot_grd[MAX_ORG] = { 0 }, org_grd[MAX_ORG][MAX_ORG] = { 0 };

	for (i = 0; i < MAX_ORG; i++)
	{
		printf("\nEnter name of org_%d: ", i + 1);
		read_text(org_name[i], sizeof(org_name[i]), 1);

		for (j = 0; j < MAX_ORG; j++)
		{
			/* Ένας οργανισμός δεν βαθμολογεί τον εαυτό του. */
			if (i == j)
				continue;
			while (1)
			{
				do
				{
					printf("Enter grade for org_%d [1-%d]: ", j + 1, MAX_ORG);
					scanf("%d", &org_grd[i][j]);
				} while (org_grd[i][j] < 1 || org_grd[i][j] > MAX_ORG);
				found = 0;
				/* Ελέγχουμε ότι ο βαθμός δεν έχει δοθεί σε κάποιον προηγούμενο οργανισμό. */
				for (k = 0; k < j; k++)
				{
					if (org_grd[i][k] == org_grd[i][j])
					{
						printf("Error: The grade %d is given\n", org_grd[i][j]);
						found = 1;
						break;
					}
				}
				if (found == 0)
					break;
			}
			tot_grd[j] += org_grd[i][j]; /* Σε αυτόν τον πίνακα αποθηκεύονται οι συνολικοί βαθμοί του κάθε οργανισμού. */
		}
		getchar();
	}
	for (i = 0; i < MAX_ORG; i++)
	{
		for (j = i + 1; j < MAX_ORG; j++)
		{
			if (tot_grd[i] < tot_grd[j])
			{
				/* Αντιμετάθεση βαθμών και των αντίστοιχων ονομάτων. */
				k = tot_grd[i];
				tot_grd[i] = tot_grd[j];
				tot_grd[j] = k;

				strcpy(tmp, org_name[j]);
				strcpy(org_name[j], org_name[i]);
				strcpy(org_name[i], tmp);
			}
		}
	}
	for (i = 0; i < MAX_ORG; i++)
		printf("%s: %d\n", org_name[i], tot_grd[i]);
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