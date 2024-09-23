/*
Author: Thanos Moschou
Description: Lasagna Master exercise solution
*/

package main

import (
	"fmt"
	"lasagna-master/lasagna"
)

func main() {
	layers := []string{"sauce", "noodles", "sauce", "meat", "mozzarella", "noodles"}

	fmt.Println("Preparation Time:", lasagna.PreparationTime(layers, 4))
	fmt.Println("Preparation Time:", lasagna.PreparationTime(layers, 0)) // 0 acts like a default initial value but Go doesn't support default values

	noodlesAmount, sauceAmount := lasagna.Quantities(layers)

	fmt.Printf("Noodles needed: %v, Sauce needed: %v\n", noodlesAmount, sauceAmount)

	friendsList := []string{"noodles", "sauce", "mozzarella", "kampot pepper"}
	myList := []string{"noodles", "meat", "sauce", "mozzarella", "?"}

	lasagna.AddSecretIngredient(friendsList, myList)
	fmt.Println(myList)

	//quantities := []float64{1.2, 3.6, 10.5}
	//quantities := []float64{0.5, 250, 150, 3, 0.5}
	quantities := []float64{0.6, 300, 1, 0.5, 50, 0.1, 100}
	scaledQuantities := lasagna.ScaleRecipe(quantities, 3)

	fmt.Println(quantities)
	fmt.Println(scaledQuantities)

}
