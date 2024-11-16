/*
Author: Thanos Moschou
Description: Asteroid Collision Solution of Leetcode75
*/

package main

import "math"

func main() {}

func asteroidCollision(asteroids []int) []int {
	var state []int = make([]int, len(asteroids))
	var top int = -1
	var currInd int = 0

	for currInd < len(asteroids) {
		// If I multiply 2 numbers and the result is positive, then these 2 have the same sign
		if (top < 0) || (state[top]*asteroids[currInd] > 0) || (state[top] < 0 && asteroids[currInd] > 0) {
			top++
			state[top] = asteroids[currInd]
			currInd++
		} else if math.Abs(float64(state[top])) == math.Abs(float64(asteroids[currInd])) {
			top--
			currInd++ // Check the next asteroid
		} else if math.Abs(float64(state[top])) < math.Abs(float64(asteroids[currInd])) {
			top--
		} else {
			currInd++
		}
	}

	return state[:top+1]
}
