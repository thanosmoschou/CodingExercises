/*
Author: Thanos Moschou
Description: Find The Highest Altitude solution from LeetCode 75
*/

package main

func main() {

}

func largestAltitude(gain []int) int {
	var altitudes []int = make([]int, len(gain)+1)

	//altitudes[0] is 0 from the initialization

	for i := 0; i < len(gain); i++ {
		altitudes[i+1] = altitudes[i] + gain[i]
	}

	max := altitudes[0]
	for i := 1; i < len(altitudes); i++ {
		if altitudes[i] > max {
			max = altitudes[i]
		}
	}

	return max
}
