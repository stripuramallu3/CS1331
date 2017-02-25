/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;
/**
 * The abstract House for the Game of Thrones Simulation
 * @author Sreerama Tripuramallu
 * @version 1.0
 */
public abstract class House {
    protected ImageIcon image;
    protected String imageFilename;
    protected Random rand = new Random();
    protected int health = 100;
    protected int age = 0;
    protected int xPos;
    protected int yPos;
    protected int speed = 0;
    protected String words;
    protected Rectangle rectangle;
    /**
    * Creates a new House object
    * @param xPos the x-coordinate of the house
    * @param yPos the y-coordinate of the house
    * @param image the name of the image file
    * @param words the words of the house
    * @param rectangle the rectangle that encompasses the house image
    */
    public House(int xPos, int yPos, String image, String words,
         Rectangle rectangle) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.words = words;
        this.image = new ImageIcon(image);
        this.rectangle = new Rectangle(this.xPos, this.yPos,
         this.image.getIconWidth(), this.image.getIconHeight());
    }
    /**
    * Gets the rectangle that encompasses the image
    * @return the rectangle
    */
    public Rectangle getRectangle() {
        return this.rectangle;
    }
    /**
    * Gets the health of the house
    * @return the health
    */
    public int getHealth() {
        return this.health;
    }
    /**
    * Gets the age of the house
    * @return the age
    */
    public int getAge() {
        return this.age;
    }
    /**
    * Gets the x-coordinate of the house
    * @return the x-coordinate
    */
    public int getXPos() {
        return this.xPos;
    }
    /**
    * Gets the y-coordinate of the house
    * @return the y-coordinate
    */
    public int getYPos() {
        return this.yPos;
    }
    /**
    * Gets the speed of the house
    * @return the speed
    */
    public int getSpeed() {
        return this.speed;
    }
    /**
    * Gets the words of the house
    * @return the words
    */
    public String getWords() {
        return this.words;
    }
    /**
    * Gets the image of the house
    * @return the image
    */
    public ImageIcon getImage() {
        return this.image;
    }
    /**
    * Sets the health of the House
    * @param health the new health
    */
    public void setHealth(int health) {
        this.health = health;
    }
    /**
    * Sets the age of the House
    * @param age the new health
    */
    public void setAge(int age) {
        this.age = age;
    }
    /**
    * Sets the speed of the House
    * @param speed the new health
    */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
    * Randomly moves the house to a new location
    */
    public void move() {
        this.xPos = this.rand.nextInt(Westeros.WIDTH);
        this.yPos = this.rand.nextInt(Westeros.HEIGHT);
        health--;
        age++;
    }
    /**
    * Checks if the house intersets with another house
    * @param otherHouse the other House
    * @return true if house intersects with other house
    */
    public boolean collidesWithHouse(House otherHouse) {
        return this.rectangle.intersects(otherHouse.getRectangle());
    }
    /**
    * Checks if House can reporduce with another House
    * @param otherHouse the other House
    * @return true if house can reporduce with other house
    */
    public abstract boolean canReproduceWithHouse(House otherHouse);
    /**
    * Produces a new House if house can reproduce
    * @param otherHouse the other house
    * @return House if a new house is created
    */
    public abstract House reproduceWithHouse(House otherHouse);
    /**
    * Checks if house exceeded the maximum age
    * @return true if house exceeded the maximum age
    */
    public abstract boolean isOld();
    /**
    * Checks if house can harm otherHouse;
    * @param otherHouse the other house
    * @return true if the house can harm the other house
    */
    public abstract boolean canHarmHouse(House otherHouse);
    /**
    * Harms the other house
    * @param otherHouse the house being harmed
    */
    public void harmHouse(House otherHouse) {
        if (this.canHarmHouse(otherHouse) && !this.isDead()) {
            otherHouse.setHealth(otherHouse.getHealth() - 40);
        }
    }
    /**
    * Kills the house
    */
    public void die() {
        this.health = 0;
    }
    /**
    * Checks if the house is dead
    * @return true if the house is dead
    */
    public boolean isDead() {
        if (this.health == 0 || (isOld())) {
            return true;
        }
        return false;
    }

    /**
     * Should draw the House at its location.
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
}
