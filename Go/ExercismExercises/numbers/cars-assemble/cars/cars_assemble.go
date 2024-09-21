/*
Author: Thanos Moschou
Description: Cars Assemble exercise solution
*/

// Package cars contains some functions to analyze the production in a car factory.
package cars

import "fmt"

// CostPerSingleCar describes how much does a single car cost to be produced, whether it is working successfully or not.
const CostPerSingleCar int = 10000

// CostPerTenCars describes how much do ten cars cost to be produced, whether they are working successfully or not.
const CostPerTenCars int = 95000

// CalculateWorkingCarsPerHour calculates how many working cars are
// produced by the assembly line every hour.
func CalculateWorkingCarsPerHour(productionRate int, successRate float64) float64 {
	if productionRate < 0 {
		fmt.Println("Enter a valid production rate...")
		return 0
	}

	if successRate < 0 {
		fmt.Println("Enter a valid success rate...")
		return 0
	}

	return float64(productionRate) * successRate / 100
}

// CalculateWorkingCarsPerMinute calculates how many working cars are
// produced by the assembly line every minute.
func CalculateWorkingCarsPerMinute(productionRate int, successRate float64) int {
	if productionRate < 0 {
		fmt.Println("Enter a valid production rate...")
		return 0
	}

	if successRate < 0 {
		fmt.Println("Enter a valid success rate...")
		return 0
	}

	return int(CalculateWorkingCarsPerHour(productionRate, successRate) / 60)
}

// CalculateCost works out the cost of producing the given number of cars.
func CalculateCost(carsCount int) uint {
	if carsCount < 0 {
		fmt.Println("Enter a valid amount of cars...")
		return 0
	}

	return uint((carsCount/10)*CostPerTenCars + (carsCount%10)*CostPerSingleCar)
}
