/*
Author: Thanos Moschou
Description: Interest is Interesting exercise solution
*/

package main

import (
	"fmt"
	"interest-is-interesting/interest"
)

func main() {
	amount := 200.75
	fmt.Println("Interest rate:", interest.InterestRate(amount))
	fmt.Println("Interest:", interest.Interest(amount))
	fmt.Println("Annual Balance Update:", interest.AnnualBalanceUpdate(amount))

	balance := 200.75
	targetBalance := 214.88
	fmt.Printf("Years needed to reach from %v to %v: %v", balance, targetBalance, interest.YearsBeforeDesiredBalance(balance, targetBalance))
}
