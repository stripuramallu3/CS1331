/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.util.Scanner;
public class Wallet {
    private final String owner;
    private String password;
    private Card[] cards;
    private int numCards;
    private double balance;


    public Wallet(String owner, String password) {
        this(owner, password, null);
    }

    public Wallet(String owner, String password, Card[] cards) {
        this.owner = owner;
        this.password = password;
        this.cards = cards;
        if (cards == null) {
            this.cards = new Card[10];
            updateBalance();
        }
    }
    public double getBalance() {
        return balance;
    }
    public String getOwner() {
        return owner;
    }
    private int cardNumberCounter(Card[] cards) {
        int cardNumber = -1;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                cardNumber++;
            }
        }
        return cardNumber;
    }
    public void add(Card[] newCards) {
        for (int i = 0; i < newCards.length; i++) {
            if (newCards[i] != null && newCards[i].getcardOwner().equals(owner)
                 && numCards <= 9) {
                cards[numCards] = newCards[i];
                numCards++;
                this.balance = 0;
                updateBalance();
            } else if (newCards[i] != null) {
                System.out.println("This card was not added: ");
                System.out.println(newCards[i]);
            }
        }
        System.out.println("The new balance is: " + this.balance);
    }
    public void buy(double price, String cardName) {
        int counter = 0;
        if (validate()) {
            if (cardIsPresent(cardName)) {
                for (int i = 0; i < this.cards.length && this.cards[i] != null;
                     i++) {
                    if (this.cards[i].getcardName().equals(cardName)) {
                        counter = i;
                    }
                }
                Card temp = new Card(this.cards[counter]);
                boolean checker = temp.updateBalance(price);
                if (!checker) {
                    System.out.println("Sorry the purchase cannot be made");
                } else {
                    this.cards[counter] = temp;
                    System.out.println("The purchase was made.");
                    System.out.print("The new balance is: ");
                    this.balance = 0;
                    updateBalance();
                    System.out.println(balance);
                }
            } else {
                System.out.println("The specified card is not in the wallet.");
            }
        }
    }
    public String toString() {
        String tempString = new String("");
        for (int i = 0; i < this.cards.length && this.cards[i] != null; i++) {
            tempString = tempString + this.cards[i].toString() + "\n ";
        }
        return tempString;
    }
    private void updateBalance() {
        for (int i = 0; i < this.cards.length; i++) {
            if (this.cards[i] != null) {
                this.balance += this.cards[i].getBalance();
            }
        }
    }
    private boolean validate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the wallet's password? ");
        String tempPassword = scan.nextLine();
        if (tempPassword.equals(this.password)) {
            return true;
        } else {
            System.out.println("Sorry, you have entered the wrong password.");
            return false;
        }
    }
    private boolean cardIsPresent(String cardName) {
        for (int i = 0; i < this.cards.length; i++) {
            if (this.cards[i] != null
                 && this.cards[i].getcardName().equals(cardName)) {
                return true;
            }
        }
        return false;
    }

}