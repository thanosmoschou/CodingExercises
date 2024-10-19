/*
Author: Thanos Moschou
Description: The Farm exercise solution.
*/

package thefarm

import (
	"errors"
	"fmt"
)

type InvalidCowsError struct {
	numofCows int
	msg       string
}

func (e *InvalidCowsError) Error() string {
	return fmt.Sprintf("%d cows are invalid: %s", e.numofCows, e.msg)
}

func DivideFood(fd FodderCalculator, numOfCows int) (float64, error) {
	totalAmountOfFodder, err := fd.FodderAmount(numOfCows)

	if err != nil {
		return 0, err
	}

	factor, err2 := fd.FatteningFactor()

	if err2 != nil {
		return 0, err2
	}

	return totalAmountOfFodder / float64(numOfCows) * factor, nil
}

func ValidateInputAndDivideFood(fd FodderCalculator, numOfCows int) (float64, error) {
	if numOfCows > 0 {
		return DivideFood(fd, numOfCows)
	} else {
		return 0, errors.New("invalid number of cows")
	}

}

// TODO: define the 'ValidateNumberOfCows' function
func ValidateNumberOfCows(numOfCows int) error {
	if numOfCows < 0 {
		return &InvalidCowsError{
			numofCows: numOfCows,
			msg:       "there are no negative cows",
		}
	} else if numOfCows == 0 {
		return &InvalidCowsError{
			numofCows: numOfCows,
			msg:       "no cows don't need food",
		}
	} else {
		return nil
	}
}
