/*
Author: Thanos Moschou
Description: Bird Watcher exercise solution
*/

package main

import (
	"bird-watcher/birdwatcher"
	"fmt"
)

func main() {
	birdsPerDay := []int{1, 2, 0, 5, 6, 10, 9}
	fmt.Println("Total birds per day:", birdwatcher.TotalBirdCount(birdsPerDay))

	birdsPerDay = []int{1, 2, 0, 5, 6, 10, 9, 10, 4, 0, 0, 4, 2, 1, 0, 9, 3, 4, 1, 9, 0}
	fmt.Println("Total birds for your specific week:", birdwatcher.BirdsInWeek(birdsPerDay, 3))

	birdsPerDay = []int{2, 5, 0, 7, 4, 1}
	fmt.Println(birdwatcher.FixBirdCountLog(birdsPerDay))
}
