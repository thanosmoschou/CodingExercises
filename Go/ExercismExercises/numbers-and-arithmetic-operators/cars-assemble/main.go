/*
Author: Thanos Moschou
Description: Cars Assemble exercise solution
*/

package main

import (
	"cars-assemble/cars"
	"fmt"
)

func main() {
	productionRate := 1500
	successRate := 87.0

	workingCarsPerHour := cars.CalculateWorkingCarsPerHour(productionRate, successRate)
	workingCarsPerMinute := cars.CalculateWorkingCarsPerMinute(productionRate, successRate)
	totalCost := cars.CalculateCost(productionRate)

	fmt.Println("Total working cars per hour:", workingCarsPerHour)
	fmt.Println("Total working cars per minute:", workingCarsPerMinute)
	fmt.Println("Total cost of all production:", totalCost)
}
