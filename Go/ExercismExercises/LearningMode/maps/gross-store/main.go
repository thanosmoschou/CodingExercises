/*
Author: Thanos Moschou
Description: Gross Store exercise solution
*/

package main

import (
	"fmt"
	"gross-store/gross"
)

func main() {
	units := gross.Units()
	fmt.Println(units)

	bill := gross.NewBill()
	fmt.Println(bill)

	ok := gross.AddItem(bill, units, "carrot", "dozen")
	fmt.Println(ok)

	ok = gross.RemoveItem(bill, units, "carrot", "dozen")
	fmt.Println(ok)

	bill = map[string]int{"carrot": 12, "grapes": 3}
	qty, ok := gross.GetItem(bill, "carrot")
	fmt.Println(qty)
	fmt.Println(ok)
}
