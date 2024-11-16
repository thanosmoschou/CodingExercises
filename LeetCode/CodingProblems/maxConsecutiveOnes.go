/*
Author: Thanos Moschou
Description: Most Consecutive Ones LeetCode Coding Problem Solution
*/

package main

func main() {

}

func findMaxConsecutiveOnes(nums []int) int {
	maxConsec := 0
	tempConsec := 0

	for i := 0; i < len(nums); i++ {
		if nums[i] == 1 {
			tempConsec++
		} else {
			if tempConsec > maxConsec {
				maxConsec = tempConsec
			}

			tempConsec = 0
		}
	}

	if tempConsec > maxConsec {
		maxConsec = tempConsec
	}

	return maxConsec
}
