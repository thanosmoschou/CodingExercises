#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

#define ROWS 12
#define COLUMNS 4

void upDateSeats(int row, int col, int tab[row][col]);

int main() {

  int seats[ROWS][COLUMNS] = {{1,0,   0, 1},
                              {1,0,   0, 1},
                              {0,1,   0, 0},
                              {0,0,   1, 1},
                              {1,1,   0, 0},
                              {1,1,   0, 1},
                              {0,0,   1, 1},
                              {1,0,   0, 0},
                              {0,0,   1, 0},
                              {0,0,   0, 0},
                              {0,0,   0, 0},
                              {1,1,   0, 1}};

  upDateSeats(ROWS,COLUMNS,seats);
  return 0;
}

/* Function for Testing. */
void upDateSeats(int rows, int cols, int tab[rows][cols]){
   int i,j;
   printf("Update Seats? (0/no):");
   if(!GetInteger()) return;
   for(i=0;i<rows;i++)
      for(j=0;j<cols;j++)
         tab[i][j] = (printf("seat (%2d,%2d)",i,j),GetInteger());
    printf("\n");
}


