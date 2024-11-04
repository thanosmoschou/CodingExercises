/*
Author: Thanos Moschou
Description: A simple starting exercise to learn about goroutines.
*/

package main

import (
	"fmt"
	"sync"
	"time"
)

func main() {
	var wg sync.WaitGroup

	// The second call of this function will happen after the execution of the first call.
	// printNumbers()
	// printNumbers()

	for i := 0; i < 3; i++ {
		wg.Add(1)               // Add the goroutine to the wait group
		go printNumbers(i, &wg) // Create a goroutine
	}

	wg.Wait() // Wait for all goroutines to finish in order to continue the execution of main
	fmt.Println("All threads are done...")

}

func printNumbers(id int, wg *sync.WaitGroup) {
	// Call defer wg.Done() within each goroutine to ensure the counter is decremented when the goroutine finishes, even in the case of a panic.
	defer wg.Done()

	for i := 0; i < 10; i++ {
		fmt.Printf("Thread No:%d, Print:%d\n", id, i)
		time.Sleep(500 * time.Millisecond)
	}
}

/* Sequential
func printNumbers() {
	for i := 0; i < 10; i++ {
		fmt.Println(i)
	}
}
*/
