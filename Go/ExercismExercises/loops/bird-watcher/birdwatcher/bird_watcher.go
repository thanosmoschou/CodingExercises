/*
Author: Thanos Moschou
Description: Bird Watcher exercise solution
*/

// Package birdwatcher contains some functions for logging the birds that visited your garden.
package birdwatcher

// TotalBirdCount return the total bird count by summing
// the individual day's counts.
func TotalBirdCount(birdsPerDay []int) int {
	var total int

	for _, value := range birdsPerDay {
		total += value
	}

	return total
}

// BirdsInWeek returns the total bird count by summing
// only the items belonging to the given week.
func BirdsInWeek(birdsPerDay []int, week int) int {
	// Week out of bounds for my slice
	if week < 0 || week*7 > len(birdsPerDay) {
		return 0
	}

	// We start from week 1 so I subtract 7 days to make the weeks starting from 0
	var startingDayOfWeek int = week*7 - 7 // Taking the first day of the wanted week as an index for my slice
	var endingDayOfWeek int = startingDayOfWeek + 7

	var weekSlice []int
	weekSlice = append(weekSlice, birdsPerDay[startingDayOfWeek:endingDayOfWeek]...)

	// Just showing the different styles of variable declaration...Normally you should be consistent with your style of declaration
	totalThisWeek := TotalBirdCount(weekSlice)
	return totalThisWeek
}

// FixBirdCountLog returns the bird counts after correcting
// the bird counts for alternate days.
func FixBirdCountLog(birdsPerDay []int) []int {
	for i := 0; i < len(birdsPerDay); i += 2 {
		birdsPerDay[i]++
	}

	return birdsPerDay
}
