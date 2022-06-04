package LMS;

/**
 * Customer  class  is subclass of User with some other attribute like numberOfBooks ,balance ,and if customer is a student or not
 */
public class Customer extends User {

    protected int numberOfBooksBorrowed;
    protected double balance;
    protected boolean student;

    public Customer() {
        super();
    }

    /**
     * The Customer constructor is responsible creating Customers
     * by calling the User constructor to create the Customer with
     * given name ,password,gender ,age ,balance,if student or not and books borrowed
     *
     * @param numberOfBooksBorrowed
     * @param balance
     * @param student
     * @param name
     * @param password
     * @param gender
     * @param age
     */
    public Customer(int numberOfBooksBorrowed, double balance, boolean student, String name, int password, String gender, int age) {
        super(name, password, gender, age);
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
        this.balance = balance;
        this.student = student;
    }

    public int getNumberOfBooksBorrowed() {
        return numberOfBooksBorrowed;
    }

    public void setNumberOfBooksBorrowed(int numberOfBooksBorrowed) {
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public String toString() {
        return "\nName: " + name + "\nPassword: " + password + "\nGender: " + gender +
                "\nAge: " + age + "\nBalance: " + balance + "\nStudent: " + student +
                "\nNumber of Books Borrowed: " + numberOfBooksBorrowed + "\n ";
    }

}
