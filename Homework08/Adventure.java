/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
/**
* The class Adventure that simulates a Pokemon journey
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Adventure {
    private static final int TOTAL = 151;
    private String[] allPokemon = new String[TOTAL];
    private String[] pokedex = new String[TOTAL];
    private String[] party = new String[6];
    private Random rand = new Random();
    private int steps = 0;
    private int pokemonCounter = 0;
    private Scanner inputStream;
    private PrintWriter outputStream;
    private Scanner scan = new Scanner(System.in);
    /**
    * Creates a new Adventure
    * @param fileName the name of the pokedex file
    */
    public Adventure(String fileName) throws UnknownRegionException {
        try {
            this.inputStream = new Scanner(new FileInputStream(fileName));
            this.outputStream = new PrintWriter(new FileOutputStream(
                 "Pokedex.txt"));
            for (int i = 0; i < allPokemon.length && inputStream.hasNextLine();
                 i++) {
                allPokemon[i] = inputStream.nextLine();
            }
            this.inputStream.close();
            this.outputStream.close();
        } catch (FileNotFoundException e) {
            throw new UnknownRegionException();
        }
    }
    /**
    * Moves a random number of steps
    */
    public void walkAround() {
        int s = rand.nextInt(10) + 1;
        this.steps += s;
        if (s >= 1 && s < 10) {
            encounter();
        } else {
            System.out.println("No Wild Pokemon encounted!");
        }
    }
    private void encounter() {
        int index = rand.nextInt(TOTAL);
        System.out.println("A wild " + allPokemon[index] + " appeared");
        addToPokedex(allPokemon[index], index);
        this.pokemonCounter++;
        int addParty = rand.nextInt(10) + 1;
        if (addParty >= 1 && addParty <= 7) {
            System.out.println("Would you like to add " + allPokemon[index]
                 + " to your party? (y/n)");
            String temp = scan.nextLine();
            if (temp.equals("y")) {
                addToParty(allPokemon[index]);
            }
        } else {
            System.out.println("Sorry, you cannot add " + allPokemon[index]
                 + " to your party");
        }
    }
    private void addToPokedex(String name, int index) throws
     PokemonAlreadyExistsException {
        if (pokedex[index] == null) {
            pokedex[index] = name;
            System.out.println("a new Pokedex entry was made for "
                 + allPokemon[index]);
        } else {
            throw new PokemonAlreadyExistsException();
        }
    }
    private void addToParty(String name)  throws PartyIsFullException,
     PokemonAlreadyExistsException {
        int nullPosition = 0;
        boolean temp = false;
        for (int i = 0; i < party.length && !temp; i++) {
            if (party[i] == null) {
                temp = true;
                nullPosition = i;
            }
        }
        if (!temp) {
            throw new PartyIsFullException();
        }
        for (int i = 0; i < party.length && party != null; i++) {
            if (name.equals(party[i])) {
                throw new PokemonAlreadyExistsException();
            }
        }
        party[nullPosition] = name;
        System.out.println(name + " was added to your party!");
    }
    /**
    * Reports the number of steps and pokemon encountered to Oak
    */
    public void reportToProfessorOak() {
        System.out.println("Professor Oak, I've taken " + this.steps
             + " steps and there are " + this.pokemonCounter
             + " Pokemon in my Pokedex");
    }
    /**
    * Displays the party pokemon
    */
    public void viewParty() {
        int temp = -1;
        for (int i = 0; i < this.party.length; i++) {
            if (this.party[i] != null) {
                System.out.println(this.party[i]);
            } else {
                temp++;
            }
        }
        if (temp == party.length - 1) {
            System.out.println("There are no Pokemon in your party.");
        }
    }
    /**
    * Ends he adventure by printing out of the pokedex, which represents all of
    * the encountered pokemon
    */
    public void endAdventure() {
        try {
            this.outputStream = new PrintWriter(new FileOutputStream(
                 "Pokedex.txt", true));
            for (int i = 0; i < this.pokedex.length; i++) {
                if (this.pokedex[i] == null) {
                    this.outputStream.println();
                } else {
                    this.outputStream.println(this.pokedex[i]);
                }
            }
            this.outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}