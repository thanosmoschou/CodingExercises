/*
Author: Thanos Moschou
Description: A very simple program written in Go, just to learn the fundamentals of the language.
*/

package main

// package helper

import "strings"

// Here I grouped together the types of my parameters because some of them have the same type
// Also if you want a function of a package to be accessible inside other packages, you need to export the function.
// Simply capitalize the first letter
func validateUserInput(firstname, lastname, email string, userTickets uint) (bool, bool, bool) {
	// isValidName := len(firstname) >= 2 && len(lastname) >= 2
	var isValidName = len(firstname) >= 2 && len(lastname) >= 2 // len is a built-in function that can be used with arrays, slices and strings as well
	var isValidEmail = strings.Contains(email, "@")
	var isValidTicketNumber = (userTickets > 0 && userTickets < remainingTickets)
	// var isValidCity = (city == "Singapore" || city == "London")
	// isInvalidCity := (city != "Singapore" && city != "London")

	return isValidName, isValidEmail, isValidTicketNumber
}
