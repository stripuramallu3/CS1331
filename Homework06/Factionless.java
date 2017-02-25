/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
/**
*This class represents the class Factionless
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Factionless extends Person {
    protected double dangerLevel;
    /**
    * Creates a new Factionless object
    * @param firstName first name of the factionless
    * @param lastName last name of the factionless
    * @param age age of the factionless
    * @param dL danger level of the factionless
    */
    public Factionless(String firstName, String lastName, int age, double dL) {
        super(firstName, lastName, age);
        checkDangerLevel(dL);
    }
    /**
    * Creates a new Factionless object
    * @param firstName first name of the factionless
    * @param lastName last name of the factionless
    * @param dL danger level of the factionless
    */
    public Factionless(String firstName, String lastName, double dL) {
        this(firstName, lastName, 0, dL);
    }
    private void checkDangerLevel(double dL) {
        if (dL >= 0.0 && dL <= 50.0) {
            this.dangerLevel = dL;
        } else {
            this.dangerLevel = 0;
        }
    }
    /**
    * Gets the danger level of the factionless
    * @return the danger level
    */
    public double getDangerLevel() {
        return this.dangerLevel;
    }
    /**
    * Sets the danger level of the factionless
    * @param dL dangerl level of the factionless
    */
    public void setDangerLevel(double dL) {
        checkDangerLevel(dL);
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
        } else if (other instanceof Factionless) {
            Factionless f = (Factionless) other;
            boolean temp1 = this.firstName.equals(f.getFirstName());
            boolean temp2 = this.lastName.equals(f.getLastName());
            boolean temp3 = this.age == f.getAge();
            boolean temp4 = this.dangerLevel == f.getDangerLevel();
            return temp1 && temp2 && temp3 && temp4;
        }
        return false;
    }
    /**
    * Converts the Factionless properties to a string
    * @return the string version of the factionless properties
    */
    public String toString() {
        String tempString1 = "First Name: " + this.firstName + "\n";
        String tempString2 = "Last Name: " + this.lastName + "\n";
        String tempString3 = "Age: " + this.age + "\n";
        String tempString4 = "Danger Level: " + this.dangerLevel + "\n";
        return tempString1 + tempString2 + tempString3 + tempString4;
    }
    /**
    *Compares this Factionless with the parameter
    * @param other the object that is being compared to
    * @return 0 if this and parameter are equal, negative int if this is
    * less than parameter, or positive this is greather than parameter
    */
    public int compareTo(Object other) {
        Factionless f = (Factionless) other;
        if (this.age != f.getAge()) {
            return this.age - f.getAge();
        } else if (!this.lastName.equals(f.getLastName())) {
            return this.lastName.compareTo(f.getLastName());
        } else if (!this.firstName.equals(f.getFirstName())) {
            return this.firstName.compareTo(f.getFirstName());
        } else if (this.dangerLevel != f.getDangerLevel()) {
            Double d = new Double(this.dangerLevel);
            return d.compareTo(f.getDangerLevel());
        } else {
            return 0;
        }
    }
}