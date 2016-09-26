
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
                users.put(name, newUser);
                newUser.name = name;
                newUser.password = password;
                newUser.balance = 100;
                main(args);
            } else {
                main(args);
            }
        }
        else if (users.containsKey(name)) {
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
            System.out.printf("%s, please choose one of the following options:\n",users.get(name).name);
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
                    System.out.printf("%s, your current balance is $%s\n",users.get(name).name,users.get(name).balance);
                    System.out.println("Would you like to make another transaction?");
                    System.out.println("Enter 1 for yes or 2 for no:");
                    String newTransaction = scanner.nextLine();
                    if (newTransaction.equalsIgnoreCase("2")){
                        System.out.println("Have a nice day!");
                        System.out.println();
                        main(args);
                    }
                    break;

                case "2":
                    System.out.println("How much would you like to deposit?");
                    double depo = scanner.nextDouble();
                    users.get(name).balance = depo + users.get(name).balance;
                    System.out.printf("%s, your new balance is $%s",users.get(name).name ,users.get(name).balance);
                    System.out.println();
                    System.out.println("Would you like to make another transaction?");
                    System.out.println();
                    System.out.println("Enter 1 for yes or 2 to log out.");
                    String newTransaction1 = scanner.nextLine();
                    scanner.nextLine();
                    if (newTransaction1.equalsIgnoreCase("2")){
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
                    System.out.printf("%s, your new balance is $%s",users.get(name).name ,users.get(name).balance);
                    System.out.println();
                    System.out.println("Would you like to make another transaction?");
                    System.out.println();
                    System.out.println("Enter 1 for yes or 2 to log out.");
                    String newTransaction2 = scanner.nextLine();
                    scanner.nextLine();
                    if (newTransaction2.equalsIgnoreCase("2")){
                        System.out.println("Have a nice day!");
                        System.out.println();
                        main(args);
                    }
                    break;

                case "4" :
                    System.out.printf("Are you sure you would like to close your account, %s?\n",users.get(name).name);
                    System.out.println("Please enter 1 to close your account or 2 to make another transaction.");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("1")) {
                        System.out.printf("We're sorry to see you go, %s!\n", users.get(name).name);
                        System.out.printf("Please take your $%s\n",users.get(name).balance);
                        users.remove(name);
                        main(args);
                    }

                case "5" :
                    System.out.printf("Here are all of the currently registered users and their balances, %s .\n", name);
                    ArrayList<User> userNames = new ArrayList<>();
                    for (User user : userNames) {
                        userNames.add(users.get(user.name));
                    }
                    int index = 0;
                    for (User user :userNames) {
                        System.out.println(userNames.get(index).name + " has a balance of $" + userNames.get(index).balance);
                        index++;
                    }

                    System.out.println("Would you like to make another transaction?");
                    System.out.println();
                    System.out.println("Enter 1 for yes or 2 to log out.");
                    String newTransaction3 = scanner.nextLine();
                    scanner.nextLine();
                    if (newTransaction3.equalsIgnoreCase("2")){
                        System.out.println("Have a nice day!");
                        System.out.println();
                        main(args);
                    }
                    break;

                case "6" :
                    System.out.printf("Thank you for your business, %s", name);
                    main(args);

            }

        }



    }
//        while (logIn){
//            System.out.println("Please enter your name.");
//            String name = scanner.nextLine();
//            if (users.get(name) == null) {
//                System.out.println("Would you like to create an account? Type y for yes or n for no");
//                String choice = scanner.nextLine();
//                if (choice.equalsIgnoreCase("n")) {
//                    main(args);
//                } else {
//                    User user1 = new User(name, "1234", 100);
//                    users.put(name, user1);
//                    System.out.printf("Hello %s !\n", users.get(name).userName);
//                    System.out.println("What would you like your password to be?");
//                    String password = scanner.nextLine();
//                    user1.password = password;
//                    System.out.printf("And how much would you like to deposit %s?", users.get(user1).userName);
//                    double deposit = scanner.nextDouble();
//                    user1.balance = deposit;
//
//
//                }
//            } else {
//                System.out.printf("Hello %s\n", users.get(name).userName);
//                System.out.println("Please enter your password to proceed.");
//                String pass = scanner.nextLine();
//                if (!users.get(name).password.equalsIgnoreCase(pass)) {
//                    System.out.println("I'm sorry, but your password is invalid.");
//                }
//                else if (users.get(name).password.equalsIgnoreCase(pass)) {
//                    boolean running = true;
//                    while (running) {
//                        System.out.println("Please enter the number of the option you would like to perform today.\n");
//                        System.out.println("1: Check my balance.");
//                        System.out.println("2: Make a deposit.");
//                        System.out.println("3: Make a withdrawal.");
//                        System.out.println("4: Close my account.");
//                        System.out.println("5: Administrative Options");
//                        System.out.println("6: Log Out");
//                        String options = scanner.nextLine();
//
//                        switch (options) {
//
//                            case "1":
//                                System.out.println("Your current balance is $\n" + users.get(name).balance);
//                                System.out.println("Would you like to make another transaction?");
//                                System.out.println("Enter 1 for yes or 2 to log out.");
//                                String transaction1 = scanner.nextLine();
//                                if (!transaction1.equalsIgnoreCase("1")){
//                                    System.out.println("Have a nice day!");
//                                    System.out.println();
//                                    running = false;
//                                }
//                                break;
//
//                            case "2":
//                                System.out.println("How much would you like to deposit?");
//                                double depo = scanner.nextDouble();
//                                users.get(name).balance = depo + users.get(name).balance;
//                                System.out.println("Your new balance is $" + users.get(name).balance);
//                                System.out.println();
//                                System.out.println("Would you like to make another transaction?");
//                                System.out.println();
//                                System.out.println("Enter 1 for yes or 2 to log out.");
//                                String newTransaction = scanner.nextLine();
//                                scanner.nextLine();
//                                if (!newTransaction.equalsIgnoreCase("1")){
//                                    System.out.println("Have a nice day!");
//                                    System.out.println();
//                                    running = false;
//                                }
//                                break;
//
//                            case "3":
//                                System.out.println("How much would you like to withdrawal?");
//                                double withdrawal = scanner.nextDouble();
//                                users.get(name).balance = users.get(name).balance - withdrawal;
//                                System.out.println("Your new balance is $" + users.get(name).balance);
//
//                        }
//                    }
//                }
//        }
//
//
//        }
//    }
    }

