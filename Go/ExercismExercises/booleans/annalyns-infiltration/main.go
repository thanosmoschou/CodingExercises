/*
Author: Thanos Moschou
Description: Annalyn's infiltration solution exercise
*/

package main

import (
	"annalyns-infiltration/annalyn"
	"fmt"
)

func main() {

	var knightIsAwake bool = true

	fmt.Println(annalyn.CanFastAttack(knightIsAwake))

	knightIsAwake = false
	var archerIsAwake = true
	var prisonerIsAwake = false

	fmt.Println(annalyn.CanSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))

	archerIsAwake = false
	prisonerIsAwake = true

	fmt.Println(annalyn.CanSignalPrisoner(archerIsAwake, prisonerIsAwake))

	knightIsAwake = false
	archerIsAwake = true
	prisonerIsAwake = false
	var petDogIsPresent = false

	fmt.Println(annalyn.CanFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
}
