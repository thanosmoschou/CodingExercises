/*
Author: Thanos Moschou
Description: Find Pivot Index solution from LeetCode75
*/

package main

func main() {

}

func pivotIndex(nums []int) int {
	wholeSum := 0
	for i := 0; i < len(nums); i++ {
		wholeSum += nums[i]
	}

	leftSum := 0
	rightSum := wholeSum - nums[0]

	if leftSum == rightSum {
		return 0
	}

	for i := 1; i < len(nums); i++ {
		leftSum += nums[i-1]
		rightSum = wholeSum - leftSum - nums[i]

		if leftSum == rightSum {
			return i
		}
	}

	return -1
}
