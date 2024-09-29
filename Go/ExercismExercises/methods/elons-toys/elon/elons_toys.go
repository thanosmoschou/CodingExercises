/*
Author: Thanos Moschou
Description: Elon's Toys exercise solution.
*/

// Package elon contains some useful functions and types for the exercise.
package elon

import "fmt"

// Drive method on the Car that updates the number of meters driven based on the car's speed,
// and reduces the battery according to the battery drainage.
func (car *Car) Drive() {
	if car.battery-car.batteryDrain >= 0 {
		car.distance += car.speed
		car.battery -= car.batteryDrain
	}
}

// DisplayDistance method on Car to return the distance as displayed on the LED display as a string.
func (car *Car) DisplayDistance() string {
	return fmt.Sprintf("Driven %d meters", car.distance)
}

// DisplayBattery method on Car to return the battery percentage as displayed on the LED display as a string.
func (car *Car) DisplayBattery() string {
	return fmt.Sprintf("Battery at %d%%", car.battery)
}

// CanFinish method that takes a trackDistance int as its parameter and returns true if the car can finish the race;
// otherwise, return false.
func (car *Car) CanFinish(trackDistance int) bool {
	timesCanBeDriven := car.battery / car.batteryDrain
	totalDistance := timesCanBeDriven * car.speed

	return totalDistance >= trackDistance
}
