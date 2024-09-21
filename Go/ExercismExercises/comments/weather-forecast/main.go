/*
Author: Thanos Moschou
Description: Weather Forecast exercise solution. The main goal of this exercise is to learn how to write good documentation comments
*/

package main

import (
	"fmt"
	"weather-forecast/weather"
)

func main() {
	location := "Thessaloniki"
	currCond := "Sunny"

	forecast := weather.Forecast(location, currCond)

	fmt.Println(forecast)

}
