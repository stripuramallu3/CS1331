/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.awt.Rectangle;
/**
 * The Stark House for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class Stark extends NorthHouse {
    public static final int MAXAGE = 30;
    /**
    * Creates a new Stark
    * @param xPos the x-coordinate of the Stark
    * @param yPos the y-coordinate of the Stark
    * @param rectangle the rectangle that encompasses the Stark image
    */
    public Stark(int xPos, int yPos, Rectangle rectangle) {
        super(xPos, yPos, "direwolf.png", "Winter is Coming", rectangle);
    }
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Tully) {
            return true;
        }
        return false;
    }
    /**
    * Returns the Stark's MAXAGE
    * @return the Stark's MAXAGE
    */
    public static int getMaxAge() {
        return Stark.MAXAGE;
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        if (otherHouse instanceof Lannister) {
            int temp = this.rand.nextInt(10) + 1;
            boolean check = this.collidesWithHouse(otherHouse);
            if (check && (temp >= 1 && temp <= 4)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isOld() {
        return this.age > Stark.MAXAGE;
    }
    @Override
    public Stark reproduceWithHouse(House otherHouse) {
        int pos1 = this.rand.nextInt(10) + 1;
        int pos2 = this.rand.nextInt(10) + 1;
        if (this.canReproduceWithHouse(otherHouse) && (pos1 == pos2)) {
            Stark temp = new Stark(this.xPos, this.yPos, this.rectangle);
            return temp;
        } else if (this.canReproduceWithHouse(otherHouse) && !(pos1 == pos2)) {
            return null;
        }
        return null;
    }
}