/*
Author: Thanos Moschou
Description: Maximum Number Of Vowels In A Substring Of Given Length solution of Leetcode 75
*/

package main

func main() {

}

func maxVowels(s string, k int) int {
	max := 0
	temp := 0

	for i := 0; i < k; i++ {
		switch s[i] {
		case 'a', 'e', 'i', 'o', 'u':
			max++
		}
	}

	temp = max
	for i := 1; i < len(s)-1; i++ {

		if i+k > len(s) {
			break
		}

		if isVowel(s[i-1]) && isVowel(s[i+k-1]) {
			continue
		} else if isVowel(s[i-1]) && !isVowel(s[i+k-1]) {
			temp--
		} else if !isVowel(s[i-1]) && isVowel(s[i+k-1]) {
			temp++
		}

		if temp > max {
			max = temp
		}
	}

	return max
}

func isVowel(c byte) bool {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}
