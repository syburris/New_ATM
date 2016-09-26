
import java.util.*;
/**
 * Created by stevenburris on 9/18/16.
 */
public class NewATM {

    static HashMap<String, User> users = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        //print out welcome and ask for username

        System.out.println("Welcome to the Iron Yard ATM!");
        System.out.println();
        System.out.println("Please log in by entering your name");
        String name = scanner.nextLine();
        boolean loggedIn = false;
        if (name.isEmpty()) {
            main(args);
        } else if (!users.containsKey(name)) {
            System.out.println("You do not have an account, would you like to make one?");
            System.out.println("Enter 1 to make an account or 2 to exit.");
            String createAccount = scanner.nextLine();
            if (createAccount.equalsIgnoreCase("1")) {
                User newUser = new User();
                System.out.println("Please enter your desired password");
                String password = scanner.nextLine();
                newUser.name = name;
                newUser.password = password;
                newUser.balance = 100;
                users.put(name, newUser);
                main(args);
            } else {
                main(args);
            }
        } else if (users.containsKey(name)) {
            System.out.println("Please enter your password:");
            String userPassword = scanner.nextLine();
            if (users.get(name).password.equals(userPassword)) {
                loggedIn = true;
                System.out.println("You have logged in!");
            }
            if (!users.get(name).password.equals(userPassword)) {
                System.out.println("Your password is invalid!");
                main(args);
            }
        }
        while (loggedIn) {
            System.out.println();
            System.out.printf("%s, please choose one of the following options:\n", users.get(name).name);
            System.out.println();
            System.out.println("1: Check my balance.");
            System.out.println("2: Make a deposit.");
            System.out.println("3: Make a withdrawal.");
            System.out.println("4: Close my account.");
            System.out.println("5: List all users and balances.");
            System.out.println("6: Log Out");

            String options = scanner.nextLine();

            switch (options) {

                case "1":
                    System.out.printf("%s, your current balance is $%s\n", users.get(name).name, users.get(name).balance);
                    System.out.println("Would you like to make another transaction?");
                    System.out.println("Enter 1 for yes or 2 for no:");
                    String newTransaction = scanner.nextLine();
                    if (newTransaction.equalsIgnoreCase("2")) {
                        System.out.println("Have a nice day!");
                        System.out.println();
                        main(args);
                    }
                    break;

                case "2":
                    System.out.println("How much would you like to deposit?");
                    double depo = scanner.nextDouble();
                    users.get(name).balance = depo + users.get(name).balance;
                    System.out.printf("%s, your new balance is $%s", users.get(name).name, users.get(name).balance);
                    System.out.println();
                    System.out.println("Would you like to make another transaction?");
                    System.out.println();
                    System.out.println("Enter 1 for yes or 2 to log out.");
                    String newTransaction1 = scanner.nextLine();
                    if (newTransaction1.equalsIgnoreCase("2")) {
                        System.out.println("Have a nice day!");
                        System.out.println();
                        if (newTransaction1.equalsIgnoreCase("1")) {

                        }
                    }
                    break;

                case "3":
                    System.out.println("How much would you like to withdrawal?");
                    double withdrawal = scanner.nextDouble();
                    users.get(name).balance = users.get(name).balance - withdrawal;
                    System.out.printf("%s, your new balance is $%s", users.get(name).name, users.get(name).balance);
                    System.out.println();
                    System.out.println("Would you like to make another transaction?");
                    System.out.println();
                    System.out.println("Enter 1 for yes or 2 to log out.");
                    String newTransaction2 = scanner.nextLine();
                    if (newTransaction2.equalsIgnoreCase("2")) {
                        System.out.println("Have a nice day!");
                        System.out.println();
                        main(args);
                    }
                    break;

                case "4":
                    System.out.printf("Are you sure you would like to close your account, %s?\n", users.get(name).name);
                    System.out.println("Please enter 1 to close your account or 2 to make another transaction.");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("1")) {
                        System.out.printf("We're sorry to see you go, %s!\n", users.get(name).name);
                        System.out.printf("Please take your $%s\n", users.get(name).balance);
                        users.remove(name);
                        main(args);
                    }

                case "5":
                    //User user = users.get(name);
                    System.out.printf("Here are all of the currently registered users and their balances, %s .\n", name);
                    for (String key : users.keySet()) {
                        System.out.println(users.get(key).name + " has a balance of $" + users.get(key).balance);
                    }

                    System.out.println("Would you like to make another transaction?");
                    System.out.println();
                    System.out.println("Enter 1 for yes or 2 to log out.");
                    String newTransaction3 = scanner.nextLine();
                    if (newTransaction3.equalsIgnoreCase("2")) {
                        System.out.println("Have a nice day!");
                        System.out.println();
                        main(args);
                    }
                    break;

                case "6":
                    System.out.printf("Thank you for your business, %s", name);
                    main(args);

            }

        }


    }
}
