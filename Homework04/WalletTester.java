public class WalletTester {
    public static void main(String[] args) {
        Card[] cardSet = new Card[10];
        cardSet[0] = new Card(12345, "Card 1", "Lloyd", false, 40.0);
        cardSet[1] = new Card(67890, "Card 2", "Lloyd Maza", true, 0.0);
        cardSet[2] = new Card(23456, "Card 3", "Me", false, 40.0);
        cardSet[3] = new Card(78901, "Card 4", "Lloyd", true, -10.0);
        cardSet[4] = new Card(34567, "Card 5", "Lloyd", false, 0.0);
        cardSet[5] = new Card(89012, "Card 6", "You", true, -100.0);
        cardSet[6] = new Card(45678, "Card 7", "Him", false, 0.0);
        cardSet[7] = new Card(90123, "Card 8", "Her", true, -40.0);

        Wallet wallet1 = new Wallet("Lloyd", "Lloyd", cardSet);
        System.out.println("Wallet 1 balance: " + wallet1.getBalance());
        System.out.println("Should be equal to -70.0");
        System.out.println("Wallet 1 owner: " + wallet1.getOwner());
        System.out.println();

        Card[] newCards = new Card[6];
        newCards[0] = new Card(12345, "Card 9", "Lloyd", false, 40.0);
        newCards[1] = new Card(67890, "Card 10", "Lloyd", true, 0.0);
        newCards[2] = new Card(23456, "Card 11", "Lloyd", false, 40.0);
        newCards[3] = new Card(78901, "Card 12", "Him", true, -10.0);
        newCards[4] = new Card(34567, "Card 13", "Lloyd", false, 0.0);
        newCards[5] = new Card(89012, "Card 14", "You", true, -100.0);

        wallet1.add(newCards);
        System.out.println("4 cards should have been listed"
            + "as unable to be added");
        System.out.println("Wallet 1 new balance: " + wallet1.getBalance());
        System.out.println("Should be equal to -30.0");
        System.out.println();

        System.out.println("Input the wrong password here:");
        wallet1.buy(50, "Card 1");
        System.out.println();

        System.out.println("Now use the right password, \"Lloyd\"");
        wallet1.buy(50, "Card 1");
        System.out.println("The above should have failed to purchase");
        wallet1.buy(10, "Card 20");
        System.out.println("The above should have failed to purchase");
        wallet1.buy(10, "Card 1");
        System.out.println();

        System.out.println("The final balance is: " + wallet1.getBalance());
        System.out.println("Should be equal to -40.0");


        Wallet constTest = new Wallet("Him", "Him");
        System.out.println("Constructor test wallet balance: "
            + constTest.getBalance());

    }
}