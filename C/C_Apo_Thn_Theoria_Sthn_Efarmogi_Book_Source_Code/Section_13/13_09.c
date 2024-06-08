#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 100

struct student
{
	char name[50];
	int code;
	float grd;
};

void sort_by_grade(struct student studs[], int num_studs);
void show_students(struct student studs[], int num_studs, float avg_grd);
int read_text(char str[], int size, int flag);

int main(void)
{
	int i;
	float sum_grd;
	struct student studs[SIZE];

	sum_grd = 0;
	for (i = 0; i < SIZE; i++)
	{
		printf("\nGrade [0-10]: ");
		scanf("%f", &studs[i].grd);
		if (studs[i].grd == -1)
			break;

		sum_grd += studs[i].grd;
		getchar();

		printf("Name: ");
		read_text(studs[i].name, sizeof(studs[i].name), 1);

		printf("Code: ");
		scanf("%d", &studs[i].code);
	}
	if (i == 0)
		return 0;
	sort_by_grade(studs, i); /* Ταξινόμηση δομών σε αύξουσα σειρά σύμφωνα με την τιμή του πεδίου grd. Η μεταβλητή i δείχνει πόσοι φοιτητές εισήχθησαν. */
	show_students(studs, i, sum_grd / i); /* Το τελευταίο όρισμα είναι ο μέσος όρος των βαθμών. */
	return 0;
}
void sort_by_grade(struct student studs[], int num_studs)
{
	int i, j;
	struct student temp;

	for (i = 0; i < num_studs - 1; i++)
	{
		/* Γίνεται σύγκριση του πεδίου grd κάθε δομής με το αντίστοιχο πεδίο των υπολοίπων δομών και αν βρεθεί κάποια με μικρότερη τιμή, τότε οι δομές αντιμετατίθενται. */
		for (j = i + 1; j < num_studs; j++)
		{
			if (studs[i].grd > studs[j].grd)
			{
				temp = studs[i];
				studs[i] = studs[j];
				studs[j] = temp;
			}
		}
	}
}

void show_students(struct student studs[], int num_studs, float avg_grd)
{
	int i;

	for (i = 0; i < num_studs; i++)
	if (studs[i].grd > avg_grd)
		printf("N: %s C: %d G: %f\n", studs[i].name, studs[i].code, studs[i].grd);
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