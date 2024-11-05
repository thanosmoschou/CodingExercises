/*
Author: Thanos Moschou
Description: Removing Stars From A String solution from LeetCode75
*/

package main

func main() {

}

func removeStars(s string) string {
	var stack []rune = make([]rune, 0)
	var top int = 0

	for _, value := range s {
		if value != '*' {
			stack = append(stack, value)
			top++
		} else {
			stack = stack[:top-1]
			top--
		}
	}

	return string(stack)

}
