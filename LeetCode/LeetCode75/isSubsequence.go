/*
Author: Thanos Moschou
Description: Is Subsequence solution of Leetcode 75
*/

package main

func main() {

}

func isSubsequence(s string, t string) bool {
	sIndex := 0

	for _, tChar := range t {
		if sIndex < len(s) && tChar == rune(s[sIndex]) {
			sIndex++
		}
	}

	return sIndex == len(s)
}
