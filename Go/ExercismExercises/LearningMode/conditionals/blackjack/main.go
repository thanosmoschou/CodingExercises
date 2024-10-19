/*
Author: Thanos Moschou
Description: Blackjack exercise solution
*/

package main

import (
	"blackjack/blackjack"
	"fmt"
)

func main() {
	value := blackjack.ParseCard("ace")
	fmt.Println(value)

	card1 := "ace"
	card2 := "ace"
	dealerCard := "jack"
	fmt.Printf("Strategy for user cards: %v & %v and dealer card: %v: %v\n", card1, card2, dealerCard, blackjack.FirstTurn(card1, card2, dealerCard))

	card1 = "ace"
	card2 = "king"
	dealerCard = "ace"
	fmt.Printf("Strategy for user cards: %v & %v and dealer card: %v: %v\n", card1, card2, dealerCard, blackjack.FirstTurn(card1, card2, dealerCard))

	card1 = "five"
	card2 = "queen"
	dealerCard = "ace"
	fmt.Printf("Strategy for user cards: %v & %v and dealer card: %v: %v\n", card1, card2, dealerCard, blackjack.FirstTurn(card1, card2, dealerCard))

}
