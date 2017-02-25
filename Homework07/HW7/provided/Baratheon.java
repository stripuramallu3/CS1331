/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.awt.Rectangle;
/**
 * The Baratheon House for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class Baratheon extends SouthHouse {
    public static final int MAXAGE = 25;
    /**
    * Creates a new Baratheon
    * @param xPos the x-coordinate of the Baratheon
    * @param yPos the y-coordinate of the Baratheon
    * @param rectangle the rectangle that encompasses the Baratheon image
    */
    public Baratheon(int xPos, int yPos, Rectangle rectangle) {
        super(xPos, yPos, "stag.png", "Ours is the fury", rectangle);
    }
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Lannister) {
            return true;
        }
        return false;
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        boolean check = this.collidesWithHouse(otherHouse);
        if (check && (otherHouse instanceof Targaryan)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean isOld() {
        return this.age > Baratheon.MAXAGE;
    }
    @Override
    public Baratheon reproduceWithHouse(House otherHouse) {
        int pos1 = this.rand.nextInt(10) + 1;
        int pos2 = this.rand.nextInt(10) + 1;
        if (this.canReproduceWithHouse(otherHouse) && (pos1 == pos2)) {
            Baratheon temp = new Baratheon(this.xPos, this.yPos,
                this.rectangle);
            return temp;
        } else if (this.canReproduceWithHouse(otherHouse) && !(pos1 == pos2)) {
            return null;
        }
        return null;
    }
    /**
    * Returns the Baratheon's MAXAGE
    * @return the Baratheon's MAXAGE
    */
    public static int getMaxAge() {
        return Baratheon.MAXAGE;
    }
}