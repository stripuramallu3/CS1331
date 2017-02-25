/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.awt.Rectangle;
/**
 * The Virginia House for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class Virginia extends NorthHouse {
    public static final int MAXAGE = 27;
    /**
    * Creates a new Virginia
    * @param xPos the x-coordinate of the Virginia
    * @param yPos the y-coordinate of the Virginia
    * @param rectangle the rectangle that encompasses the Lannister Virginia
    */
    public Virginia(int xPos, int yPos, Rectangle rectangle) {
        super(xPos, yPos, "v.png", "Virginia is for Lovers", rectangle);
    }
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        int temp = rand.nextInt(20) + 1;
        if (temp >= 1 && temp <= 3) {
            return true;
        }
        return false;
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        boolean check = this.collidesWithHouse(otherHouse);
        int temp = this.rand.nextInt(20) + 1;
        if (check && (temp >= 0 && temp <= 7)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean isOld() {
        return this.age > Virginia.MAXAGE;
    }
    @Override
    public Virginia reproduceWithHouse(House otherHouse) {
        int pos1 = this.rand.nextInt(10) + 1;
        int pos2 = this.rand.nextInt(10) + 1;
        if (this.canReproduceWithHouse(otherHouse) && (pos1 == pos2)) {
            Virginia temp = new Virginia(this.xPos, this.yPos, this.rectangle);
            return temp;
        } else if (this.canReproduceWithHouse(otherHouse) && !(pos1 == pos2)) {
            return null;
        }
        return null;
    }
    /**
    * Returns the Virginia's MAXAGE
    * @return the Virginia's MAXAGE
    */
    public static int getMaxAge() {
        return Virginia.MAXAGE;
    }
}