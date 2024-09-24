/*
Author: Thanos Moschou
Description: Booking up for Beauty exercise solution
*/

// Package booking contains functions that solve the exercise
package booking

import (
	"fmt"
	"strings"
	"time"
)

// Schedule returns a time.Time from a string containing a date.
func Schedule(date string) time.Time {
	var layout string = "1/2/2006 15:04:05" // 05 to include seconds also

	t, error := time.Parse(layout, date)
	fmt.Println(error)

	return t
}

// HasPassed returns whether a date has passed.
func HasPassed(date string) bool {
	/*
		The layout "January 2, 2006 15:04:05" accepts both single-digit
		and double-digit representations for the day:

		Single-Digit Numbers: It can accept "January 2, 2006 15:04:05"
		(where the day is 2).
		Double-Digit Numbers: It can also accept "January 02, 2006 15:04:05"
		(where the day is 02).

		Flexibility: This layout allows for flexibility in input,
		making it compatible with both single-digit and
		double-digit numbers for the day.
	*/
	var layout string = "January 2, 2006 15:04:05"

	appointment, error := time.Parse(layout, date)
	fmt.Println(error)

	return appointment.Before(time.Now())
}

// IsAfternoonAppointment returns whether a time is in the afternoon.
func IsAfternoonAppointment(date string) bool {
	var layout string = "Monday, January 2, 2006 15:04:05"

	appointment, error := time.Parse(layout, date)
	appointmentTime := appointment.Hour()
	fmt.Println(error)

	return appointmentTime >= 12 && appointmentTime < 18
}

// Description returns a formatted string of the appointment time.
func Description(date string) string {
	var layout string = "1/2/2006 15:04:05"

	t, error := time.Parse(layout, date)
	fmt.Println(error)
	formattedTime := t.Format("Monday, January 2, 2006, 15:04")

	splitted := strings.Split(formattedTime, ",")
	msg := "You have an appointment on " + splitted[0] + "," + splitted[1] + "," + splitted[2] + ", at" + splitted[3] + "."

	return msg
}

// AnniversaryDate returns a Time with this year's anniversary.
func AnniversaryDate() time.Time {
	return time.Date(time.Now().Year(), time.September, 15, 0, 0, 0, 0, time.UTC)
}
