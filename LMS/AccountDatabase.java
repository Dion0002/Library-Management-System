package LMS;

/**
 * AccountDatabase  class  is subclass of User
 */
public class AccountDatabase extends User {

    protected Customer[] customer;
    protected Admin[] admin;
    protected User[] user;

    /***
     *
     * @param customer
     * @param admin
     * @param user
     */
    public AccountDatabase(Customer[] customer, Admin[] admin, User[] user) {
        super();
        this.admin = admin;
        this.customer = customer;
        this.user = user;
    }

    public AccountDatabase(Admin[] admin) {
        super();
        this.admin = admin;
    }

    public AccountDatabase(User[] user) {
        super();
        this.user = user;
    }

    /**
     * ValidateAccount method is for authentication
     *
     * @param name
     * @param passsword
     * @return
     */
    public boolean ValidateAccount(String name, int passsword) {
        boolean valid = false;
        for (int i = 0; i < customer.length; i++) {
            System.out.println(i);
            if (name.equals(customer[i].getName()) && passsword == customer[i].getPassword()) {
                System.out.println("Welcome");
                valid = true;
                break;
            }
        }
        if (!valid) {
        }
        return valid;
    }

    /**
     * ValidateAccountUser method is for authentication users
     *
     * @param name
     * @param passsword
     * @return
     */
    public boolean ValidateAccountUser(String name, int passsword) {
        boolean valid = false;
        for (int i = 0; i < user.length; i++) {
            if (name.equals(user[i].getName()) && passsword == user[i].getPassword()) {
                System.out.println("Welcome");
                valid = true;
                break;
            }
        }
        if (!valid) {
            System.out.println("Error: User not found");

        }
        return valid;
    }

    /**
     * deposit method is for user to deposit new amount if he/she doesn't have enough to buy the book
     *
     * @param amount
     * @param name
     */
    public void deposit(double amount, String name) {
        for (int i = 0; i < customer.length; i++) {
            if (name.equals(customer[i].getName())) {
                customer[i].balance += amount;
                System.out.println("Your balance is: " + customer[i].balance);
                break;
            }
        }

    }

    /**
     * getUser Method
     *
     * @param name
     * @param pass
     * @return
     */
    public User getUser(String name, int pass) {
        User cus = new User();
        for (int i = 0; i < user.length; i++) {
            if (name.equals(user[i].getName()) && pass == user[i].getPassword()) {
                cus = user[i];
                break;
            }
        }
        return cus;

    }

    /**
     * getAdmin Method
     *
     * @param name
     * @param pass
     * @return
     */
    public Admin getAdmin(String name, int pass) {
        Admin ad = new Admin();
        for (int i = 0; i < admin.length; i++) {
            if (name.equals(admin[i].getName()) && pass == admin[i].getPassword()) {
                ad = admin[i];
                break;
            }
        }
        return ad;

    }

    /**
     * show customer Method
     *
     * @param numberOfCustomers
     */
    public void showCustomers(int numberOfCustomers) {
        System.out.println("Users Info");
        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.println(customer[i].toString());
        }

    }


}
