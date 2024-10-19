/*
Author: Thanos Moschou
Description: Raindrops solution.
*/

// Package raindrops contains my function.
package raindrops

import "strconv"

// Convert solves the exercise.
func Convert(number int) string {
	msg := ""

	if number%3 == 0 {
		msg += "Pling"
	}

	if number%5 == 0 {
		msg += "Plang"
	}

	if number%7 == 0 {
		msg += "Plong"
	}

	if msg == "" {
		msg = strconv.Itoa(number)
	}

	return msg
}
