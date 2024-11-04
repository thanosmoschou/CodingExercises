package main

import (
	"fmt"
	"runtime"
	"sync"
)

func main() {
	var wg sync.WaitGroup

	wg.Add(1)
	go createGoroutines(0, &wg)

	wg.Wait()
	fmt.Println("All goroutines are done.")

	fmt.Printf("GOMAXPROCS: %d\n", runtime.GOMAXPROCS(0))
	fmt.Printf("NumCPU: %d\n", runtime.NumCPU())
	fmt.Printf("NumGoroutine: %d\n", runtime.NumGoroutine())
}

func createGoroutines(id int, wg *sync.WaitGroup) {
	defer wg.Done()

	fmt.Printf("Hello I am goroutine %d...starting\n", id)

	// if id+2 < 20 {
	wg.Add(2)
	go createGoroutines(id+1, wg)
	go createGoroutines(id+2, wg)
	// }

	temp := 0
	for i := 0; i < 100000000; i++ {
		temp += i * 1000000
	} // Just to use the cpu...

	fmt.Printf("I am goroutine %d...ending\n", id)

}
