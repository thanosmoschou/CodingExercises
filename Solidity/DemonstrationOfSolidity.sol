/*
Description: A simple demonstration of Solidity
*/

pragma solidity ^0.5.3; // Always start with this line

// Let's create the contract
contract DemonstrationOfSolidity {
    // Data types

    // Simple data types
    uint myInt1;
    uint256 myInt2; // Same with uint
    uint128 myInt3;
    uint64 myInt4;

    int myInt5;
    int256 myInt6; // Same with int
    int128 myInt7;

    bool myBool;

    address myAddress;

    string myString;

    bytes32 b1;
    bytes16 b2;
    byte b3; // For a single byte

    // Complex data types
    uint[5] staticArray1; // Fixed size
    uint[] dynamicArray1; // Dynamic size

    // Contract's attributes are storage by default. You cannot declare them as memory.

    // If you do not assign a value to a variable it will be initialized with its default type.

    // Keep in mind that you cannot run code if you are outside of functions. 
    // Only declarations and initializations outside of functions...
    // You cannot do this: myArr[0] = 4;
    
    // Add to array
    function addToArray() public {
        staticArray1[0] = 1; // Cannot use push with static arrays
        dynamicArray1.push(3);
    }

    mapping(uint => string) myMap1; // Key is uint and value is a string

    // Add to a map
    function addToMap() public {
        myMap1[2] = "thanos";
    }

    // Keep in mind that mappings are not iterative. You can not use a for loop to traverse its elements.

    struct Person {
        uint id;
        string name;
        uint balance;
    }

    Person[] people;

    // Create an object of a struct
    function createObject() public {
        Person memory p1 = Person(43, "nathan", 0);
        // Add this person to the array
        people.push(p1);
    }
    

    // Access the fields of an object
    function accessFields() public view {
        string memory pName = people[0].name;
    }

    // How to use storage and memory

    // In Solidity, the memory and storage keywords are used to define where variables are 
    // stored in the Ethereum Virtual Machine (EVM).

    // Storage is a persistent storage area. Variables stored in storage are written directly 
    // to the blockchain and remain there between function calls.
    // Because storage variables are persistent and stored on-chain, they cost gas to read and write.
    // Example use cases: state variables (declared at the contract level) are stored in storage by default.

    // Memory is a temporary storage area that exists only during a function call. 
    // Variables in memory are erased after the function executes.
    // Memory is cheaper than storage in terms of gas costs, but data stored in memory doesn’t persist after the function call.
    // Example use cases: parameters passed to functions, temporary variables, and local variables within a function.

    // Function to add an item to the items array (stored in storage)
    string[] items;

    // Common practise to use _ with a parameter name
    function addItem(string memory _newItem) public {
        // Since `_newItem` is declared with `memory`, it's a temporary variable
        // and does not cost as much gas as a `storage` variable.
        items.push(_newItem); // This will update the storage array
    }

    // Visibility specifiers

    // view
    // Doesn't modify the contract's state. Only reads data. No gas needed
    function readSomething() public view returns (uint) {
        return people[0].id;
    }

    // pure
    // Does not read or modify the contract's state. It only does calculations or returns data based on its arguments
    // without interacting with the blockchain. No gas needed
    function myPure(uint _a, uint _b) public pure returns (uint) {
        return _a + _b;
    }

    // payable
    // Can receive ether when you call it. Also you need ether if you want to call it.
    function myPayable() public payable {
        people[0].balance += msg.value;
    }

    // public 
    // Function is accessible from anywhere
    function setBalance(uint _balance) public {
        people[0].balance = _balance;
    }

    // internal
    // Only accessible from inside the contract or by inheritance
    function myInternal() internal {
        people[0].balance++;
    } 

    // private
    // Accessible only from inside the contract
    function myPriv() private {
        people[0].balance += 100;
    }

    // external
    // Can only be called from other contracts or users. Functions inside the same contract cannot call this function
    // except if you use this keyword
    function myExt() external payable {
         people[0].balance += msg.value;
    }

    // Function signature
    // function name(type arg1, type arg2, ...) visibility mutability returns (returnType) 

}