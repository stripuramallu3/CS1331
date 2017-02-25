/*"In order to help learn course concepts, I worked on this homework with
myself, but discussed homework topics and issues with Lloyd Maza, and consulted
the TA Help Desk for issues with certain material. I also refered to the JAVA 8
API in order to have better knowledge of methods/classes.**/

import java.util.Scanner;
import java.util.Random;
public class LemonadeTycoon {
    private static enum Weather { EXTRA_SUNNY, NORMAL, CLOUDY, RAINING };
    private static int popularity = 50;
    private static double satisfaction = 50;
    private static double salesRate = 1;
    private static double menuPriceTotal = 0.0;
    private static Scanner kybd = new Scanner(System.in);
    //Declare and initialize the menu below
    private static String[][] menu = new String[1][10];
    private static int itemCounter = -1;
    private static Weather forecast;
    public static void main(String[] args) {
        int days = 0;
        int menuCounter = 0;
        System.out.println("Welcome to Lemonade Tycoon!");
        System.out.print("Name your Lemonade Stand: ");
        String stand = kybd.nextLine();
        System.out.println("You have named your Lemonade Stand " + stand + ".");
        boolean cont = true;
        int choice;
        while (cont) {
            System.out.println("Day " + days);
            if (days == 0 && menuCounter == 0) {
                weatherForecast();
                System.out.print("Today the weather will be like: ");
                System.out.println(forecast.toString());
            }
            System.out.println("What would you like to do?");
            System.out.println("1. View Menu Actions\n2. "
                + "End day\n3. Quit Game");
            choice = kybd.nextInt();
            menuCounter++;
            if (choice == 1) {
                System.out.println("Menu Actions. Select one of the"
                    + " following:");
                System.out.println("1. Check Menu\n2. Add to Menu");
                System.out.println("3. Change prices");
                System.out.println("4. Cancel");
                int selection = kybd.nextInt();
                if (selection == 1) {
                    checkMenu();
                } else if (selection == 2) {
                    System.out.print("What would you like to name your item?");
                    System.out.println();
                    kybd.nextLine();
                    String name = kybd.nextLine();
                    System.out.print("How much will your item cost? ");
                    double price = kybd.nextDouble();
                    addToMenu(name, price);
                } else if (selection == 3) {
                    System.out.print("What is the name of the item you would");
                    System.out.println(" like to change the price of?");
                    kybd.nextLine();
                    String itemName = kybd.nextLine();
                    changePrice(itemName);
                }
            } else if (choice == 2) {
                days++;
                //Edit the output below to include the total profits made today
                System.out.println("Day ended.");
                System.out.print("The total profits made today are: ");
                System.out.printf("$%.2f", getProfits());
                System.out.println();
                //Make a call to the weather forecast method below. Make sure to
                //let the player know what the weather will be like today!
                weatherForecast();
                //String tempForecast = forecast.toString();
                System.out.print("Today the weather will be like: ");
                System.out.println(forecast.toString());
            } else {
                System.out.println("Good Bye!");
                cont = false;
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////
    //                 Methods for aspects of gameplay                     //
    /////////////////////////////////////////////////////////////////////////

    /**
    * Prints the entire menu out to the console.
    *
    * @return void
    **/
    private static void checkMenu() {
        String tempS = new String("");
        if (itemCounter == -1) {
            System.out.println("Sorry, there is nothing in the menu.");
        } else {
            for (int i = 0; i <= itemCounter; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        tempS = tempS + menu[i][j] + ": ";
                    } else if (j >= 1 && j <= 8) {
                        if (menu[i][j].length() > 0) {
                            tempS = tempS + menu[i][j] + ", ";
                        }
                    } else if (j == menu[i].length - 1) {
                        tempS = tempS.substring(0, tempS.length() - 2);
                        System.out.print(tempS);
                        Double tempPrice = Double.parseDouble(menu[i][j]);
                        System.out.printf(" $%.2f", tempPrice);
                        System.out.println();
                        tempS = "";
                    }
                }
            }
        }
    }
    /**
    * Method that adds an item and its price to the menu.
    * Uses system I/O to collect ingredient names as well.
    *
    * @param String name of the item, double price
    * @return void
    **/
    private static void addToMenu(String itemName, double price) {
        boolean checker = true;
        for (int i = 0; i < menu.length && checker; i++) {
            if (itemName.equalsIgnoreCase(menu[i][0])) {
                System.out.println("Sorrrrry! that item alredy exists.");
                checker = false;
            }
        }
        String v0 = "";
        String v1 = "";
        String v2 = "";
        String v3 = "";
        String v4 = "";
        String v5 = "";
        String v6 = "";
        String v7 = "";
        int counter = 1;
        boolean keepCollecting = true;
        System.out.println("In order to stop adding ingredients, type \"N\"");
        kybd.nextLine();
        while (keepCollecting && checker) {
            System.out.println("What ingredient would you like to add? ");
            String in = kybd.nextLine();
            if (!(in.equals("N")) && counter != 8) {
                switch (counter) {
                case 0:
                    v0 = in;
                    break;
                case 1:
                    v1 = in;
                    break;
                case 2:
                    v2 = in;
                    break;
                case 3:
                    v3 = in;
                    break;
                case 4:
                    v4 = in;
                    break;
                case 5:
                    v5 = in;
                    break;
                case 6:
                    v6 = in;
                    break;
                case 7:
                    v7 = in;
                    break;
                default:
                    break;
                }
                counter++;
            } else {
                keepCollecting = false;
            }
        }
        if (counter == 8) {
            System.out.print("You have entered the maximum number ");
            System.out.println("of ingredients");
        }
        itemCounter++;
        String[] tempA = {itemName, v0, v1, v2, v3, v4, v5, v6, v7, price + ""};
        if (itemCounter == menu.length) {
            String[][] tempMenu = new String[menu.length + 1][10];
            for (int i = 0; i < menu.length; i++) {
                for (int j = 0; j < menu[i].length; j++) {
                    tempMenu[i][j] = menu[i][j];
                }
            }
            menu = tempMenu;
        }
        for (int i = 0; i < 10; i++) {
            menu[itemCounter][i] = tempA[i];
        }
        menuPriceTotal +=  price;
        v0 = "";
        v1 = "";
        v2 = "";
        v3 = "";
        v4 = "";
        v5 = "";
        v6 = "";
        v7 = "";
    }

    /**
    * Method that changes the price of the item given as input.
    *
    *@param String name of the item
    *@return void
    **/
    private static void changePrice(String itemName) {
        //YOUR CODE HERE FOR ADJUSTING PRICE
        boolean checker = false;
        System.out.print("What would you like the new price to be?");
        double newPrice = kybd.nextDouble();
        for (int i = 0; i < menu.length; i++) {
            if (itemName.equalsIgnoreCase(menu[i][0])) {
                Double tempP = Double.parseDouble(menu[i][menu[i].length - 1]);
                menuPriceTotal = menuPriceTotal + newPrice - tempP;
                menu[i][menu[i].length - 1] = newPrice + "";
                checker = true;
            }
        }
        if (!checker) {
            System.out.print(itemName + " is not in the menu.");
            System.out.println(" Here is the base menu: ");
            checkMenu();
        } else {
            System.out.println("The price has been updated.");
        }
    }
    /**
    * Method that randomly determines the weather
    * and prints it out for the player to see.
    * If a weather is chosen that affects popularity,
    * sales, or satisfaction, you should change it here
    * as well.
    *
    * @return void
    **/
    public static void weatherForecast() {
        //YOUR CODE HERE
        //This part is a little tricky, so start thinking about his early!
        Random rand = new Random();
        int temp = rand.nextInt(4);
        forecast = Weather.values()[temp];
        switch (forecast) {
        case EXTRA_SUNNY:
            popularity += rand.nextInt(11);
            break;
        case NORMAL:
            salesRate = 1.0;
            popularity = 50;
            satisfaction = 50;
            break;
        case CLOUDY:
            satisfaction -= rand.nextInt(11);
            if (satisfaction < 0) {
                satisfaction = 0;
            }
            break;
        default:
            salesRate *= rand.nextDouble();
            break;
        }
    }
    private static double getProfits() {
        return (popularity + satisfaction) * 0.1 * (salesRate * menuPriceTotal);
    }
}