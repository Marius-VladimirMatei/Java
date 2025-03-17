
public class User {

    // defining the fields
    private String firstName;
    private String lastName;
    private int age;

    public User(String f, String l, int a) {
        this.firstName = f;
        this.lastName = l;
        this.age = a;
    }

    // Getter and setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    // Getter and setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and setter for age
    public int getAge() {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }


    // Modify the data from the user by adding 5 to age
    public void print_modified() {
        System.out.println("Hello, " + firstName + " " + lastName + "! In 5 years you will be " + (age + 5) + " years old.");
    }

}
