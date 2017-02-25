import java.util.Scanner;
public class StringConverion {
    public static void main(String[] args) {
        String g;
        int countString = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Your Number: ");
        g = scan.next();
        if (g.equals("-1")) {
            System.out.print("Bye!");
        } else {
            for (int i = 0; i < g.length(); i++) {
                char temp = g.charAt(i);
                double lloyd = Character.getNumericValue(temp);
                lloyd = lloyd * Math.pow(10, (double) (g.length() - (i + 1)));
                countString = countString + (int) lloyd;
            }
        }
        System.out.println("Converted to: " + countString);
    }
}