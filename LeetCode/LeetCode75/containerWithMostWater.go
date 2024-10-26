/*
Author: Thanos Moschou
Description: Container With Most Water solution from Leetcode75
*/

package main

import "math"

func main() {

}

func maxArea(height []int) int {
	maxWater := 0
	tempWater := 0
	left := 0
	right := len(height) - 1

	for left < right {
		tempWater = (right - left) * int(math.Min(float64(height[left]), float64(height[right])))
		if tempWater > maxWater {
			maxWater = tempWater
		} else if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}

	return maxWater
}
