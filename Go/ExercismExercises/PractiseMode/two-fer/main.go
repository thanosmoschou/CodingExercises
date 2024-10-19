/*
Author: Thanos Moschou
Description: Two Fer solution.
*/

package main

import (
	"fmt"
	"two-fer/twofer"
)

func main() {
	fmt.Println(twofer.ShareWith(""))
	fmt.Println(twofer.ShareWith("Thanos"))
}
