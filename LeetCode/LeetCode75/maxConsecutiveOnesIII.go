/*
Author: Thanos Moschou
Description: Max Consecutive Ones III Solution of LeetCode75
*/

package main

func main() {

}

func longestOnes(nums []int, k int) int {
	var start int = 0
	var stop int = 0
	var remFlip int = k

	for stop < len(nums) {
		if nums[stop] == 0 {
			remFlip--
		}

		if remFlip < 0 {
			if nums[start] == 0 {
				remFlip++
			}

			start++
		}

		stop++
	}

	return stop - start
}
