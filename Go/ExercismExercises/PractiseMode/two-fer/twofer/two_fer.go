/*
Author: Thanos Moschou
Description: Two Fer solution.
*/

// Package twofer contains functions to solve the exercise.
package twofer

import "fmt"

func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}

	return fmt.Sprintf("One for %s, one for me.", name)
}
