/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.awt.Rectangle;
/**
 * The abstract NorthHouse for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public abstract class NorthHouse extends House {
    /**
    *Creates a North House
    * @param xPos the x-coordinate of the north house
    * @param yPos the y-coordinate of the north house
    * @param image the String that represents the image name
    * @param words the words of the north house instance
    * @param rectangle the rectangle that encompasses the north house image
    */
    public NorthHouse(int xPos, int yPos, String image, String words,
         Rectangle rectangle) {
        super(xPos, yPos, image, words, rectangle);
    }
    @Override
    public abstract House reproduceWithHouse(House otherHouse);
    @Override
    public abstract boolean canReproduceWithHouse(House otherHouse);
    @Override
    public abstract boolean canHarmHouse(House otherHouse);
    @Override
    public abstract boolean isOld();
    @Override
    public void move() {
        this.xPos = this.rand.nextInt(Westeros.WIDTH);
        this.yPos = this.rand.nextInt(Westeros.HEIGHT);
        if (yPos >= 0 && yPos <= (Westeros.WIDTH / 2) - 1) {
            health++;
            age++;
        } else {
            health--;
            age++;
        }
    }

}