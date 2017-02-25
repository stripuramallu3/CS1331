/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.awt.Rectangle;
/**
 * The Targaryan House for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public class Targaryan extends House {
    /**
    * Creates a new Targaryan
    * @param xPos the x-coordinate of the Targaryan
    * @param yPos the y-coordinate of the Targaryan
    * @param rectangle the rectangle that encompasses the Targaryan image
    */
    public Targaryan(int xPos, int yPos, Rectangle rectangle) {
        super(xPos, yPos, "dragon.png", "Fire and blood", rectangle);
    }
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Targaryan) {
            return true;
        }
        return false;
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        boolean check = this.collidesWithHouse(otherHouse);
        if (check && !(otherHouse instanceof Baratheon)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean isOld() {
        return false;
    }
    @Override
    public Targaryan reproduceWithHouse(House otherHouse) {
        int pos1 = this.rand.nextInt(10) + 1;
        int pos2 = this.rand.nextInt(10) + 1;
        if (this.canReproduceWithHouse(otherHouse) && (pos1 == pos2)) {
            Targaryan temp = new Targaryan(this.xPos, this.yPos,
                this.rectangle);
            return temp;
        } else if (this.canReproduceWithHouse(otherHouse) && !(pos1 == pos2)) {
            return null;
        }
        return null;
    }
}