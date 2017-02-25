/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.awt.Rectangle;
/**
 * The Lannister House for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class Lannister extends SouthHouse {
    public static final int MAXAGE = 20;
    /**
    * Creates a new Lannister
    * @param xPos the x-coordinate of the Lannister
    * @param yPos the y-coordinate of the Lannister
    * @param rectangle the rectangle that encompasses the Lannister image
    */
    public Lannister(int xPos, int yPos, Rectangle rectangle) {
        super(xPos, yPos, "lion.png", "Hear me roar!", rectangle);
    }
    /**
    * Returns the Lannister's MAXAGE
    * @return the Lannister's MAXAGE
    */
    public static int getMaxAge() {
        return Lannister.MAXAGE;
    }
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        if ((otherHouse instanceof Baratheon)
             || (otherHouse instanceof Lannister)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        int temp = this.rand.nextInt(10) + 1;
        boolean check = this.collidesWithHouse(otherHouse);
        if (otherHouse instanceof Stark) {
            if (check && (temp >= 1 && temp <= 6)) {
                return true;
            }
        } else if (otherHouse instanceof Tully) {
            if (check && (temp >= 1 && temp <= 8)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isOld() {
        return this.age > Lannister.MAXAGE;
    }
    @Override
    public Lannister reproduceWithHouse(House otherHouse) {
        int pos1 = this.rand.nextInt(10) + 1;
        int pos2 = this.rand.nextInt(10) + 1;
        if (this.canReproduceWithHouse(otherHouse) && (pos1 == pos2)) {
            Lannister temp = new Lannister(this.xPos, this.yPos,
                this.rectangle);
            return temp;
        } else if (this.canReproduceWithHouse(otherHouse) && !(pos1 == pos2)) {
            return null;
        }
        return null;
    }

}