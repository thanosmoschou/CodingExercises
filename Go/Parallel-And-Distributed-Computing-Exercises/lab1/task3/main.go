package main

import (
	"fmt"
	"sync"
)

func main() {
	var wg sync.WaitGroup

	for i := 0; i < 4; i++ {
		wg.Add(1)
		go printNums(i, &wg)
	}

	wg.Wait()
	fmt.Println("All goroutines are done.")
}

func printNums(id int, wg *sync.WaitGroup) {
	defer wg.Done()

	for i := 1; i <= 20; i++ {
		fmt.Printf("%d*%d=%d\n", i, id+1, i*(id+1))
	}
}
