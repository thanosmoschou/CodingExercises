/*
Author: Thanos Moschou
Description: A very simple go program. Just learning the fundamentals
*/

package main //always the first line of the file is a command where we declare the package of the current file.

import (
	//"booking-app/helper"
	"fmt" //Stands for Format package. I need it for printing etc...
	"sync"
	"time"
)

// Keep in mind that package level variables cannot be created with :=
// You need to use var syntax
var conferenceName = "Go conference"

const conferenceTickets = 50 //or const conferenceTickets int = 50
var remainingTickets uint = 50

// var bookings [50]string -> array
// var bookings []string //slice
// var bookings []map[string]string = make([]map[string]string, 0) //or = []map[string]string{}
var bookings []UserData = make([]UserData, 0)

type UserData struct {
	firstname       string
	lastname        string
	email           string
	numberOfTickets uint
}

func main() {
	//Go uses , in function calls to separate arguments and in composite literals (like slices and arrays) to list elements.
	//Also keep in mind that if you add multiple arguments inside Println it automatically adds a space before and after the variable's value,
	//while other languages don't do that. In Java we need to add spaces manually.
	//Also Println adds a new line
	//fmt.Println("Welcome to", conferenceName, "booking application!")
	//fmt.Println("We have total of", conferenceTickets, "and", remainingTickets, "are still available")
	//fmt.Println("Get your tickets here to attend.")
	//You can also concatenate strings inside Println if you want...
	//fmt.Println("Hello " + "World") -> this is evaluated to a single argument that is passed to Println

	//To print formatted data, use printf
	//%v is a placeholder. It is the default format, but we have other formats available. Check Go's documentation for more.
	//%T is a placeholder for the type of variables
	//fmt.Printf("conferenceTickets is %T, remainingTickets is %T, conferenceName is %T\n", conferenceTickets, remainingTickets, conferenceName)

	var wg sync.WaitGroup //Here it gets the default value for this type...I do not have to initialize it but I could have done it

	//greetUsers(conferenceName, conferenceTickets, remainingTickets)
	greetUsers()

	//infinite loop
	for {

		firstname, lastname, email, userTickets := getUserInput()

		//var isValidName, isValidEmail bool -> you can declare variables that have the same type like this...se the theory on the top part of the file
		//isValidName, isValidEmail, isValidTicketNumber := helper.ValidateUserInput(firstname, lastname, email, userTickets, remainingTickets)
		isValidName, isValidEmail, isValidTicketNumber := validateUserInput(firstname, lastname, email, userTickets)

		/*
			Keep in mind that if the validateUserInput function is inside a different file that belongs to the same package, Go
			can find that function without any problem. But if this function belongs to a file from a different package, I need to
			import that package. Also the function needs to be exported.
		*/

		if isValidName && isValidEmail && isValidTicketNumber {

			bookTicket(userTickets, firstname, lastname, email)

			wg.Add(1)
			go sendTicket(userTickets, firstname, lastname, email, &wg)

			var firstnames []string = getFirstNames()
			fmt.Printf("The first names of bookings are: %v\n", firstnames)

			//var noTicketsRemaining bool = remainingTickets == 0 (explicit type declaration)
			//var noTicketsRemaining = remainingTickets == 0 (type inference)
			//noTicketsRemaining := remainingTickets == 0

			if remainingTickets == 0 {
				fmt.Println("Our conference is booked out. Come back next year.")
				break //terminate the loop that this break keyword is part of
			}
		} else {
			if !isValidName {
				fmt.Println("First name or last name you entered is too short")
			}

			if !isValidEmail {
				fmt.Println("The email you entered does not contain @ sign")
			}

			if !isValidTicketNumber {
				fmt.Println("Number of tickets you entered is invalid")
			}

			//fmt.Println("Your input data is invalid. Try again")
			//continue //skip the next part of the loop and go to the next iteration...I do not need this in my else section
		}

	}

	wg.Wait()

	/*
		var firstname string
		var lastname string
		var email string
		var userTickets uint //unsigned int...only positive numbers

		fmt.Println("Enter your firstname: ")
		fmt.Scan(&firstname) //Same logic with scanf of C

		fmt.Println("Enter your lastname: ")
		fmt.Scan(&lastname)

		fmt.Println("Enter your email: ")
		fmt.Scan(&email)

		fmt.Println("Enter your tickets: ")
		fmt.Scan(&userTickets)

		//username = "Mark"
		//userTickets = 10

		remainingTickets -= userTickets
		//bookings[0] = firstname + " " + lastname //string concatenation just like other programming languages
		bookings = append(bookings, firstname+" "+lastname)
	*/

	/*
		fmt.Printf("The whole array: %v\n", bookings)
		fmt.Printf("The whole slice: %v\n", bookings)
		fmt.Printf("The first value: %v\n", bookings[0])
		fmt.Printf("The type of the array: %T\n", bookings)
		fmt.Printf("The type of the slice: %T\n", bookings)
		fmt.Printf("The size of the array: %v\n", len(bookings))
		fmt.Printf("The size of the slice: %v\n", len(bookings))
	*/
}

func greetUsers() {
	fmt.Printf("Welcome to %v booking application\n", conferenceName)
	fmt.Printf("We have total of %v tickets and %v are still available\n", conferenceTickets, remainingTickets)
	fmt.Println("Get your tickets here to attend.")
}

func getFirstNames() []string {
	// firstnames := []string{} //I am not consistent to a specific declaration style because I want to get used to all of them
	// for _, booking := range bookings { //Underscore is a blank identifier. I use it when I want to ignore a variable that I will not use
	// 	var names = strings.Fields(booking)
	// 	firstnames = append(firstnames, names[0])
	// }

	firstnames := make([]string, 0) //alternative way of creating a slice
	for _, booking := range bookings {
		//firstnames = append(firstnames, booking["firstname"])
		firstnames = append(firstnames, booking.firstname)
	}

	return firstnames
}

func getUserInput() (string, string, string, uint) {
	var firstname string
	var lastname string
	var email string
	var userTickets uint //unsigned int...only positive numbers

	fmt.Println("Enter your firstname: ")
	fmt.Scan(&firstname) //Same logic with scanf of C

	fmt.Println("Enter your lastname: ")
	fmt.Scan(&lastname)

	fmt.Println("Enter your email: ")
	fmt.Scan(&email)

	fmt.Println("Enter your tickets: ")
	fmt.Scan(&userTickets)

	return firstname, lastname, email, userTickets
}

func bookTicket(userTickets uint, firstname string, lastname string, email string) {
	remainingTickets -= userTickets

	/*
		Here I have a problem...
		I know that slices are passed by reference which means that any change to the slice inside the function will
		affect the original one. But here I reassign the slice...

		Reassigning the Slice: The line bookings = append(bookings, firstname+" "+lastname) does two things:
		It appends a new element to the slice.
		It reassigns the bookings slice variable to a new slice (if the capacity of the original slice is exceeded).
		This reassignment affects only the local bookings variable inside the bookTicket function.

		Reassigning the slice inside the function does not change the original slice variable outside the function.
		To ensure that changes to the slice (e.g., new elements added) are visible outside the function,
		you need to return the updated slice and assign it back in the calling function.
	*/

	//create a map for a user
	//var userData map[string]string = make(map[string]string)
	var userData UserData = UserData{
		firstname:       firstname,
		lastname:        lastname,
		email:           email,
		numberOfTickets: userTickets, //If you place the } at this line you do not need ,
	}

	// userData["firstname"] = firstname
	// userData["lastname"] = lastname
	// userData["email"] = email
	// userData["tickets"] = strconv.FormatUint(uint64(userTickets), 10)

	//bookings = append(bookings, firstname+" "+lastname)
	//Here the bookings is package level so I directly assign the new slice reference to my variable,
	//but if it wasn't you had to return it to the caller function in order to get the changes to the original slice
	bookings = append(bookings, userData)
	fmt.Printf("List of bookings is %v\n", bookings)

	fmt.Printf("Thank you %v %v for booking %v tickets. You will receive a confirmation email at %v.\n", firstname, lastname, userTickets, email)
	fmt.Printf("%v tickets remaining for %v\n", remainingTickets, conferenceName)

	//return bookings
}

func sendTicket(userTickets uint, firstname string, lastname string, email string, wg *sync.WaitGroup) {
	defer wg.Done()

	time.Sleep(10 * time.Second)

	var ticket string = fmt.Sprintf("%v tickets for %v %v\n", userTickets, firstname, lastname)

	fmt.Println("###############")
	fmt.Printf("Sending ticket:\n%vto email address %v\n", ticket, email)
	fmt.Println("###############")
}
