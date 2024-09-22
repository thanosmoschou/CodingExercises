/*
Author: Thanos Moschou
Description: Gopher's gorgeous lasagna solution from Exercism
*/

package lasagna

import "fmt"

// This constant is also exported due to the first capitalized letter
const OvenTime int = 40

// This function is exported because the first letter is capitalized
func RemainingOvenTime(actualMinutesInOven int) int {
	if actualMinutesInOven < 0 {
		fmt.Println("Enter a valid oven time...")
		return -1
	}

	if actualMinutesInOven > OvenTime {
		fmt.Println("Overcooked...")
		return -1
	}

	return OvenTime - actualMinutesInOven
}

func PreparationTime(numberOfLayers int) int {
	var layerTime int = 2

	if numberOfLayers < 0 {
		fmt.Println("Enter a valid amount of layers...")
		return -1
	}

	return numberOfLayers * layerTime
}

func ElapsedTime(numberOfLayers int, actualMinutesInOven int) int {
	return PreparationTime(numberOfLayers) + actualMinutesInOven
}
