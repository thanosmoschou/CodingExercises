/*
Author: Thanos Moschou
Description: Gross Store exercise solution
*/

// Package gross contains some functions that help you solve the exercise.
package gross

// Units stores the Gross Store unit measurements.
func Units() map[string]int {
	return map[string]int{
		"quarter_of_a_dozen": 3,
		"half_of_a_dozen":    6,
		"dozen":              12,
		"small_gross":        120,
		"gross":              144,
		"great_gross":        1728,
	}
}

// NewBill creates a new bill.
func NewBill() map[string]int {
	return make(map[string]int) // I show a different way of creating an empty map
}

// AddItem adds an item to customer bill.
func AddItem(bill map[string]int, units map[string]int, item string, unit string) bool {
	// Check if the unit is not in the units map.
	_, exists := units[unit]
	if !exists {
		return false
	}

	// Check if the item is already in the bill so I can just increase its value, or if it's not to add it.
	_, exists = bill[item]
	if exists {
		bill[item] += units[unit]
	} else {
		bill[item] = units[unit]
	}

	return true
}

// RemoveItem removes an item from customer bill.
func RemoveItem(bill map[string]int, units map[string]int, item string, unit string) bool {
	// Check if the unit exists in units map.
	_, exists := units[unit]
	if !exists {
		return false
	}

	// Check if the given item is not in the bill
	_, exists = bill[item]
	if !exists {
		return false
	}

	// Modify the quantity or remove the item completely from the bill map.
	newValue := bill[item] - units[unit]
	if newValue < 0 {
		return false
	} else if newValue == 0 {
		delete(bill, item)
		return true
	} else {
		bill[item] = newValue
		return true
	}
}

// GetItem returns the quantity of an item that the customer has in his/her bill.
func GetItem(bill map[string]int, item string) (int, bool) {
	// Check if the item is not in the bill.
	value, exists := bill[item]
	return value, exists
}
