/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
/**
*This abstract class represents a Factioned
* @author Sreerama Tripuramallu
* @version 1.0
*/
public abstract class Factioned extends Person {
    protected Faction faction;
    /**
    * Creates a new Factioned object
    * @param firstName first name of the factioned
    * @param lastName last name of the factioned
    * @param age age of the factioned
    * @param f faction of the factioned
    */
    public Factioned(String firstName, String lastName, int age, Faction f)  {
        super(firstName, lastName, age);
        this.faction = f;
    }
    /**
    * Creates a new Factioned object
    * @param firstName first name of the factioned
    * @param lastName last name of the factioned
    * @param f faction of the factioned
    */
    public Factioned(String firstName, String lastName, Faction f) {
        this(firstName, lastName, 0, f);
    }
    /**
    * Gets the faction of the factioned
    * @return the faction
    */
    public Faction getFaction() {
        return this.faction;
    }
}