package main

import (
	"fmt"
	"runtime"
	"sync"
	"time"
)

func main() {

	var wg sync.WaitGroup

	rows, cols := 10000, 10000

	a := make([][]int, rows)
	b := make([][]int, rows)
	c := make([][]int, rows)

	for i := 0; i < rows; i++ {
		a[i] = make([]int, cols)
		b[i] = make([]int, cols)
		c[i] = make([]int, cols)
	}

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			a[i][j] = 1
			b[i][j] = 1
			c[i][j] = 0
		}
	}

	startTime := time.Now().UnixMilli()

	/*
		// 300ms
		for i := 0; i < rows; i++ {
			for j := 0; j < cols; j++ {
				c[i][j] = a[i][j] + b[i][j]
			}
		}
	*/

	var totGoroutines = runtime.NumCPU()

	// 150ms
	for i := 0; i < totGoroutines; i++ {
		wg.Add(1)
		go add(i, rows, totGoroutines, cols, a, b, c, &wg)
	}

	wg.Wait()

	ellapsedTime := time.Now().UnixMilli() - startTime

	/*
		fmt.Printf("Print array:\n")
		for i := 0; i < rows; i++ {
			for j := 0; j < cols; j++ {
				fmt.Printf("%d ", c[i][j])
			}
			fmt.Printf("\n")
		}
	*/

	fmt.Printf("Time needed: %dms\n", ellapsedTime)
}

func add(id int, totRows int, totGoroutines int, colSize int, a [][]int, b [][]int, c [][]int, wg *sync.WaitGroup) {
	defer wg.Done()

	blockSize := totRows / totGoroutines
	start := id * blockSize
	stop := start + blockSize
	if id == totGoroutines-1 {
		stop = totRows
	}

	for i := start; i < stop; i++ {
		for j := 0; j < colSize; j++ {
			c[i][j] = a[i][j] + b[i][j]
		}
	}
}
