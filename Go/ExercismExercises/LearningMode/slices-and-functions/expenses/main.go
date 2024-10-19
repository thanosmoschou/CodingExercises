/*
Author: Thanos Moschou
Description: Expenses exercise solution
*/

package main

import (
	"expenses/expenses"
	"fmt"
)

func main() {
	records := []expenses.Record{
		{Day: 1, Amount: 15, Category: "groceries"},
		{Day: 11, Amount: 300, Category: "utility-bills"},
		{Day: 12, Amount: 28, Category: "groceries"},
	}

	// Day1Records only returns true for records that are from day 1
	Day1Records := func(r expenses.Record) bool {
		return r.Day == 1
	}

	newRecords := expenses.Filter(records, Day1Records)
	// =>
	// [
	//   {Day: 1, Amount: 15, Category: "groceries"}
	// ]
	fmt.Println(newRecords)

	records = []expenses.Record{
		{Day: 1, Amount: 15, Category: "groceries"},
		{Day: 11, Amount: 300, Category: "utility-bills"},
		{Day: 12, Amount: 28, Category: "groceries"},
		{Day: 26, Amount: 300, Category: "university"},
		{Day: 28, Amount: 1300, Category: "rent"},
	}

	period := expenses.DaysPeriod{From: 1, To: 15}

	newRecords = expenses.Filter(records, expenses.ByDaysPeriod(period))
	// =>
	// [
	//   {Day: 1, Amount: 15, Category: "groceries"},
	//   {Day: 11, Amount: 300, Category: "utility-bills"},
	//   {Day: 12, Amount: 28, Category: "groceries"},
	// ]
	fmt.Println(newRecords)

	records = []expenses.Record{
		{Day: 1, Amount: 15, Category: "groceries"},
		{Day: 11, Amount: 300, Category: "utility-bills"},
		{Day: 12, Amount: 28, Category: "groceries"},
		{Day: 28, Amount: 1300, Category: "rent"},
	}

	newRecords = expenses.Filter(records, expenses.ByCategory("groceries"))
	// =>
	// [
	//   {Day: 1, Amount: 15, Category: "groceries"},
	//   {Day: 12, Amount: 28, Category: "groceries"},
	// ]
	fmt.Println(newRecords)

	records = []expenses.Record{
		{Day: 15, Amount: 16, Category: "entertainment"},
		{Day: 32, Amount: 20, Category: "groceries"},
		{Day: 40, Amount: 30, Category: "entertainment"},
	}

	p1 := expenses.DaysPeriod{From: 1, To: 30}
	p2 := expenses.DaysPeriod{From: 31, To: 60}

	fmt.Println(expenses.TotalByPeriod(records, p1))
	// => 16

	fmt.Println(expenses.TotalByPeriod(records, p2))
	// => 50

	p1 = expenses.DaysPeriod{From: 1, To: 30}
	p2 = expenses.DaysPeriod{From: 31, To: 60}

	records = []expenses.Record{
		{Day: 1, Amount: 15, Category: "groceries"},
		{Day: 11, Amount: 300, Category: "utility-bills"},
		{Day: 12, Amount: 28, Category: "groceries"},
		{Day: 26, Amount: 300, Category: "university"},
		{Day: 28, Amount: 1300, Category: "rent"},
	}

	fmt.Println(expenses.CategoryExpenses(records, p1, "entertainment"))
	// => 0, error(unknown category entertainment)

	fmt.Println(expenses.CategoryExpenses(records, p1, "rent"))
	// => 1300, nil

	fmt.Println(expenses.CategoryExpenses(records, p2, "rent"))
	// => 0, nil
}
