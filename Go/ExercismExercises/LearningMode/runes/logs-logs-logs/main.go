/*
Author: Thanos Moschou
Description: Logs, Logs, Logs exercise solution.
*/

package main

import (
	"fmt"
	"logs-logs-logs/logs"
)

func main() {
	fmt.Println(logs.Application("❗ recommended search product 🔍"))
	fmt.Println(logs.Application("executed search 🔍"))
	fmt.Println(logs.Application("error: could not proceed"))

	log := "please replace '👎' with '👍'"
	replaced := logs.Replace(log, '👎', '👍')
	fmt.Println("Old:", log)
	fmt.Println("New:", replaced)

	fmt.Println(logs.WithinLimit("hello❗", 6))
}
