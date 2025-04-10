# Library-System
Welcome to MyLibrary, a simple library management system built in Java. This system allows users to interact with a virtual library catalog by adding books, searching for books, borrowing books, returning books, and listing available books. The system is designed to manage a collection of books and their availability.

# Features:
* Add Books: Allows the user to add new books to the catalog or add additional copies of existing books.
* Search Books: Search for books by their title and view their details.
* Borrow Books: Borrow a book from the catalog if it's available.
* Return Books: Return a borrowed book to the library.
* List All Book Titles: Display a list of all books available in the library catalog.
* Menu-Driven Interface: The program will display a menu with the following options:
                         1) Add a book to the Library Catalog
                         2) Search a Book
                         3) Borrow a Book
                         4) Return a Book
                         5) List all the book titles in Library Catalog
                         6) Quit

The system is divided into several main components:
1. MyLibrary Class
   This is the main entry point of the application. It provides the interface to interact with the user and calls other methods to manage the library catalog. It contains methods for displaying the menu, getting user input, and handling library operations such as adding, searching, borrowing, and returning books.
2. BookIndex Class
   This class represents a book in the library catalog. Each book has a title, author, number of copies, and copyright year. The BookIndex class also includes getter and setter methods, as well as a toString method for displaying the book details.
3. LibraryCatalog Class
   This class manages the collection of books in the library. It provides methods to add new books, add copies of existing books, search for books, borrow books, and return books. It also includes methods for listing all books and finding the number of available copies of a particular book.
