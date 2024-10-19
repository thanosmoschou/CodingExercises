/*
Author: Thanos Moschou
Description: Chessboard exercise solution
*/

// Package chessboard contains some functions for our chess game.
package chessboard

// File is a custom type that tells if a square is occupied by a piece.
type File []bool

// Chessboard is a custom type which contains a map of eight Files, accessed with keys from "A" to "H".
type Chessboard map[string]File

// CountInFile returns how many squares are occupied in the chessboard,
// within the given file.
func CountInFile(cb Chessboard, file string) int {
	counter := 0
	column := cb[file]

	for _, value := range column {
		if value {
			counter++
		}
	}

	return counter
}

// CountInRank returns how many squares are occupied in the chessboard,
// within the given rank.
func CountInRank(board Chessboard, rank int) int {
	counter := 0

	if rank >= 1 && rank <= 8 {
		for _, column := range board {
			if column[rank-1] {
				counter++
			}
		}
	}

	return counter
}

// CountAll should count how many squares are present in the chessboard.
func CountAll(cb Chessboard) int {
	counter := 0

	for _, v := range cb {
		for range v {
			counter++
		}
	}

	return counter
}

// CountOccupied returns how many squares are occupied in the chessboard.
func CountOccupied(cb Chessboard) int {
	counter := 0

	for key := range cb {
		counter += CountInFile(cb, key)
	}

	return counter
}
