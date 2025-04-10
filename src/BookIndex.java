public class BookIndex 
{
	//Declare private variables to store the book's title , author , number of copies , and copyright year.
	private String title ;
    private String author ;
    private int copies ;
    private int copyright ;

    //Constructor :
    public BookIndex(String title , String author , int copies , int copyright) 
    {
    	//Assign the specified values to the private variables.
    	this.title = title ;
        this.author = author ;
        this.copies = copies ;
        this.copyright = copyright ;
    }

    //Getters:
    public String getTitle() 
    {
        return title ;    
    }

    public String getAuthor()
    {
        return author ;
    }

    public int getCopies() 
    {
        return copies ;
    }

    public int getCopyright()
    {
        return copyright ;
    }

    //Setters:
    public void setTitle(String title)
    {
        this.title = title ;
    }
    
    public void setAuthor(String author) 
    {
        this.author = author ;
    }
    
    public void setCopies(int copies)
    {
        this.copies = copies ;
    }

    public void setCopyright(int copyright) 
    {
        this.copyright = copyright ;
    }

    //toString method:
    public String toString() 
    {
        return "Title: " + title + "\nAuthor: " + author + "\nCopies: " + copies + "\nCopyright year: " + copyright;
    }
}
