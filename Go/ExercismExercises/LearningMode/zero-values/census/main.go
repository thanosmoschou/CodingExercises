/*
Author: Thanos Moschou
Description: Census exercise solution
*/

package main

import (
	"census/census"
	"fmt"
)

func main() {
	name := "Matthew Sanabria"
	age := 29
	address := map[string]string{"street": "Main St."}

	fmt.Println(census.NewResident(name, age, address))
	// => &{Matthew Sanabria 29 map[street:Main St.]}

	age = 0
	address = make(map[string]string)

	resident := census.NewResident(name, age, address)

	fmt.Println(resident.HasRequiredInfo())
	// => false

	name = "Matthew Sanabria"
	age = 29
	address = map[string]string{"street": "Main St."}

	resident = census.NewResident(name, age, address)

	fmt.Println(resident)
	// Output: &{Matthew Sanabria 29 map[street:Main St.]}

	resident.Delete()

	fmt.Println(resident)
	// Output: &{ 0 map[]}

	name1 := "Matthew Sanabria"
	age1 := 29
	address1 := map[string]string{"street": "Main St."}

	resident1 := census.NewResident(name1, age1, address1)

	name2 := "Rob Pike"
	age2 := 0
	address2 := make(map[string]string)

	resident2 := census.NewResident(name2, age2, address2)

	residents := []*census.Resident{resident1, resident2}

	fmt.Println(census.Count(residents))
	// => 1
}
