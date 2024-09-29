/*
Author: Thanos Moschou
Description: Parsing Log Files exercise solution.
*/

// Package parsinglogfiles contains some functions that help us solve the exercise.
package parsinglogfiles

import (
	"fmt"
	"regexp"
)

// IsValidLine takes a string and returns true or false depending if it's valid or not.
func IsValidLine(text string) bool {
	re := regexp.MustCompile(`^\[(TRC|DBG|INF|WRN|ERR|FTL)\]`) // ^ tells that I have a match only if my line starts with this pattern.
	return re.MatchString(text)
}

// SplitLogLine function takes a line and returns an array of strings each of which contains a field.
func SplitLogLine(text string) []string {
	re := regexp.MustCompile(`<[*~=-]*>`)
	return re.Split(text, 10)
}

func CountQuotedPasswords(lines []string) int {
	re := regexp.MustCompile(`\".*[pP][aA][sS][sS][wW][oO][rR][dD].*\"`)
	counter := 0

	for _, value := range lines {
		if re.MatchString(value) {
			counter++
		}
	}

	return counter
}

func RemoveEndOfLineText(text string) string {
	re := regexp.MustCompile(`end-of-line\d+`)
	return re.ReplaceAllLiteralString(text, "")
}

func TagWithUserName(lines []string) []string {
	re := regexp.MustCompile(`(.*User +)([a-zA-z]+[0-9]*)(.*)`)

	for index, value := range lines {
		if match := re.FindStringSubmatch(value); match != nil {
			username := match[2] // Index 0 captures the whole regex, 1 captures the first group, 2 captures the second etc...
			lines[index] = fmt.Sprintf("[USR] %s %s", username, lines[index])
		}
	}

	return lines
}
