/*
Author: Thanos Moschou
Description: Max Number Of K-Sum Pairs solution of LeetCode 75
*/

package main

import (
	"slices"
)

func main() {

}

func maxOperations(nums []int, k int) int {
	// Sort the slice and search the part of the slice whose values are smaller than k.
	slices.Sort(nums)

	// Find the limit until where I should search in the slice.
	limit := -1
	for i := 0; i < len(nums); i++ {
		if nums[i] <= k {
			limit++
		} else {
			break
		}
	}

	/*
	   I sorted the slice so I have something like this:
	   [1, 2, 3, 4] (I had [3, 2, 1, 4])
	   Let's say that k=5

	   So I see the slice and I can say that 2 pairs add up to 5 (1 + 4 and 2 + 3)
	   Previously I sorted my array because it is possible to have values bigger than k so it is useless to take them into consideration. As a result
	   I wanna know the limit in my slice where all values are smaller than k and a pair of them can add up to k, because if a number is bigger than k
	   it is impossible to find a pair number that together add up to k (I have positive numbers). So I have to set my limits inside the slice.
	   Now let's say that startIndex = 0 and endIndex = 3
	   I can see that 1 + 4 = 5 so I increase the operations and change the pointers.

	   What if I had this:
	   [1, 2, 3, 6] and k was 5? You can see that 6 is useless so my limit will be until number 3.
	   Now 3 + 1 < 5. But I cannot increase the ending index because I may see a bigger result than k. So I need to increase the starting index.
	   If the result was bigger then if I increased the starting pointer the result would be even bigger. The same if I increased the ending index. As a result
	   I should had decreased the ending index etc.

	   This is how my code works here.
	*/

	operations := 0
	startIndex := 0
	endIndex := limit

	for startIndex < endIndex {
		result := nums[startIndex] + nums[endIndex]

		if result == k {
			operations++
			startIndex++
			endIndex--
		} else if result < k {
			startIndex++
		} else {
			endIndex--
		}
	}

	return operations
}
