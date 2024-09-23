/*
Author: Thanos Moschou
Description: Blackjack exercise solution
*/

// Package blackjack contains some functions for the Blackjack game.
package blackjack

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	switch card {
	case "ace":
		return 11
	case "two":
		return 2
	case "three":
		return 3
	case "four":
		return 4
	case "five":
		return 5
	case "six":
		return 6
	case "seven":
		return 7
	case "eight":
		return 8
	case "nine":
		return 9
	case "ten", "jack", "queen", "king":
		return 10
	default:
		return 0
	}
}

// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1 string, card2 string, dealerCard string) string {
	sum := ParseCard(card1) + ParseCard(card2)

	switch {
	case card1 == "ace" && card2 == "ace":
		return "P"
	case sum == 21:
		switch dealerCard {
		case "ace", "ten", "jack", "king", "queen":
			return "S"
		default:
			return "W"
		}
	case sum >= 17 && sum <= 20:
		return "S"
	case sum >= 12 && sum <= 16:
		switch {
		case ParseCard(dealerCard) < 7:
			return "S"
		default:
			return "H"
		}
	case sum <= 11:
		return "H"
	default:
		return "Error"
	}
}
