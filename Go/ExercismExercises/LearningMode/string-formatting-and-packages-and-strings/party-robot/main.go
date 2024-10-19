/*
Author: Thanos Moschou
Description: Party Robot solution exercise
*/

package main

import (
	"fmt"
	"party-robot/partyrobot"
)

func main() {
	name := "Thanos"
	age := 22

	fmt.Println(partyrobot.Welcome(name))
	fmt.Println(partyrobot.HappyBirthday(name, age))

	table := 12
	neighbour := "George"
	direction := "on the right"
	distance := 23.42

	fmt.Println(partyrobot.AssignTable(name, table, neighbour, direction, distance))
}
