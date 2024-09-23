/*
Author: Thanos Moschou
Description: Need For Speed exercise solution
*/

// Package speed contains some useful functions to check if your RC car can complete its race.
package speed

type Car struct {
	battery      int
	batteryDrain int
	speed        int
	distance     int
}

type Track struct {
	distance int
}

// NewCar creates a new remote controlled car with full battery and given specifications.
func NewCar(speed int, batteryDrain int) Car {
	return Car{
		battery:      100,
		batteryDrain: batteryDrain,
		speed:        speed,
		distance:     0,
	}
}

// NewTrack creates a new track
func NewTrack(distance int) Track {
	return Track{
		distance: distance,
	}
}

// Drive drives the car one time. If there is not enough battery to drive one more time,
// the car will not move.
func Drive(car Car) Car {
	if car.battery-car.batteryDrain >= 0 {
		car.battery -= car.batteryDrain
		car.distance += car.speed
	}

	return car
}

// CanFinish checks if a car is able to finish a certain track.
func CanFinish(car Car, track Track) bool {
	timesCanBeDriven := car.battery / car.batteryDrain
	totalDistanceItCanDrive := timesCanBeDriven * car.speed

	return totalDistanceItCanDrive >= track.distance
}
