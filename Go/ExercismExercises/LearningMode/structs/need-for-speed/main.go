/*
Author: Thanos Moschou
Description: Need For Speed exercise solution
*/

package main

import (
	"fmt"
	"need-for-speed/speed"
)

func main() {
	carSpeed := 5
	batteryDrain := 2

	car := speed.NewCar(carSpeed, batteryDrain)
	fmt.Println(car)

	distance := 800
	track := speed.NewTrack(distance)
	fmt.Println(track)

	car = speed.Drive(car)
	fmt.Println(car)

	distance = 100
	car = speed.NewCar(carSpeed, batteryDrain)
	track = speed.NewTrack(distance)
	fmt.Println(car, track)

	fmt.Println(speed.CanFinish(car, track))

}
