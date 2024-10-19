/*
Author: Thanos Moschou
Description: Expenses exercise solution
*/

// Package expenses contains some functions that solve the exercise.
package expenses

import "errors"

// Record represents an expense record.
type Record struct {
	Day      int
	Amount   float64
	Category string
}

// DaysPeriod represents a period of days for expenses.
type DaysPeriod struct {
	From int
	To   int
}

// Filter returns the records for which the predicate function returns true.
func Filter(in []Record, predicate func(Record) bool) []Record {
	var copyOfRecords []Record = make([]Record, 0)

	for _, value := range in {
		if predicate(value) {
			copyOfRecords = append(copyOfRecords, value)
		}
	}

	return copyOfRecords
}

// ByDaysPeriod returns predicate function that returns true when
// the day of the record is inside the period of day and false otherwise.
func ByDaysPeriod(p DaysPeriod) func(Record) bool {
	return func(r Record) bool {
		return r.Day >= p.From && r.Day <= p.To
	}
}

// ByCategory returns predicate function that returns true when
// the category of the record is the same as the provided category
// and false otherwise.
func ByCategory(c string) func(Record) bool {
	return func(r Record) bool {
		return c == r.Category
	}
}

// TotalByPeriod returns total amount of expenses for records
// inside the period p.
func TotalByPeriod(in []Record, p DaysPeriod) float64 {
	total := 0.0

	for _, value := range in {
		if value.Day >= p.From && value.Day <= p.To {
			total += float64(value.Amount)
		}
	}

	return total
}

// CategoryExpenses returns total amount of expenses for records
// in category c that are also inside the period p.
// An error must be returned only if there are no records in the list that belong
// to the given category, regardless of period of time.
func CategoryExpenses(in []Record, p DaysPeriod, c string) (float64, error) {
	total := 0.0

	filtered := Filter(in, ByCategory(c))
	if len(filtered) == 0 {
		return total, errors.New("unknown category")
	}

	total = TotalByPeriod(filtered, p)
	return total, nil
}
