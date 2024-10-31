/*
Author: Thanos Moschou
Description: Unique Number of Occurences solution from LeetCode75
*/

package main

func main() {

}

func uniqueOccurrences(arr []int) bool {
	var uniqueMap map[int]int = make(map[int]int)

	for _, value := range arr {
		_, exists := uniqueMap[value]
		if exists {
			uniqueMap[value]++
		} else {
			uniqueMap[value] = 1
		}
	}

	for key, value := range uniqueMap {
		for key2, value2 := range uniqueMap {
			if key != key2 && value == value2 {
				return false
			}
		}
	}

	return true
}
