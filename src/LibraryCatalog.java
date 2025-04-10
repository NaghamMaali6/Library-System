public class LibraryCatalog 
{
	//Declare private variables to store the maximum number of books in the catalog , the array of BookIndex objects , and the number of books in the catalog.
	private static final int MAX_BOOKS = 5000 ; // Maximum number of books in the catalog
    private BookIndex[] catalog ;
    private int numOfBooks ;

    //Constructor:
    public LibraryCatalog() 
    {
        catalog = new BookIndex[MAX_BOOKS] ;    //create an array of BookIndex objects of size MAX_BOOKS.
        numOfBooks = 0 ;                       //the number of books in the catalog set to 0.
    }

    //Method to add a new BookIndex to the LibraryCatalog with zero copies:
    public void addNewBook(BookIndex book) 
    {
        if (numOfBooks < MAX_BOOKS)            //If the number of books in the catalog is less than MAX_BOOKS , the new BookIndex object is added to the catalog and the number of books in the catalog is incremented.   
        {
            catalog[numOfBooks] = book ;
            numOfBooks++ ;
        } 
        else                                   //Otherwise , a message is printed to the console stating that the catalog is full and the new BookIndex object is not added.    
        {
            System.out.println("Catalog is full!Cannot add more books.") ;
        }
    }

    //Method to add a new BookIndex to the LibraryCatalog with a specified number of copies:
    public void addNewBook(BookIndex book , int ncopies) 
    {
        if (numOfBooks < MAX_BOOKS)            //If the number of books in the catalog is less than MAX_BOOKS , the new BookIndex object is added to the catalog with the specified number of copies and the number of books in the catalog is incremented.       
        {
            book.setCopies(ncopies) ;
            catalog[numOfBooks] = book ;
            numOfBooks++ ;
        } 
        else                             //Otherwise , a message is printed to the console stating that the catalog is full and the new BookIndex object is not added.
        {
            System.out.println("Catalog is full!Cannot add more books.") ;
        }
    }

    //Method to add a quantity of copies to an existing book in the LibraryCatalog:
    public boolean addCopies(String title , int quantity) 
    {
        for (int i = 0 ; i < numOfBooks ; i++) 
        {
            if (catalog[i].getTitle().equals(title))          //If the book is found , the number of copies of the book is incremented by the specified quantity. 
            {
                int currentCopies = catalog[i].getCopies() ;
                catalog[i].setCopies(currentCopies + quantity) ;
                return true ;
            }
        }
        return false ;                   //Otherwise , the method returns false.                            
    }

    //Method to find the number of copies for a book in the LibraryCatalog:
    public int findInCatalog(String title)
    {
        for (int i = 0 ; i < numOfBooks ; i++)
        {
            if (catalog[i].getTitle().equals(title))          //If the book is found , the number of copies of the book is returned.      
            {
                return catalog[i].getCopies() ;
            }
        }
        return 0 ;                 //Otherwise , 0 is returned.
    }


    // Method to search for a book in the LibraryCatalog and return its index
    public int searchBook(String title) 
    {
        for (int i = 0 ; i < numOfBooks ; i++) 
        {
            if (catalog[i].getTitle().equals(title))          //If the book is found , its index in the catalog is returned.           
            {
                return i ;
            }
        }
        return -1 ;                //Otherwise , -1 is returned.                    
    }

    //Method to list all the titles , authors , copyrights , and number of copies of books in the LibraryCatalog:
    public void listTitles()
    {
        for (int i = 0 ; i < numOfBooks ; i++) 
        {
            //print a list of all the titles , authors , copyrights , and number of copies of books in the LibraryCatalog.
        	System.out.println("Title: " + catalog[i].getTitle()) ;
            System.out.println("Author: " + catalog[i].getAuthor()) ;
            System.out.println("Copyright year: " + catalog[i].getCopyright()) ;
            System.out.println("Copies: " + catalog[i].getCopies()) ;
            System.out.println("-------------------------") ;
        }
    }


    //Method to loan a book to a borrower:
    public boolean borrowBook(String title)
    {
    	//Check if the book is available in the library catalog.
    	for (int i = 0 ; i < numOfBooks ; i++) 
        {
            if (catalog[i].getTitle().equals(title) && catalog[i].getCopies() > 0)           //If the book is available , the number of copies of the book is decremented by 1.
            {
                int currentCopies = catalog[i].getCopies() ;
                catalog[i].setCopies(currentCopies - 1) ;
                return true ;
            }
        }
        return false ;             //Otherwise , the method returns false.                    
    }

    //Method to return a book to the LibraryCatalog:
    public boolean returnBook(String title)
    {
    	//Check if the book is available in the library catalog.
    	for (int i = 0 ; i < numOfBooks ; i++) 
        {
            if (catalog[i].getTitle().equals(title))                    //If the book is available , the number of copies of the book is incremented by 1.
            {
                int currentCopies = catalog[i].getCopies() ;
                catalog[i].setCopies(currentCopies + 1) ;
                return true ;
            }
        }
        return false ;             //Otherwise , the method returns false.                                 
    }
    
    //Method is used to retrieve the BookIndex object from the library catalog based on the index obtained from the searchBook method:
    public BookIndex getBookByIndex(int index) 
    {
    	//Check if the index is within the range of the number of books in the library catalog.
    	if (index >= 0 && index < numOfBooks)                 //If the index is within the range , the BookIndex object at the specified index is returned.
        {
            return catalog[index] ;
        }
        return null ;              //Otherwise , null is returned.  
    }
    
    //Helper method to get the number of books in the catalog:
    public int getNumOfBooks()
    {
        //Return the number of books in the library catalog.
    	return numOfBooks ;     
    }
}

