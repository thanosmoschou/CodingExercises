/*
Author: Thanos Moschou
Description: Party Robot solution exercise
*/

// Package partyrobot contains some functions useful for the party.
package partyrobot

import "fmt"

// Welcome greets a person by name.
func Welcome(name string) string {
	return fmt.Sprintf("Welcome to my party, %s!", name)
}

// HappyBirthday wishes happy birthday to the birthday person and exclaims their age.
func HappyBirthday(name string, age int) string {
	return fmt.Sprintf("Happy birthday %s! You are now %d years old!", name, age)
}

// AssignTable assigns a table to each guest.
func AssignTable(name string, table int, neighbour string, direction string, distance float64) string {
	// %03d means print a decimal number with 3 digits of format and if the number is smaller than 3 digits, add leading 0's to become 3 digits.
	// %.1f means print a floating point number with 1 digit of precision.
	return fmt.Sprintf("Welcome to my party, %s!\nYou have been assigned to table %03d. Your table is %s, exactly %.1f meters from here.\nYou will be sitting next to %s.", name, table, direction, distance, neighbour)
}
