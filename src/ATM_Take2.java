
import java.util.*;
/**
 * Created by stevenburris on 9/18/16.
 */
public class ATM_Take2 {

    static HashMap<String, User> users = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        User user = new User("Steven", "1234", 100);
        users.put(user.userName, user);
        System.out.println("Welcome to your ATM.");
        boolean logIn = true;
        while (logIn){
            System.out.println("Please enter your name.");
            String name = scanner.nextLine();
            if (users.get(name) == null) {
                System.out.println("Would you like to create an account? Type y for yes or n for no");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    main(args);
                } else {
                    User user1 = new User(name, "1234", 100);
                    users.put(name, user1);
                    System.out.printf("Hello %s !\n", users.get(name).userName);
                    System.out.println("What would you like your password to be?");
                    String password = scanner.nextLine();
                    user1.password = password;
                    System.out.printf("And how much would you like to deposit %s?", users.get(user1).userName);
                    double deposit = scanner.nextDouble();
                    user1.balance = deposit;


                }
            } else {
                System.out.printf("Hello %s\n", users.get(name).userName);
                System.out.println("Please enter your password to proceed.");
                String pass = scanner.nextLine();
                if (!users.get(name).password.equalsIgnoreCase(pass)) {
                    System.out.println("I'm sorry, but your password is invalid.");
                }
                else if (users.get(name).password.equalsIgnoreCase(pass)) {
                    boolean running = true;
                    while (running) {
                        System.out.println("Please enter the number of the option you would like to perform today.\n");
                        System.out.println("1: Check my balance.");
                        System.out.println("2: Make a deposit.");
                        System.out.println("3: Make a withdrawal.");
                        System.out.println("4: Close my account.");
                        System.out.println("5: Administrative Options");
                        System.out.println("6: Log Out");
                        String options = scanner.nextLine();

                        switch (options) {

                            case "1":
                                System.out.println("Your current balance is $\n" + users.get(name).balance);
                                System.out.println("Would you like to make another transaction?");
                                System.out.println("Enter 1 for yes or 2 to log out.");
                                String transaction1 = scanner.nextLine();
                                if (!transaction1.equalsIgnoreCase("1")){
                                    System.out.println("Have a nice day!");
                                    System.out.println();
                                    running = false;
                                }
                                break;

                            case "2":
                                System.out.println("How much would you like to deposit?");
                                double depo = scanner.nextDouble();
                                users.get(name).balance = depo + users.get(name).balance;
                                System.out.println("Your new balance is $" + users.get(name).balance);
                                System.out.println();
                                System.out.println("Would you like to make another transaction?");
                                System.out.println();
                                System.out.println("Enter 1 for yes or 2 to log out.");
                                String newTransaction = scanner.nextLine();
                                scanner.nextLine();
                                if (!newTransaction.equalsIgnoreCase("1")){
                                    System.out.println("Have a nice day!");
                                    System.out.println();
                                    running = false;
                                }
                                break;

                            case "3":
                                System.out.println("How much would you like to withdrawal?");
                                double withdrawal = scanner.nextDouble();
                                users.get(name).balance = users.get(name).balance - withdrawal;
                                System.out.println("Your new balance is $" + users.get(name).balance);

                        }
                    }
                }
        }


        }
    }
}
