/*
Author: Thanos Moschou
Description: Sorting Room exercise solution
*/

package sorting

import (
	"fmt"
	"strconv"
)

// DescribeNumber should return a string describing the number.
func DescribeNumber(f float64) string {
	return fmt.Sprintf("This is the number %.1f", f)
}

type NumberBox interface {
	Number() int
}

// DescribeNumberBox should return a string describing the NumberBox.
func DescribeNumberBox(nb NumberBox) string {
	return fmt.Sprintf("This is a box containing the number %.1f", float64(nb.Number()))
}

type FancyNumber struct {
	n string
}

func NewFancyNumber(val string) FancyNumber {
	return FancyNumber{n: val}
}

type AnotherFancyNumber struct {
	n string
}

func NewAnotherFancyNumber(val string) AnotherFancyNumber {
	return AnotherFancyNumber{n: val}
}

func (i FancyNumber) Value() string {
	return i.n
}

func (i AnotherFancyNumber) Value() string {
	return i.n
}

type FancyNumberBox interface {
	Value() string
}

// ExtractFancyNumber should return the integer value for a FancyNumber
// and 0 if any other FancyNumberBox is supplied.
func ExtractFancyNumber(fnb FancyNumberBox) int {
	switch v := fnb.(type) {
	case FancyNumber:
		retVal, _ := strconv.Atoi(v.Value())
		return retVal
	default:
		return 0
	}
}

// DescribeFancyNumberBox should return a string describing the FancyNumberBox.
func DescribeFancyNumberBox(fnb FancyNumberBox) string {
	v := ExtractFancyNumber(fnb)
	return fmt.Sprintf("This is a fancy box containing the number %.1f", float64(v))
}

// DescribeAnything should return a string describing whatever it contains.
func DescribeAnything(i interface{}) string {
	switch i.(type) {
	case int:
		value := i.(int)
		return DescribeNumber(float64(value))
	case float64:
		value := i.(float64)
		return DescribeNumber(value)
	case NumberBox:
		value := i.(NumberBox)
		return DescribeNumberBox(value)
	case FancyNumberBox:
		value := i.(FancyNumberBox)
		return DescribeFancyNumberBox(value)
	default:
		return "Return to sender"
	}
}
