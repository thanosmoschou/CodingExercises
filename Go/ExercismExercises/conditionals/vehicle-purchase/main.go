/*
Author: Thanos Moschou
Description: Vehicle Purchase exercise solution
*/

package main

import (
	"fmt"
	"vehicle-purchase/purchase"
)

func main() {
	vehicleType1 := "car"
	vehicleType2 := "bike"
	originalPrice := 14000.0
	age := 8.5

	//model1 := "Bugatti Veyron"
	//model1 := "Ford Focus"
	model1 := "Volkswagen Beetle"
	model2 := "Volkswagen Golf"
	//model2 := "Ford Pinto"

	fmt.Printf("Does %v need license -> %v\n", vehicleType1, purchase.NeedsLicense(vehicleType1))
	fmt.Printf("Does %v need license -> %v\n", vehicleType2, purchase.NeedsLicense(vehicleType2))
	fmt.Printf("Select between %v and %v -> %v\n", model1, model2, purchase.ChooseVehicle(model1, model2))
	fmt.Printf("Original Price: %v and age: %v -> Total price of this used vehicle is: %v\n", originalPrice, age, purchase.CalculateResellPrice(originalPrice, age))

}
