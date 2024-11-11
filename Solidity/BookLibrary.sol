pragma solidity ^0.5.3; // Use compiler 0.5.17

contract BookLibrary {
    struct Book {
        string title;
        string author;
    }

    Book[] public books;

    // Use _ in your parameter names in order to separate them from the contract's attributes.
    function addBook(string memory _title, string memory _author) public {
        Book memory book = Book(_title, _author);

        books.push(book);
    }

    function getBook(uint _index) public view returns (string memory, string memory) {
        require(_index >= 0 && _index < books.length, "Book does not exist");

        Book memory wanted = books[_index];

        return (wanted.title, wanted.author);
    }

    function getTotalBookNumber() public view returns (uint) {
        return books.length;
    }
}