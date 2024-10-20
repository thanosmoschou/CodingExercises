/*
Author: Thanos Moschou
Description: Maximum Average Of Subarray 1 solution of Leetcode 75
*/

package main

func main() {

}

func findMaxAverage(nums []int, k int) float64 {
	maxValue := 0

	for i := 0; i < k; i++ {
		maxValue += nums[i]
	}

	temp := maxValue
	for i := 1; i < len(nums)-1; i++ {
		if i+k > len(nums) {
			break
		}

		temp = temp - nums[i-1] + nums[i+k-1]
		if temp > maxValue {
			maxValue = temp
		}
	}

	return float64(maxValue) / float64(k)
}
