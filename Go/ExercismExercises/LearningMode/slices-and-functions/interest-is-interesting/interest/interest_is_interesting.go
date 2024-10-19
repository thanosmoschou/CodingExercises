/*
Author: Thanos Moschou
Description: Interest is Interesting exercise solution
*/

// Package interest contains some functions to calculate interest for your savings account.
package interest

// InterestRate returns the interest rate for the provided balance.
func InterestRate(balance float64) float32 {
	switch {
	case balance < 0.0:
		return 3.213
	case balance < 1000.0:
		return 0.5
	case balance < 5000.0:
		return 1.621
	default:
		return 2.475
	}
}

// Interest calculates the interest for the provided balance.
func Interest(balance float64) float64 {
	return balance * float64(InterestRate(balance)) / 100
}

// AnnualBalanceUpdate calculates the annual balance update, taking into account the interest rate.
func AnnualBalanceUpdate(balance float64) float64 {
	return balance + Interest(balance)
}

// YearsBeforeDesiredBalance calculates the minimum number of years required to reach the desired balance.
func YearsBeforeDesiredBalance(balance float64, targetBalance float64) int {
	years := 0

	for balance < targetBalance {
		years++
		balance = AnnualBalanceUpdate(balance)
	}

	return years
}
