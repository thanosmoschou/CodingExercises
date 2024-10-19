/*
Author: Thanos Moschou
Description: Sorting Room exercise solution
*/

package main

import (
	"fmt"
	"sorting-room/sorting"
)

func main() {
	fmt.Println(sorting.DescribeNumber(-12.345))
	// Output: This is the number -12.3

	fmt.Println(sorting.ExtractFancyNumber(sorting.NewFancyNumber("10")))
	// Output: 10
	fmt.Println(sorting.ExtractFancyNumber(sorting.NewAnotherFancyNumber("4")))
	// Output: 0

	fmt.Println(sorting.DescribeFancyNumberBox(sorting.NewFancyNumber("10")))
	// Output: This is a fancy box containing the number 10.0
	fmt.Println(sorting.DescribeFancyNumberBox(sorting.NewAnotherFancyNumber("4")))
	// Output: This is a fancy box containing the number 0.0

	fmt.Println(sorting.DescribeAnything(12.345))
	// Output: This is a box containing the number 12.3
	fmt.Println(sorting.DescribeAnything("some string"))
	// Output: Return to sender
}
