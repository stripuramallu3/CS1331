/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
/**
*This abstract class represents a Person
* @author Sreerama Tripuramallu
* @version 1.0
*/
public abstract class Person implements Comparable {
    protected String firstName;
    protected String lastName;
    protected int age;
    /**
    * Creates a new Person object
    */
    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }
    /**
    * Creates a new Person object
    * @param firstName first name of the person
    * @param lastName last name of the person
    * @param age age of the person
    */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    /**
    * Creates a new Person object
    * @param firstName first name of the person
    * @param lastName last name of the person
    */
    public Person(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }
    /**
    * Gets the first name of the person
    * @return the first name
    */
    public String getFirstName() {
        return this.firstName;
    }
    /**
    * Gets the last name of the person
    * @return the last name
    */
    public String getLastName() {
        return this.lastName;
    }
    /**
    * Gets the age of the person
    * @return the age
    */
    public int getAge() {
        return this.age;
    }
    /**
    *Sets the person's first name
    * @param firstName the person's first name
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
    *Sets the person's last name
    * @param lastName the person's last name
    */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
    *Sets the person's age
    * @param age the person's last name
    */
    public void setAge(int age) {
        this.age = age;
    }
    /**
    *Checks if the parameter object is equal to this object
    * @param other the object that is being checked
    * @return true if the this and other object are equal
    */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other == this) {
            return true;
        } else if (other instanceof Person) {
            Person that = (Person) other;
            boolean temp1 = this.firstName.equals(that.getFirstName());
            boolean temp2 = this.lastName.equals(that.getLastName());
            boolean temp3 = this.age == that.getAge();
            return temp1 && temp2 && temp3;
        }
        return false;
    }
    /**
    * Converts the person properties to a string
    * @return the string version of the person properties
    */
    public String toString() {
        String tempString1 = "First Name: " + this.firstName + "\n";
        String tempString2 = "Last Name: " + this.lastName + "\n";
        String tempString3 = "Age: " + this.age + "\n";
        return tempString1 + tempString2 + tempString3;
    }
    /**
    *Compares this person with the parameter
    * @param other the object that is being compared to
    * @return 0 if this and parameter are equal, negative int if this is
    * less than parameter, or positive this is greather than parameter
    */
    public int compareTo(Object other) {
        Person p = (Person) other;
        if (this.age != p.getAge()) {
            return this.age - p.getAge();
        } else if (!this.lastName.equals(p.getLastName())) {
            return this.lastName.compareTo(p.getLastName());
        } else if (!this.firstName.equals(p.getFirstName())) {
            return this.firstName.compareTo(p.getFirstName());
        } else {
            return 0;
        }
    }
}