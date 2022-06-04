package LMS;

/**
 * User  class
 */
public class User {

    protected String name;
    protected int password;
    protected String gender;
    protected int age;


    public User(String name, int password, String gender, int age) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
