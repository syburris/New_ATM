import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
/**
 * Created by stevenburris on 9/18/16.
 */
public class ATM_Take2 {

    static HashMap<String, User> users = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    User steven = new User("Steven","1234",100);

    public static void main(String[] args) {
        System.out.println("Welcome to your ATM.");
        System.out.println("Please enter your name.");
        String name = scanner.nextLine();
        if (name == null) {
            System.out.println("Would you like to create an account? Type y for yes or n for no");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")){
                main(args);
            }
            else {

            }
        }







    }
}
