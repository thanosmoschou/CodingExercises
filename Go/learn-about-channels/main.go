/*
Author: Thanos Moschou
Description: Learn about channels...based on the tutorial:
https://www.youtube.com/watch?v=qVkSbDrNM-Q
*/

package main

import (
	"fmt"
	"sync"
)

func main() {
	// Be careful and try not to insert all the goroutines to a single wait group
	var wgCreate sync.WaitGroup
	var wgLog sync.WaitGroup

	var logChannel chan string = make(chan string)

	wgLog.Add(1)
	go log(logChannel, &wgLog)

	wgCreate.Add(1)
	go createUser(logChannel, &wgCreate)

	wgCreate.Add(1)
	go createUser(logChannel, &wgCreate)

	wgCreate.Wait()

	close(logChannel)

	wgLog.Wait()
}

func createUser(logChannel chan string, wg *sync.WaitGroup) {
	// Do some work...
	defer wg.Done()
	logChannel <- "User added"
}

func log(logChannel chan string, wg *sync.WaitGroup) {
	defer wg.Done()

	// Keep in mind that when I have a channel and there is no goroutine to interract with it, a deadlock happens.
	// For example let's say that I have 2 threads. The first one sends something to the channel. Then I read it.
	// The second one sends something to the channel. Let's say I do not read the message it sent. Then this message
	// will stay forever inside the channel, so I have a deadlock.
	for value := range logChannel { // When you read from a channel, you have a blocking action...it waits until it reads something
		fmt.Println(value)
	}
}
