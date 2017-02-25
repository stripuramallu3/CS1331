/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
/**
*This class represents the class Erudite
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Erudite extends Factioned {
    private String university;
    private String major;
    private String[] bookTitles;
    /**
    * Creates a new Erudite object
    * @param f first name of the erudite
    * @param l last name of the erudite
    * @param a age of the erudite
    * @param u the university of the erudite
    * @param m the major of the eruidte
    * @param b the array of books of the erudite
    */
    public Erudite(String f, String l, int a, String u, String m, String[] b) {
        super(f, l, a, Faction.ERUDITE);
        this.university = u;
        this.major = m;
        this.bookTitles = b;
    }
    /**
    * Creates a new Erudite object
    * @param f first name of the erudite
    * @param l last name of the erudite
    * @param u the university of the erudite
    * @param m the major of the eruidte
    * @param b the array of books of the erudite
    */
    public Erudite(String f, String l, String u, String m, String[] b) {
        this(f, l, 0, u, m, b);
    }
    /**
    * Gets the university of the erudite
    * @return the university
    */
    public String getUniversity() {
        return this.university;
    }
    /**
    * Gets the major of the erudite
    * @return the major
    */
    public String getMajor() {
        return this.major;
    }
    /**
    * Gets the books of the erudite
    * @return the array of books
    */
    public String[] getBookTitles() {
        return this.bookTitles;
    }
    /**
    * Sets the university of the erudite
    * @param university the university of the erudite
    */
    public void setUniversity(String university) {
        if (university != null) {
            this.university = university;
        }
    }
    /**
    * Sets the major of the erudite
    * @param major the major of the erudite
    */
    public void setMajor(String major) {
        if (major != null) {
            this.major = major;
        }
    }
    /**
    * Sets the array of books of the erudite
    * @param bookTitles the array of books of the erudite
    */
    public void setBookTitles(String[] bookTitles) {
        this.bookTitles = bookTitles;
    }
    /**
    *Checks if the parameter object is equal to this object
    * @param other the object that is being checked
    * @return true if the this and other object are equal
    */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (other instanceof Erudite) {
            Erudite that = (Erudite) other;
            boolean temp1 = this.firstName.equals(that.getFirstName());
            boolean temp2 = this.lastName.equals(that.getLastName());
            boolean temp3 = this.age == that.getAge();
            boolean temp4 = this.university.equals(that.getUniversity());
            boolean temp5 = this.major.equals(that.getMajor());
            return temp1 && temp2 && temp3 && temp4 && temp5;
        }
        return false;
    }
    /**
    * Converts the Erudite properties to a string
    * @return the string version of the erudite properties
    */
    public String toString() {
        String temp1 = "First Name: " + this.firstName + "\n";
        String temp2 = "Last Name: " + this.lastName + "\n";
        String temp3 = "Age: " + this.age + "\n";
        String temp4 = "University: " + this.university + "\n";
        String temp5 = "Major: " + this.major + "\n";
        return temp1 + temp2 + temp3 + temp4 + temp5;
    }
    /**
    *Compares this Erudite with the parameter
    * @param other the object that is being compared to
    * @return 0 if this and parameter are equal, negative int if this is
    * less than parameter, or positive this is greather than parameter
    */
    public int compareTo(Object other) {
        Erudite e = (Erudite) other;
        return this.bookTitles.length - e.getBookTitles().length;
    }
}