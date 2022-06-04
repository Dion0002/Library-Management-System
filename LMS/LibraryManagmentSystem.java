package LMS;

import java.util.Scanner;

/**
 * LibraryManagmentSystem is the main class
 * and  make the code run
 */
public class LibraryManagmentSystem {
    public static void main(String[] args) {

        Admin ad = new Admin("D", 123, "male", 30);
        Customer cs = new Customer(0, 100, false, "B", 321, "female", 20);
        Customer st = new Customer(0, 1000.0, true, "A", 111, "male", 18);

        Book n1 = new Book(111, "A", "Game Of Thrones", "Fantasy", false, 200.0);
        Book n2 = new Book(222, "D", "Harry Potter", "Fantasy", true, 100.0);

        Book[] books = new Book[10000];
        books[0] = n1;
        books[1] = n2;
        Customer[] customers = new Customer[10000];
        customers[0] = cs;
        customers[1] = st;
        Admin[] admins = {ad};
        User[] users = {cs, st, ad};
        Library lib = new Library(books, customers, 2, 2);
        AccountDatabase db = new AccountDatabase(customers, admins, users);

        System.out.println("-------------------Library-------------------");
        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter your password");
        int pass = sc.nextInt();

        while (true) {
            
            if (db.ValidateAccountUser(name, pass)) {
                if (db.getUser(name, pass) instanceof Customer) {
                    System.out.println("----------------------------Main Menu Customer----------------------------");
                    System.out.println("1. Borrow a book");
                    System.out.println("2. Deposit");
                    System.out.println("3. Show All books");
                    System.out.println("4. Exit");
                    System.out.println("Enter a command:");
                    int ans = sc.nextInt();
                    if (ans == 1) {
                        System.out.println("Enter the title of the book: ");
                        int isbn = sc.nextInt();
                        lib.borrowBook(isbn, name);
                    } else if (ans == 2) {
                        System.out.println("Enter the amount that you want to deposit");
                        double amount = sc.nextDouble();
                        db.deposit(amount, name);
                    } else if (ans == 3) {
                        lib.showAllBooks();
                    } else if (ans == 4) {
                        System.out.println("Exiting from your account");
                        break;
                    } else {
                        System.out.println("Wrong command");
                    }

                } else if (db.getUser(name, pass) instanceof Admin) {
                    System.out.println("----------------------------Main Menu  Admin----------------------------");
                    System.out.println("1. Add book");
                    System.out.println("2. Show All books");
                    System.out.println("3. Delete book");
                    System.out.println("4. Add Customer");
                    System.out.println("5. Show Customer");
                    System.out.println("6. Exit");
                    System.out.println("Enter a command:");
                    int ans = sc.nextInt();
                    if (ans == 1) {
                        System.out.println("Enter ISBN:");
                        int isbn = sc.nextInt();
                        System.out.println("Enter author");
                        Scanner au = new Scanner(System.in);
                        String author = au.nextLine();
                        System.out.println("Enter title ");
                        Scanner t = new Scanner(System.in);
                        String title = t.nextLine();
                        System.out.println("Enter genre");
                        Scanner gen = new Scanner(System.in);
                        String genre = gen.nextLine();
                        System.out.println("Enter price");
                        double price = sc.nextDouble();
                        Book newBook = new Book(isbn, author, title, genre, false, price);
                        lib.addBook(newBook);
                    } else if (ans == 2) {
                        lib.showAllBooks();
                    } else if (ans == 3) {
                        System.out.println("Enter ISBN of book that you want to delete");
                        int isbn = sc.nextInt();
                        lib.deleteBook(isbn);
                    } else if (ans == 4) {
                        System.out.println("Enter name of customer");
                        Scanner n = new Scanner(System.in);
                        String cus_name = n.nextLine();
                        System.out.println("Enter password of customer");
                        int cus_pass = sc.nextInt();
                        System.out.println("Enter gender of customer");
                        Scanner g = new Scanner(System.in);
                        String cus_gender = g.nextLine();
                        System.out.println("Enter age of customer");
                        int age = sc.nextInt();
                        System.out.println("Enter balance of customer");
                        double cus_balance = sc.nextDouble();
                        System.out.println("Enter if the customer is a student or not");
                        boolean student = sc.nextBoolean();
                        Customer newCustomer = new Customer(0, cus_balance, student, cus_name, cus_pass, cus_gender, age);
                        lib.addCustomer(newCustomer);
                    } else if (ans == 5) {
                        db.showCustomers(lib.numberOfCustomers);
                    } else if (ans == 6) {
                        System.out.println("Exiting from your account");
                        break;
                    } else {
                        System.out.println("Wrong command");
                    }

                }

            }
            else{
                System.out.println("Error: user not found");
            }
        }
    }
}
