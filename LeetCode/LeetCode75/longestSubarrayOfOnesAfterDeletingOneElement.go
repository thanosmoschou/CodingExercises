/*
Author: Thanos Moschou
Description: Longest Subarray of 1's After Deleting One Element Solution of Leetcode75
*/

package main

func main() {}

func longestSubarray(nums []int) int {
	var start int = 0
	var stop int = 0
	var del int = 1

	for stop < len(nums) {
		if nums[stop] == 0 {
			del--
		}

		if del < 0 {
			if nums[start] == 0 {
				del++
			}

			start++
		}

		stop++
	}

	return stop - start - 1
}
