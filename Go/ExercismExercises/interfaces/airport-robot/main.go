/*
Author: Thanos Moschou
Description: Airport Robot exercise solution.
*/

package main

import (
	"airport-robot/airportrobot"
	"fmt"
)

func main() {
	italianGreeter := &airportrobot.Italian{}

	portugueseGreeter := &airportrobot.Portuguese{}

	fmt.Println(airportrobot.SayHello("helen", italianGreeter))
	fmt.Println(airportrobot.SayHello("helen", portugueseGreeter))

}
