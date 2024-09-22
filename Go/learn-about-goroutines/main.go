/*
Author: Thanos Moschou
Description: Learn about goroutines. Based on this tutorial: https://www.youtube.com/watch?v=qcvXQITylXs
*/

package main

import (
	"errors"
	"fmt"
	"math/rand"
	"sync"
	"time"
)

func main() {

	var wg sync.WaitGroup

	rand.Seed(time.Now().Unix())

	wg.Add(1)
	go hello(&wg)

	wg.Add(1)
	go bye(&wg)

	wg.Wait()
}

func hello(wg *sync.WaitGroup) {
	defer wg.Done() // The defer goes at the beginning of the function (good practise)

	var res float64
	var err error

	res, err = div(3, 0)

	if err != nil {
		return
	}

	var dur int = rand.Intn(1000)
	time.Sleep(time.Duration(dur) * time.Millisecond)

	fmt.Println("Hello Thanos", res)
}

func bye(wg *sync.WaitGroup) {
	defer wg.Done()

	var dur int = rand.Intn(1000)
	time.Sleep(time.Duration(dur) * time.Millisecond)

	fmt.Println("Goodbye Thanos")
}

func div(a float64, b float64) (float64, error) {
	if b == 0 {
		return -1, errors.New("Division by 0")
	}

	return a / b, nil
}
