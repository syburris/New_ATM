import javax.jws.soap.SOAPBinding;

/**
 * Created by stevenburris on 9/18/16.
 */


public class User {
    String name;
    String password;
    double balance;
    String newPassword;
    String newUser;

    String getName() {
        return name;
    }

    void setName(String newUser) throws Exception {
        if (newUser.isEmpty()) {
            throw new Exception("You must have a User Name!");
        }
        name = newUser;
    }

    String getPassword() {
        return password;
    }

    void setPassword() throws Exception {
        if (newPassword.isEmpty()) {
            throw new Exception("You have to have a password.");
        }
        else {
            password = newPassword;
        }
    }
}

