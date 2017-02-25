public class CardDriver {
    public static void main(String[] args) {
        Card card1 = new Card(12345, "Card 1", "Lloyd", false, 40.0);

        System.out.println(card1.getcardNumber());
        System.out.println(card1.getcardName());
        System.out.println(card1.getcardOwner());
        System.out.println(card1.getisCredit());
        System.out.println(card1.getBalance());

        boolean update1 = card1.updateBalance(50.0);
        System.out.println("After update1, card balance is"
            + card1.getBalance());
        System.out.println(update1);
        boolean update2 = card1.updateBalance(30.0);
        System.out.println("After update2, card balance is"
            + card1.getBalance());
        System.out.println(update2);

        System.out.println(card1.toString());
    }
}