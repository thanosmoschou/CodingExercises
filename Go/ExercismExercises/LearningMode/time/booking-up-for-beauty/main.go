/*
Author: Thanos Moschou
Description: Booking up for Beauty exercise solution
*/

package main

import (
	"booking-up-for-beauty/booking"
	"fmt"
)

func main() {
	fmt.Println(booking.Schedule("7/25/2019 13:45:00"))
	fmt.Println(booking.Schedule("11/28/1984 2:02:02"))
	fmt.Println(booking.HasPassed("July 25, 2019 13:45:00"))
	fmt.Println(booking.HasPassed("December 9, 2112 11:59:59"))
	fmt.Println(booking.IsAfternoonAppointment("Thursday, July 25, 2019 13:45:00"))
	fmt.Println(booking.Description("7/25/2019 13:45:00"))
	fmt.Println(booking.AnniversaryDate())
}
