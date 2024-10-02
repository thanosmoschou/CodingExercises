/*
Author: Thanos Moschou
Description: Airport Robot exercise solution.
*/

// Package airportrobot contains some useful tools for
// implementing the airport's functionality.
package airportrobot

import (
	"fmt"
)

// Greeter is an interface that contains some
// method signatures for our robots.
type Greeter interface {
	LanguageName() string
	Greet(visitorsName string) string
}

type Italian struct{}

type Portuguese struct{}

func (r Italian) LanguageName() string {
	return "Italian"
}

func (r Portuguese) LanguageName() string {
	return "Portuguese"
}

func (r Italian) Greet(visitorsName string) string {
	return fmt.Sprintf("%s %s!", "Ciao", visitorsName)
}

func (r Portuguese) Greet(visitorsName string) string {
	return fmt.Sprintf("%s %s!", "Olá", visitorsName)
}

// SayHello greets a user in his language.
func SayHello(visitorsName string, greeter Greeter) string {
	return fmt.Sprintf("I can speak %s: %s", greeter.LanguageName(), greeter.Greet(visitorsName))
}
