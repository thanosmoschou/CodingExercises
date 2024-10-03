/*
Author: Thanos Moschou
Description: Meteorology exercise solution.
*/

package main

import (
	"fmt"
	"meteorology/meteorology"
)

func main() {
	celsiusUnit := meteorology.Celsius
	fahrenheitUnit := meteorology.Fahrenheit

	fmt.Println(celsiusUnit.String())
	// => °C
	fmt.Println(fahrenheitUnit.String())
	// => °F
	fmt.Println(celsiusUnit) // fmt calls the String method on the celciusUnit type
	// Output: °C

	celsiusTemp := meteorology.NewTemperature(21, meteorology.Celsius)
	fmt.Println(celsiusTemp.String())
	// => 21 °C
	fmt.Println(celsiusTemp)
	// Output: 21 °C

	fahrenheitTemp := meteorology.NewTemperature(75, meteorology.Fahrenheit)
	fmt.Println(fahrenheitTemp.String())
	// => 75 °F
	fmt.Println(fahrenheitTemp)
	// Output: 75 °F

	mphUnit := meteorology.MilesPerHour
	fmt.Println(mphUnit.String())
	// => mph
	fmt.Println(mphUnit)
	// Output: mph

	kmhUnit := meteorology.KmPerHour
	fmt.Println(kmhUnit.String())
	// => km/h
	fmt.Println(kmhUnit)
	// Output: km/h

	windSpeedNow := meteorology.NewSpeed(18, meteorology.KmPerHour)
	fmt.Println(windSpeedNow.String())
	// => 18 km/h
	fmt.Println(windSpeedNow)
	// Output: 18 km/h

	windSpeedYesterday := meteorology.NewSpeed(22, meteorology.MilesPerHour)
	fmt.Println(windSpeedYesterday.String())
	// => 22 mph
	fmt.Println(windSpeedYesterday)
	// Output: 22 mph

	sfData := meteorology.NewMeteorologyData("San Francisco", meteorology.NewTemperature(57, meteorology.Fahrenheit),
		"NW",
		meteorology.NewSpeed(19, meteorology.MilesPerHour),
		60,
	)

	fmt.Println(sfData.String())
	// => San Francisco: 57 °F, Wind NW at 19 mph, 60% Humidity
	fmt.Println(sfData)
	// Output: San Francisco: 57 °F, Wind NW at 19 mph, 60% Humidity
}
