/*
Author: Thanos Moschou
Description: Card Tricks exercise solution
*/

package main

import (
	"card-tricks/cards"
	"fmt"
)

func main() {
	cardsSlice := cards.FavoriteCards()
	fmt.Println("Favorite cards:", cardsSlice)

	card := cards.GetItem([]int{1, 2, 3, 4, 10}, 2)
	fmt.Println("Item at index 2:", card)

	card = cards.GetItem([]int{1, 2, 3, 4, 10}, 5) // Out of bounds
	fmt.Println("Item at index 5:", card)

	index := 2
	newCard := 6
	cardsSlice = cards.SetItem(cardsSlice, index, newCard)
	fmt.Println("After setting index 2:", cardsSlice)

	index = 4 // Out of bounds
	newCard = 6
	cardsSlice = cards.SetItem(cardsSlice, index, newCard)
	fmt.Println("After appending at index 4:", cardsSlice)

	// Working with a separate slice
	slice := []int{300, 4200, 54}
	fmt.Println("Original slice:", slice)

	// Attempt to remove out of bounds
	newSliceWithoutRemovedElement := cards.RemoveItem(slice, 10) // Out of bounds
	fmt.Println("Attempt to remove index 10 from original slice:", newSliceWithoutRemovedElement)
	fmt.Println("Original slice after out-of-bounds attempt:", slice)

	// Remove item at index 0
	newSliceWithoutRemovedElement = cards.RemoveItem(slice, 0)
	fmt.Println("After removing index 0:", newSliceWithoutRemovedElement)
	fmt.Println("Original slice:", slice)

	// Remove item at index 1 from the modified slice
	newSliceWithoutRemovedElement = cards.RemoveItem(newSliceWithoutRemovedElement, 1)
	fmt.Println("After removing index 1:", newSliceWithoutRemovedElement)
	fmt.Println("Original slice:", slice)

}
