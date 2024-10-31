/*
Author: Thanos Moschou
Description: Find The Difference Of Two Arrays solution from LeetCode75
*/

package main

func main() {

}

func findDifference(nums1 []int, nums2 []int) [][]int {
	var firstMap map[int]int = make(map[int]int)
	var secondMap map[int]int = make(map[int]int)

	for _, value := range nums1 {
		firstMap[value]++
	}

	for _, value := range nums2 {
		secondMap[value]++
	}

	var list1 []int = make([]int, 0)
	var list2 []int = make([]int, 0)

	for key, _ := range firstMap {
		_, exists := secondMap[key]
		if !exists {
			list1 = append(list1, key)
		}
	}

	for key, _ := range secondMap {
		_, exists := firstMap[key]
		if !exists {
			list2 = append(list2, key)
		}
	}

	return [][]int{list1, list2}
}
