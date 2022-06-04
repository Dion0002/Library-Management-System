package LMS;

/**
 * Library  class  is subclass of Book with some other attribute : books ,customers ,number of customer and books.
 * This class also is the database for books
 */
public class Library extends Book {

    protected Book[] books = new Book[10000];
    protected Customer[] customers = new Customer[10000];
    protected int numberOfCustomers = 0;
    protected int numberOfBooks = 0;

    /**
     * @param books
     * @param customers
     * @param numberOfBooks
     * @param numberOfCustomers
     */
    public Library(Book[] books, Customer[] customers, int numberOfBooks, int numberOfCustomers) {
        // super();
        this.books = books;
        this.customers = customers;
        this.numberOfBooks = numberOfBooks;
        this.numberOfCustomers = numberOfCustomers;

    }

    public Library(int isbn, String author, String title, String genre, boolean borrowed, Book[] books, Customer[] customers, int numberOfBooks, double price, int numberOfCustomers) {
        super(isbn, author, title, genre, borrowed, price);
        this.books = books;
        this.customers = customers;
        this.numberOfBooks = numberOfBooks;
        this.numberOfCustomers = numberOfCustomers;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    /**
     * addBook method is for the admin for adding new book in library
     *
     * @param newBook
     */
    public void addBook(Book newBook) {

        books[numberOfBooks] = newBook;
        numberOfBooks++;
    }

    /**
     * borrow book method is for checking is a book is borrow or not by a customer
     *
     * @param isbn
     * @param name
     */
    public void borrowBook(int isbn, String name) {
        for (int i = 0; i < numberOfBooks; i++)
            if (books[i].getIsbn() == isbn) {
                System.out.println(books[i].title);
                if (books[i].borrowed) {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                } else {
                    try {
                        for (int j = 0; j < customers.length; j++) {
                            if (name.equals(customers[j].name)) {
                                if (customers[j].balance >= books[i].price) {
                                    System.out.println("You successfully borrowed " + books[i].title);
                                    books[i].borrowed();
                                    if (customers[j].student) {
                                        System.out.println("We have applied a 10% discount because you are a student");
                                        customers[j].balance -= books[i].price + (books[i].price * 0.1);
                                    } else {
                                        customers[j].balance -= books[i].price;
                                    }

                                    customers[j].numberOfBooksBorrowed += 1;

                                } else {
                                    throw new IllegalArgumentException("Error: Insufficient balance!");
                                }

                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println(" ");
                    }
                }

            }
    }


    /**
     * method that show all books
     */
    public void showAllBooks() {
        System.out.println("Books Info");
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println(books[i].toString());
        }
        // System.out.println(books.toString());
    }

    /**
     * method that add new customers
     *
     * @param cus
     */
    public void addCustomer(Customer cus) {
        customers[numberOfCustomers] = cus;
        numberOfCustomers++;

    }

    /**
     * Next book duplicate and take the other book place but there is not a duplicate because nr of books is index of the first duplicate
     * so the next duplicate is out of range
     * deleteBook method is for the admin for deleting new book in library
     *
     * @param isbn
     */
    public void deleteBook(int isbn) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (isbn == books[i].isbn) {
                books[i] = books[i + 1];
                numberOfBooks--;
            }
        }
    }

}


