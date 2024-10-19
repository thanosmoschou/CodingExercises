/*
Author: Thanos Moschou
Description: Weather Forecast exercise solution. The main goal of this exercise is to learn how to write good documentation comments
*/

// Package weather contains some functions to get informed about the weather forecast.
package weather

// CurrentCondition represents the weather condition of your location.
var CurrentCondition string

// CurrentLocation represents your location.
var CurrentLocation string

// Forecast returns a string with your location and its current weather condition.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
