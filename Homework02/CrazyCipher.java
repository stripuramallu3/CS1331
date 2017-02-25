import java.util.Scanner;
public class CrazyCipher {
    public static void main(String[] args) {
        int priunsh;
        String hemanth;
        char s1, s2, s3, s4, s5;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the CS1331 Crrrrrrazy Cipher :D!");
        System.out.println("What would you like to do?");
        System.out.println("1 - Encode");
        System.out.println("2 - Decode");
        System.out.println("3 - Quit");
        priunsh = scan.nextInt();
        if (priunsh == 1) {
            System.out.print("Ok. What would you like to encode?");
            hemanth = scan.next();
            s1 = hemanth.charAt(0);
            s2 = hemanth.charAt(1);
            s3 = hemanth.charAt(2);
            s4 = hemanth.charAt(3);
            s5 = hemanth.charAt(4);
            s2 = (char) (s2 + 4);
            s3 = (char) (s3 - 4);
            char temp = s4;
            s4 = s5;
            s5 = temp;
            System.out.println("Result:" + s1 + s2 + s3 + s4 + s5);
        } else if (priunsh == 2) {
            System.out.print("Ok. What would you like to decode?");
            hemanth = scan.next();
            s1 = hemanth.charAt(0);
            s2 = hemanth.charAt(1);
            s3 = hemanth.charAt(2);
            s4 = hemanth.charAt(3);
            s5 = hemanth.charAt(4);
            s2 = (char) (s2 - 4);
            s3 = (char) (s3 + 4);
            char temp = s5;
            s5 = s4;
            s4 = temp;
            System.out.println("Result:" + s1 + s2 + s3 + s4 + s5);
        }   else {
            System.out.println("Bye :D!");
        }
    }
}