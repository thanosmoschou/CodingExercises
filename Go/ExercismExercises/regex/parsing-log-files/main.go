/*
Author: Thanos Moschou
Description: Parsing Log Files exercise solution.
*/

package main

import (
	"fmt"
	"parsing-log-files/parsinglogfiles"
)

func main() {
	fmt.Println(parsinglogfiles.IsValidLine("[ERR] A good error here"))
	// => true
	fmt.Println(parsinglogfiles.IsValidLine("Any old [ERR] text"))
	// => false
	fmt.Println(parsinglogfiles.IsValidLine("[BOB] Any old text"))
	// => false

	fmt.Println(parsinglogfiles.SplitLogLine("section 1<*>section 2<~~~>section 3"))
	// => []string{"section 1", "section 2", "section 3"},

	fmt.Println(parsinglogfiles.SplitLogLine("section 1<=>section 2<-*~*->section 3"))

	lines := []string{
		`[INF] passWord`, // contains 'password' but not surrounded by quotation marks
		`"passWord"`,     // count this one
		`[INF] User saw error message "Unexpected Error" on page load.`,          // does not contain 'password'
		`[INF] The message "Please reset your password" was ignored by the user`, // count this one
	}

	fmt.Println(parsinglogfiles.CountQuotedPasswords(lines))
	// => 2

	fmt.Println(parsinglogfiles.RemoveEndOfLineText("[INF] end-of-line23033 Network Failure end-of-line27"))
	// => "[INF]  Network Failure "

	result := parsinglogfiles.TagWithUserName([]string{
		"[WRN] User James123 has exceeded storage space.",
		"[WRN] Host down. User   Michelle4 lost connection.",
		"[INF] Users can login again after 23:00.",
		"[DBG] We need to check that user names are at least 6 chars long.",
	})

	fmt.Println(result)
}
