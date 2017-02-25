/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.util.Random;
/**
*This class represents the class Divergent
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Divergent extends Factionless {
    private static int numDivergent = 0;
    private Random rand = new Random();
    private Faction[] factions;
    private int length;
    private double percentFoundChance;
    private String[] firstNames = {"Joe", "Alex", "Jason", "George", "Nick"
         , "Steven", "Patrick", "Tyler", "Ricky", "Jordan"};
    private String[] lastNames = {"Mary", "Sara", "Rebecca", "Emily", "Olivia"
         , "Donna", "Nicole", "Diana", "Amy", "Victoria"};
    /**
    * Creates a new Divergent object
    * @param fN first name of the divergent
    * @param lN last name of the divergent
    * @param age age of the divergent
    * @param dL danger level of the divergent
    * @param f array of factions of the divergent
    */
    public Divergent(String fN, String lN, int age, double dL, Faction[] f) {
        super(fN, lN, age, dL);
        numDivergent++;
        this.factions = f;
        this.length = this.factions.length;
        this.percentFoundChance = (rand.nextDouble() * (0.5)) * this.length;
        update(this.percentFoundChance);
    }
    /**
    * Creates a new Divergent object
    * @param fN first name of the divergent
    * @param lN last name of the divergent
    * @param dL danger level of the divergent
    * @param f array of factions of the divergent
    */
    public Divergent(String fN, String lN, double dL, Faction[] f) {
        this(fN, lN, 0, dL, f);
    }
    /**
    * Gets the percent found chance of the divergent
    * @return the percent found chance
    */
    public double getPercentFoundChance() {
        return percentFoundChance;
    }
    /**
    * Gets the array of factions of the divergent
    * @return the array of factions
    */
    public Faction[] getFactions() {
        return this.factions;
    }
    /**
    * Gets the total number of divergent objects
    * @return the total number of divergents
    */
    public static int getNumDivergent() {
        return numDivergent;
    }
    /**
    * Sets the percent found chance of the divergent
    * @param pFC the percent found chacne of the divergent
    */
    public void setPercentFoundChance(double pFC) {
        this.percentFoundChance = pFC;
        update(pFC);
    }
    private void update(double pFC) {
        int temp1 = rand.nextInt(11);
        int temp2 = rand.nextInt(11);
        if (pFC > 1.0) {
            this.firstName = firstNames[temp1];
            this.lastName = lastNames[temp2];
            this.percentFoundChance = 0.0;
        }
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
        } else if (other instanceof Divergent) {
            Divergent d = (Divergent) other;
            boolean temp1 = this.firstName.equals(d.getFirstName());
            boolean temp2 = this.lastName.equals(d.getLastName());
            boolean temp3 = this.age == d.getAge();
            boolean temp4 = this.dangerLevel == d.getDangerLevel();
            boolean temp5 = percentFoundChance == d.getPercentFoundChance();
            boolean temp6 = this.factions.length == d.getFactions().length;
            boolean temp7 = true;
            for (int i = 0; i < this.factions.length && temp6 && temp7; i++) {
                if (this.factions[i] != d.factions[i]) {
                    temp7 = false;
                }
            }
            return temp1 && temp2 && temp3 && temp4 && temp5 && temp6 && temp7;
        }
        return false;
    }
    /**
    * Converts the Divergent properties to a string
    * @return the string version of the divergent properties
    */
    public String toString() {
        String temp1 = "First Name: " + this.firstName + "\n";
        String temp2 = "Last Name: " + this.lastName + "\n";
        String temp3 = "Age: " + this.age + "\n";
        String temp4 = "Danger Level: " + this.dangerLevel + "\n";
        String temp5 = "Percent Chance of being Found: "
             + this.percentFoundChance + "\n";
        String temp6 = "";
        for (int i = 0; i < factions.length; i++) {
            temp6 = temp6 + factions[i] + " ";
        }
        temp6 = temp6 + "\n";
        return temp1 + temp2 + temp3 + temp4 + temp5 + temp6;
    }
    /**
    *Compares this Divergent with the parameter
    * @param other the object that is being compared to
    * @return 0 if this and parameter are equal, negative int if this is
    * less than parameter, or positive this is greather than parameter
    */
    public int compareTo(Object other) {
        Divergent d = (Divergent) other;
        if (this.age != d.getAge()) {
            return this.age - d.getAge();
        } else if (!this.lastName.equals(d.getLastName())) {
            return this.lastName.compareTo(d.getLastName());
        } else if (!this.firstName.equals(d.getFirstName())) {
            return this.firstName.compareTo(d.getFirstName());
        } else if (this.dangerLevel != d.getDangerLevel()) {
            Double x = new Double(this.dangerLevel);
            return x.compareTo(d.getPercentFoundChance());
        } else if (this.percentFoundChance != d.getPercentFoundChance()) {
            Double x = new Double(this.percentFoundChance);
            return x.compareTo(d.getPercentFoundChance());
        } else {
            return 0;
        }
    }

}