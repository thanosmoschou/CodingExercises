/*
Author: Thanos Moschou
Description: Elon's Toys exercise solution.
*/

package main

import (
	"elons-toys/elon"
	"fmt"
)

func main() {
	speed := 5
	batteryDrain := 2

	car := elon.NewCar(speed, batteryDrain)
	car.Drive()
	fmt.Println(car)
	// car is now Car{speed: 5, batteryDrain: 2, battery: 98, distance: 5}

	fmt.Println(car.DisplayDistance())
	fmt.Println(car.DisplayBattery())

	trackDistance := 100
	fmt.Println(car.CanFinish(trackDistance))
	// => true
}
