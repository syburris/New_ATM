import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

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
        System.out.println("Please enter your name.");
        String name = scanner.nextLine();
        if (users.get(name) == null) {
            System.out.println("Would you like to create an account? Type y for yes or n for no");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")){
                main(args);
            }

            else {
                User user1 = new User(name,"1234",100);
                users.put(name,user1);
                System.out.printf("Hello %s !\n", users.get(name).userName);

            }
        }







    }
}
