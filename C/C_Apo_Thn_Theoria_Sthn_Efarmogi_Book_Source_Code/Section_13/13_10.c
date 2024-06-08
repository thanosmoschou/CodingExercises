#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS    3
#define COLS    5

struct pixel /* RGB μορφή (Red-Green-Blue). */
{
	unsigned char red; /* Τιμή στο [0, 255]. */
	unsigned char green;
	unsigned char blue;
};

void rotate_right_90(struct pixel img[][COLS], struct pixel tmp[][ROWS]);

int main(void)
{
	int i, j;
	struct pixel img[ROWS][COLS], tmp[COLS][ROWS];

	srand(time(NULL));
	/* Δημιουργούμε τυχαία χρώματα. */
	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
		{
			img[i][j].red = rand() % 256;
			img[i][j].green = rand() % 256;
			img[i][j].blue = rand() % 256;
		}
	}
	printf("*** Original Image ***\n\n");
	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
		{
			printf("(%3d,%3d,%3d) ", img[i][j].red, img[i][j].green, img[i][j].blue);
		}
		printf("\n");
	}
	rotate_right_90(img, tmp);

	printf("\n*** Rotated Image ***\n\n");
	for (i = 0; i < COLS; i++)
	{
		for (j = 0; j < ROWS; j++)
		{
			printf("(%3d,%3d,%3d) ", tmp[i][j].red, tmp[i][j].green, tmp[i][j].blue);
		}
		printf("\n");
	}
	return 0;
}

void rotate_right_90(struct pixel img[][COLS], struct pixel tmp[][ROWS])
{
	int i, j, k = 0;

	for (i = ROWS - 1; i >= 0; i--)
	{
		for (j = 0; j < COLS; j++)
		{
			tmp[j][i] = img[k][j];
		}
		k++;
	}
}