/*
Author: Thanos Moschou
Description: Election Day exercise solution
*/

package main

import (
	"election-day/electionday"
	"fmt"
)

func main() {
	var initialVotes int
	initialVotes = 2

	var counter *int
	counter = electionday.NewVoteCounter(initialVotes)
	fmt.Println(*counter == initialVotes) // true

	var votes int
	votes = 3

	var voteCounter *int
	voteCounter = &votes

	fmt.Println(electionday.VoteCount(voteCounter))
	// => 3

	var nilVoteCounter *int
	fmt.Println(electionday.VoteCount(nilVoteCounter))
	// => 0

	votes = 3
	voteCounter = &votes

	electionday.IncrementVoteCount(voteCounter, 2)

	fmt.Println(votes == 5)        // true
	fmt.Println(*voteCounter == 5) // true

	var result *electionday.ElectionResult
	result = electionday.NewElectionResult("Peter", 3)

	fmt.Println(result.Name == "Peter") // true
	fmt.Println(result.Votes == 3)      // true

	result = &electionday.ElectionResult{
		Name:  "John",
		Votes: 32,
	}

	fmt.Println(electionday.DisplayResult(result))
	// => John (32)

	var finalResults = map[string]int{
		"Mary": 10,
		"John": 51,
	}

	electionday.DecrementVotesOfCandidate(finalResults, "Mary")

	fmt.Println(finalResults["Mary"])
	// => 9
}
