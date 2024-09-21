/*
Author: Thanos Moschou
Description: Gopher's gorgeous lasagna solution from Exercism
*/

package main

import (
	"fmt"
	"gophers-gorgeous-lasagna/lasagna"
)

func main() {
	var timeInOven int
	var totalLayers int

	timeInOven, totalLayers = getUserInput()

	var remainingTime int = lasagna.RemainingOvenTime(timeInOven)
	var prepTime int = lasagna.PreparationTime(totalLayers)
	var elapsedTime = lasagna.ElapsedTime(totalLayers, timeInOven)

	fmt.Printf("Remaining Oven time: %v minutes\nPreparation time: %v minutes\nTotal Elapsed time: %v minutes\n", remainingTime, prepTime, elapsedTime)

}

func getUserInput() (int, int) {
	var timeInOven int
	var totalLayers int

	fmt.Println("Enter the time that lasagna are in the oven:")
	fmt.Scanf("%d\n", &timeInOven)

	fmt.Println("Enter the total layers you added in the lasagna:")
	fmt.Scanf("%d\n", &totalLayers)

	return timeInOven, totalLayers
}
