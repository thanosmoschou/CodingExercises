/*
Author: Thanos Moschou
Description: Chessboard exercise solution
*/

package main

import (
	"chessboard/chessboard"
	"fmt"
)

func main() {
	var board = fillBoard()

	fmt.Println(chessboard.CountInFile(board, "A"))
	fmt.Println(chessboard.CountInRank(board, 2))
	fmt.Println(chessboard.CountAll(board))
	fmt.Println(chessboard.CountOccupied(board))

}

func fillBoard() chessboard.Chessboard {
	var board chessboard.Chessboard = make(chessboard.Chessboard, 8)

	board["A"] = make(chessboard.File, 8)
	board["B"] = make(chessboard.File, 8)
	board["C"] = make(chessboard.File, 8)
	board["D"] = make(chessboard.File, 8)
	board["E"] = make(chessboard.File, 8)
	board["F"] = make(chessboard.File, 8)
	board["G"] = make(chessboard.File, 8)
	board["H"] = make(chessboard.File, 8)

	board["A"][0] = true
	board["A"][2] = true
	board["A"][7] = true

	board["B"][4] = true

	board["C"][2] = true

	board["E"][5] = true
	board["E"][7] = true

	board["G"][3] = true

	board["G"][0] = true
	board["G"][1] = true
	board["G"][2] = true
	board["G"][3] = true
	board["G"][4] = true
	board["G"][5] = true
	board["G"][7] = true

	return board
}
