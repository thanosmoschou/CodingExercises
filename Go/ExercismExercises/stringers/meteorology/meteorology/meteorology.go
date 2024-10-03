/*
Author: Thanos Moschou
Description: Meteorology exercise solution.
*/

// Package meteorology contains some usefult tools for our meteorology application.
package meteorology

import "fmt"

type TemperatureUnit int

const (
	Celsius    TemperatureUnit = 0
	Fahrenheit TemperatureUnit = 1
)

func (tu TemperatureUnit) String() string {
	units := []string{"°C", "°F"}
	return units[tu]
}

type Temperature struct {
	degree int
	unit   TemperatureUnit
}

func NewTemperature(degree int, unit TemperatureUnit) Temperature {
	return Temperature{
		degree: degree,
		unit:   unit,
	}
}

func (temper Temperature) String() string {
	return fmt.Sprintf("%v %v", temper.degree, temper.unit)
}

type SpeedUnit int

const (
	KmPerHour    SpeedUnit = 0
	MilesPerHour SpeedUnit = 1
)

func (su SpeedUnit) String() string {
	units := []string{"km/h", "mph"}
	return units[su]
}

type Speed struct {
	magnitude int
	unit      SpeedUnit
}

func NewSpeed(magnitude int, unit SpeedUnit) Speed {
	return Speed{
		magnitude: magnitude,
		unit:      unit,
	}
}

func (sp Speed) String() string {
	return fmt.Sprintf("%v %v", sp.magnitude, sp.unit)
}

type MeteorologyData struct {
	location      string
	temperature   Temperature
	windDirection string
	windSpeed     Speed
	humidity      int
}

func NewMeteorologyData(location string, temperature Temperature, windDirection string, windSpeed Speed, humidity int) MeteorologyData {
	return MeteorologyData{
		location:      location,
		temperature:   temperature,
		windDirection: windDirection,
		windSpeed:     windSpeed,
		humidity:      humidity,
	}
}

func (md MeteorologyData) String() string {
	return fmt.Sprintf("%v: %v, Wind %v at %v, %v%% Humidity", md.location, md.temperature, md.windDirection, md.windSpeed, md.humidity)
}
