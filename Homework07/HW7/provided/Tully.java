/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.awt.Rectangle;
/**
 * The Tully House for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class Tully extends NorthHouse {
    public static final int MAXAGE = 35;
    /**
    * Creates a new Tully
    * @param xPos the x-coordinate of the Tully
    * @param yPos the y-coordinate of the Tully
    * @param rectangle the rectangle that encompasses the Tully image
    */
    public Tully(int xPos, int yPos, Rectangle rectangle) {
        super(xPos, yPos, "trout.png", "Family, Duty, Honor", rectangle);
    }
    /**
    * Returns the Tully's MAXAGE
    * @return the Tully's MAXAGE
    */
    public static int getMaxAge() {
        return Tully.MAXAGE;
    }
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Stark) {
            return true;
        }
        return false;
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        if (otherHouse instanceof Lannister) {
            int temp = this.rand.nextInt(10) + 1;
            boolean check = this.collidesWithHouse(otherHouse);
            if (check && (temp == 1 || temp == 2)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isOld() {
        return this.age > Tully.MAXAGE;
    }
    @Override
    public Tully reproduceWithHouse(House otherHouse) {
        int pos1 = this.rand.nextInt(10) + 1;
        int pos2 = this.rand.nextInt(10) + 1;
        if (this.canReproduceWithHouse(otherHouse) && (pos1 == pos2)) {
            Tully temp = new Tully(this.xPos, this.yPos, this.rectangle);
            return temp;
        } else if (this.canReproduceWithHouse(otherHouse) && !(pos1 == pos2)) {
            return null;
        }
        return null;
    }
}