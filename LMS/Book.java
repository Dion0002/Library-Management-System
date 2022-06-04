package LMS;

/**
 * Book  class
 */
public class Book {

    protected int isbn;
    protected String author;
    protected String title;
    protected String genre;
    protected boolean borrowed;
    protected double price;

    public Book() {
        super();
    }

    /**
     * The Book constructor is responsible creating Books
     * with given isbn ,author,title ,genre ,borrowed and price
     *
     * @param isbn
     * @param author
     * @param title
     * @param genre
     * @param borrowed
     * @param price
     */
    public Book(int isbn, String author, String title, String genre, boolean borrowed, double price) {

        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.borrowed = borrowed;
        this.price = price;

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        if (borrowed) {
            return true;
        } else
            return false;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }


    public String toString() {
        return "\nISBN: " + isbn + "\nAuthor: " + author + "\nTitle: " + title +
                "\nGenre: " + genre + "\nPrice " + price + "\nBorrowed " + borrowed + "\n ";
    }

    protected void borrowed() {

        this.borrowed = true;

    }
}
