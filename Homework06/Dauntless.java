/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.util.Random;
/**
*This class represents the class Dauntless
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Dauntless extends Factioned {
    private int agility;
    private int endurance;
    private Dauntless rival = null;
    /**
    * Creates a new Dauntless object
    * @param fN first name of the Dauntless
    * @param lN last name of the Dauntless
    * @param age age of the Dauntless
    */
    public Dauntless(String fN, String lN, int age) {
        super(fN, lN, age, Faction.DAUNTLESS);
        Random rand = new Random();
        this.agility = rand.nextInt(11);
        this.endurance = rand.nextInt(11);
    }
    /**
    * Creates a new Dauntless object
    * @param fN first name of the Dauntless
    * @param lN last name of the Dauntless
    * @param age age of the Dauntless
    * @param a agility of the Dauntless
    * @param e endurance of the Dauntless
    */
    public Dauntless(String fN, String lN, int age, int a, int e) {
        super(fN, lN, age, Faction.DAUNTLESS);
        if (a >= 0 && a <= 10) {
            this.agility = a;
        } else {
            this.agility = 0;
        }
        if (e >= 0 && e <= 10) {
            this.endurance = e;
        } else {
            this.endurance = 0;
        }
    }
    /**
    * Gets the agility of the Dauntless
    * @return the agility
    */
    public int getAgility() {
        return this.agility;
    }
    /**
    * Gets the endurance of the Dauntless
    * @return the endurance
    */
    public int getEndurance() {
        return this.endurance;
    }
    /**
    * Gets the rival of the Dauntless
    * @return the rival
    */
    public Dauntless getRival() {
        return this.rival;
    }
    /**
    * Gets the winner between this Dauntless and parameter
    * @param d the Dauntless object that is competing this dauntless
    * @return the agility
    */
    public Dauntless getWinner(Dauntless d) {
        Random rand = new Random();
        int temp1 = 0;
        int temp2 = 0;
        Integer temp3 = new Integer(this.agility);
        Integer temp4 = new Integer(this.endurance);
        int comp1 = temp3.compareTo(d.getAgility());
        int comp2 = temp4.compareTo(d.getEndurance());
        if (comp1 > 0) {
            temp1++;
        } else if (comp1 < 0) {
            temp2++;
        }
        if (comp2 > 0) {
            temp1++;
        } else if (comp2 < 0) {
            temp2++;
        }
        if (temp1 == temp2) {
            int x = rand.nextInt();
            if (x == 0) {
                return this;
            } else {
                this.rival = d;
                return d;
            }
        } else if (temp1 > temp2) {
            return this;
        } else {
            this.rival = d;
            return d;
        }
    }
    /**
    * Ajusts the agility of the Dauntless based on parameter
    * @param u the agility increase of the Dauntless
    */
    public void trainsAgility(int u) {
        this.agility += u;
        Dauntless d = null;
        System.out.println(this.firstName + " " +  this.lastName
             + " has trained and increased agility");
        if (rival != null) {
            d = this.getWinner(rival);
        }
        if (this.equals(d)) {
            System.out.println("The training has paid off, and "
                 + this.firstName + " " + this.lastName + " has defeated"
                 + rival.getFirstName() + " " + rival.getLastName());
        }

    }
    /**
    * Ajusts the endurance of the Dauntless based on parameter
    * @param u the endurance increase of the Dauntless
    */
    public void trainsEndurance(int u) {
        this.endurance += u;
        Dauntless d = null;
        System.out.println(this.firstName + " " +  this.lastName
             + " has trained and increased endurence");
        if (rival != null) {
            d = this.getWinner(rival);
        }
        if (this.equals(d)) {
            System.out.println("The training has paid off, and "
                 + this.firstName + " " + this.lastName + " has defeated"
                 + rival.getFirstName() + " " + rival.getLastName());
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
        } else if (other instanceof Dauntless) {
            Dauntless that = (Dauntless) other;
            boolean temp1 = this.firstName.equals(that.getFirstName());
            boolean temp2 = this.lastName.equals(that.getLastName());
            boolean temp3 = this.age == that.getAge();
            boolean temp4 = this.faction.equals(that.getFaction());
            boolean temp5 = this.agility == that.getAgility();
            boolean temp6 = this.endurance == that.getEndurance();
            return temp1 && temp2 && temp3 && temp4 && temp5 && temp6;
        }
        return false;
    }
    /**
    * Converts the Dauntless properties to a string
    * @return the string version of the dauntless properties
    */
    public String toString() {
        String temp1 = "First Name: " + this.firstName + "\n";
        String temp2 = "Last Name: " + this.lastName + "\n";
        String temp3 = "Age: " + this.age + "\n";
        String temp4 = "Faction: " + this.faction + "\n";
        String temp5 = "Agility: " + this.agility + "\n";
        String temp6 = "Endurance: " + this.endurance + "\n";
        return temp1 + temp2 + temp3 + temp4 + temp5 + temp6;
    }
    /**
    *Compares this Dauntless with the parameter
    * @param other the object that is being compared to
    * @return 0 if this and parameter are equal, negative int if this is
    * less than parameter, or positive this is greather than parameter
    */
    public int compareTo(Object other) {
        Dauntless d = (Dauntless) other;
        if (this.age != d.getAge()) {
            return this.age - d.getAge();
        } else if (!this.lastName.equals(d.getLastName())) {
            return this.lastName.compareTo(d.getLastName());
        } else if (!this.firstName.equals(d.getFirstName())) {
            return this.firstName.compareTo(d.getFirstName());
        } else if (this.agility != d.getAgility()) {
            return this.agility - d.getAgility();
        } else if (this.endurance != d.getEndurance()) {
            return this.endurance - d.getEndurance();
        } else {
            return 0;
        }
    }
}