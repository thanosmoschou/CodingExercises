package main

import (
	"fmt"
	"sync"
)

func main() {
	var wg sync.WaitGroup

	for i := 0; i < 10; i++ {
		wg.Add(1)
		go printGoroutine1(&wg)
	}

	for i := 0; i < 10; i++ {
		wg.Add(1)
		go printGoroutine2(&wg)
	}

	wg.Wait()
	fmt.Println("All goroutines are done.")
}

func printGoroutine1(wg *sync.WaitGroup) {
	defer wg.Done()
	fmt.Println("Goroutine 1")
}

func printGoroutine2(wg *sync.WaitGroup) {
	defer wg.Done()
	fmt.Println("Goroutine 2")
}
