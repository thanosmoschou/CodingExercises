/*
Author: Thanos Moschou
Description: Lasagna Master exercise solution
*/

// Package lasagna contains some useful code for lasagna preparation.
package lasagna

// PreparationTime gets the total amount of lasagna's layers and the average preparation time per layer
// and calculates the total preparation time.
func PreparationTime(layers []string, avgTimePerLayer int) int {
	if avgTimePerLayer == 0 {
		avgTimePerLayer = 2 // avgTimePerLayer is a parameter but it works like a local variable (it receives a copy of the original value for my case) so I can change its value
	}

	return len(layers) * avgTimePerLayer
}

// Quantities gets the slice with layers and calculates the amount of noodles
// and sauce needed.
func Quantities(layers []string) (int, float64) {
	noodlesCtr := 0
	sauceCtr := 0

	for _, value := range layers {
		if value == "sauce" {
			sauceCtr++
		} else if value == "noodles" { // Lasagna can also have layers with other toppings so that's why I do not put an else section.
			noodlesCtr++
		}
	}

	return noodlesCtr * 50, float64(sauceCtr) * 0.2
}

// AddSecretIngredient gets 2 slices with ingredients and replaces the last ingredient of the second slice, with the
// last ingredient of the first slice.
func AddSecretIngredient(friendsSlice []string, yoursSlice []string) {
	yoursSlice[len(yoursSlice)-1] = friendsSlice[len(friendsSlice)-1]
}

// ScaleRecipe gets a slice with the amounts needed for 2 portions and the number of wanted portions
// and calculates the amount of wanted portions.
func ScaleRecipe(givenAmounts []float64, wantedPortions int) []float64 {
	if wantedPortions < 0 {
		return givenAmounts
	}

	wantedAmounts := []float64{}
	wantedAmounts = append(wantedAmounts, givenAmounts...)

	for i := 0; i < len(givenAmounts); i++ {
		wantedAmounts[i] *= float64(wantedPortions) / float64(2)
	}

	return wantedAmounts
}
