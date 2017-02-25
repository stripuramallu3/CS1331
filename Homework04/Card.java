/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/
import java.text.NumberFormat;
public class Card {
    private final int cardNumber;
    private String cardName;
    private final String cardOwner;
    private final boolean isCredit;
    private double balance;

    public Card(int cardNumber, String cardName, String cardOwner, boolean
        isCredit, double balance) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardOwner = cardOwner;
        this.isCredit = isCredit;
        this.balance = balance;
    }
    public Card(Card card) {
        this(card.cardNumber, card.cardName, card.cardOwner, card.isCredit,
            card.balance);
    }

    public int getcardNumber() {
        return cardNumber;
    }

    public String getcardName() {
        return cardName;
    }

    public String getcardOwner() {
        return cardOwner;
    }

    public boolean getisCredit() {
        return isCredit;
    }

    public double getBalance() {
        return balance;
    }

    public boolean updateBalance(double spent) {
        double tempBalance = balance - spent;
        if (isCredit && validBalance(tempBalance)) {
            this.balance -= spent;
            return true;
        } else if (isCredit && !validBalance(tempBalance)) {
            return false;
        } else if (!isCredit && validBalance(tempBalance)) {
            this.balance -= spent;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        if (isCredit) {
            String tempString = new String("");
            tempString = "Card Type: Credit Card." + " The name is: ";
            tempString = tempString + cardName + ". The owner is ";
            tempString = tempString + cardOwner + ". The balance is: ";
            tempString = tempString + cf.format(balance);
            return tempString;
        } else {
            String tempString = new String("");
            tempString = "Card Type: Debit Card." + " The name is: ";
            tempString = tempString + cardName + ". The owner is ";
            tempString = tempString + cardOwner + ". The balance is: ";
            tempString = tempString + cf.format(balance);
            return tempString;
        }
    }

    private boolean validBalance(double possibleNewBalance) {
        if (isCredit) {
            return possibleNewBalance <= 0;
        } else if (!isCredit) {
            return possibleNewBalance >= 0;
        }
        return false;
    }
}

