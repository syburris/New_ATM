import javax.jws.soap.SOAPBinding;

/**
 * Created by stevenburris on 9/18/16.
 */
public class User {
    String name;
    String password;
    double balance;

    String getName() {
        return name;
    }

    void setName(String newName) throws Exception {
        if (newName.isEmpty()) {
            throw new Exception("You must have a User Name!");
        }
        name = newName;
    }
}

