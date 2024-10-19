/*
Author: Thanos Moschou
Description: Animal Magic exercise solution
*/

// Package chance contains some functions for our game.
package chance

import (
	"math/rand"
	"time"
)

// RollADie returns a random int d with 1 <= d <= 20.
func RollADie() int {
	rand.Seed(time.Now().UnixNano())
	return rand.Intn(20) + 1 // Intn(20) returns a number in range 0 <= n < 20 so I need to add 1 because I want the range of 1 <= n <= 20
}

// GenerateWandEnergy returns a random float64 f with 0.0 <= f < 12.0.
func GenerateWandEnergy() float64 {
	rand.Seed(time.Now().UnixNano())
	return rand.Float64() * 12
}

// ShuffleAnimals returns a slice with all eight animal strings in random order.
func ShuffleAnimals() []string {
	var animalSlice []string = []string{"ant", "beaver", "cat", "dog", "elephant", "fox", "giraffe", "hedgehog"}

	rand.Shuffle(len(animalSlice), func(i, j int) {
		animalSlice[i], animalSlice[j] = animalSlice[j], animalSlice[i]
	})

	return animalSlice
}
