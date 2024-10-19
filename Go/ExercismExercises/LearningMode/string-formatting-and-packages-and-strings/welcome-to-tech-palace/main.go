/*
Author: Thanos Moschou
Description: Welcome To Tech Palace exercise solution
*/

package main

import (
	"fmt"
	"welcome-to-tech-palace/techpalace"
)

func main() {
	custName := "thanos"
	welcomeMsg := "Welcome!"
	starsPerLine := 10
	oldMsg := `
	**************************
	*    BUY NOW, SAVE 10%   *
	**************************
	`

	fmt.Println(techpalace.WelcomeMessage(custName))
	fmt.Println(techpalace.AddBorder(welcomeMsg, starsPerLine))
	fmt.Println(techpalace.CleanupMessage(oldMsg))
}
