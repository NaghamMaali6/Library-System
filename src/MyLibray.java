import java.util.* ;

public class  MyLibray
{
	//Create a Scanner object to read user input.
    private static Scanner input = new Scanner(System.in) ;
    
    //Create a LibraryCatalog object to store the books in the library.
    private static LibraryCatalog libraryCatalog = new LibraryCatalog() ;
    
	public static void main(String[] args)
	{
		
	    int c ;
	    int condition = 1 ;         //Initialize the condition variable to 1.
	    
	    System.out.println("Welcome to my Library! Please select an option from the menu :) ...") ;  //Welcome the user to the library.
	    
	    while(condition == 1)       //Loop until the user quits the program.
	    {
	    	displayMenu() ;
		    c = getChoice() ;
		    if(c == 1)
		    {
		    	addBookToCatalog() ;
		    	
		    	System.out.println("___________________________________________________________________________________________________________\n") ;
		    }
		    else if(c == 2)
		    {
		    	searchBook();
		    	
		    	System.out.println("___________________________________________________________________________________________________________\n") ;
		    }
		    else if(c == 3)
		    {
		    	borrowBook() ;
		    	
		    	System.out.println("___________________________________________________________________________________________________________\n") ;
		    }
		    else if(c == 4)
		    {
		    	returnBook() ;
		    	
		    	System.out.println("_________________________________________________________________________________________________________\n") ;
		    }
		    else if(c == 5)
		    {
		    	listBookTitles() ;
		    	
		    	System.out.println("_________________________________________________________________________________________________________\n") ;
		    }
		    else if(c == 6)
		    {
		    	break ;
		    }
		    else                    //Handle invalid choices.           
		    {
		    	System.out.println("No such an option! please try again.") ;
		    	
		    	System.out.println("___________________________________________________________________________________________________________\n") ;
		    }
	    }
	    
	    System.out.println("\nthank u for using my library :).... Goodbye!") ;
	}
	
	//Method to display the menu:
	public static void displayMenu() 
	{ 
		System.out.println(" _______________________________ MENU: _______________________________ ") ;
		System.out.println("  1) Add a book to the Library Catalog.") ; 
		System.out.println("  2) Search a Book.") ; 
		System.out.println("  3) Borrow a Book.") ; 
		System.out.println("  4) Return a Book.") ; 
		System.out.println("  5) List all the book titles in Library Catalog.") ; 
		System.out.println("  6) Quit.") ; 
	}
	
	//Method to get the user's choice:
	public static int getChoice() 
	{ 
		System.out.print("Enter your choice: ") ;    //Prompt the user for their choice.          
		//Read and return the user's choice.
		int choice = input.nextInt() ;
		return choice ; 
	}
	
	//Method to add a book to the library catalog:
	private static void addBookToCatalog() 
	{
        input.nextLine() ; 

        System.out.println("Enter the title of the book: ") ;
        String title = input.nextLine() ;

        int bookIndex = libraryCatalog.searchBook(title);           //Search for the book in the catalog.
        if (bookIndex != -1) 
        {
            System.out.println("Book is already exists in the catalog!") ;

            System.out.println("Enter the number of extra copies to add: ") ;         //If the book is found in the catalog , prompt the user for the number of extra copies to add.
            int extraCopies = input.nextInt() ;
            libraryCatalog.addCopies(title , extraCopies) ;         //Add the specified number of copies to the book in the catalog.
            System.out.println("Done Adding!") ;
        }
        else                         //The book isn't found in the catalog.
        {
            System.out.println("Enter the name of the author: ") ;
            String author = input.nextLine() ;

            System.out.println("Enter the number of copies: ") ;
            int copies = input.nextInt() ;

            System.out.println("Enter the copyright year(in the form of yyyy) : ") ;
            int copyright = input.nextInt() ;

            BookIndex book = new BookIndex(title , author , copies , copyright) ;     //Create a new BookIndex object with the specified title , author , number of copies , and copyright year.   
            libraryCatalog.addNewBook(book) ;            //Add the book to the catalog.
            System.out.println("Book is added to the catalog!") ;
        }
	}
	
	//Method to search a book in the library catalog:
	public static void searchBook() 
	{
	    input.nextLine() ; 

	    System.out.println("Enter the title of the book: ") ;
	    String title = input.nextLine() ;

	    int bookIndex = libraryCatalog.searchBook(title) ;         //Search for the book in the catalog.  
	    if (bookIndex != -1)         //If the book is found in the catalog , print a message indicating that the book was found and print the book's details.                               
	    {
	        BookIndex book = libraryCatalog.getBookByIndex(bookIndex) ;
	        System.out.println("Book is found!") ;
	        System.out.println(book.toString()) ;
	    } 
	    else                         //The book wasn't found in the catalog.   
	    {
	        System.out.println("Book isn't found in the catalog!") ;
	    }
	}
	
	//Method to borrow a book from the library catalog:
	public static void borrowBook() 
	{
	    input.nextLine() ; 

	    System.out.println("Enter the title of the book: ") ;
	    String title = input.nextLine() ;

	    int bookIndex = libraryCatalog.searchBook(title) ;         //Search for the book in the catalog.   
	    if (bookIndex != -1)         //If the book is found in the catalog , check if it is available.            
	    {
	        BookIndex book = libraryCatalog.getBookByIndex(bookIndex) ;
	        System.out.println("Book is found!") ;
	        System.out.println(book.toString()) ;

	        boolean success = libraryCatalog.borrowBook(title) ;   //Check if the book is available.      
	        if (success)
	        {
	            System.out.println("Book has been successfully loaned to you!Please return it within 10 days :) ...") ;
	        } 
	        else                     //The book is not available(the number of copies = 0).   
	        {
	            System.out.println("Sorry :( ... the book is not available for loan!") ;
	        }
	    } 
	    else                         //The book wasn't found in the catalog. 
	    {
	        System.out.println("Book isn't found in the catalog!") ;
	    }
	}
	
	//Method to return a book to the library catalog:
	public static void returnBook()
	{
	    input.nextLine() ;  

	    System.out.println("Enter the title of the book: ") ;
	    String title = input.nextLine() ;

	    boolean success = libraryCatalog.returnBook(title) ;       //Search for the book in the catalog.               
	    if (success)                 //If the book is found in the catalog.                         
	    {
	        System.out.println("Book has been successfully returned :) ... Thank you for returning it on time!") ;
	    } 
	    else                         //The book wasn't found in the catalog.  
	    {
	        System.out.println("Error!A book with the entered title hasn't been found in the library :( ...") ;
	        System.out.println("Please re-check the title and try again.") ;
	    }
	}
	
	//Method to list all the book titles in the library catalog:
	public static void listBookTitles() 
	{
	    System.out.println("All books in the library catalog:") ;
	    int numOfBooks = libraryCatalog.getNumOfBooks() ;          //Get the number of books in the catalog.         
	    //Loop through the books in the catalog and print the title of each book.
	    for (int i = 0 ; i < numOfBooks ; i++) 
	    {
	        BookIndex book = libraryCatalog.getBookByIndex(i) ;
	        System.out.println("#" + i + " " + book.getTitle()) ;
	    }
	}
}