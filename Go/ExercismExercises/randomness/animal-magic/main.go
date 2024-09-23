/*
Author: Thanos Moschou
Description: Animal Magic exercise solution
*/

package main

import (
	"animal-magic/chance"
	"fmt"
)

func main() {
	d := chance.RollADie()
	fmt.Println(d)

	f := chance.GenerateWandEnergy()
	fmt.Println(f)

	fmt.Println(chance.ShuffleAnimals())
	fmt.Println(chance.ShuffleAnimals())
	fmt.Println(chance.ShuffleAnimals())
	fmt.Println(chance.ShuffleAnimals())

}
