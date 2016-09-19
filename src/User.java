/**
 * Created by stevenburris on 9/18/16.
 */


public class User {
    String userName;
    String password;
    double balance;

    public User(String userName, String password, double balance) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;
    }


    //    void setName(String newUserName) throws Exception {
//        if (newUserName.isEmpty()) {
//            throw new Exception("You must have a User Name!");
//        } else {
//            userName = newUserName;
//        }
//    }
//
//    String getUserName() {
//            return userName;
//        }
//
//
//    void setPassword(String newPassword) throws Exception {
//        if (newPassword.isEmpty()) {
//            throw new Exception("You have to have a password.");
//        }
//        else {
//            password = newPassword;
//        }
//    }

    String getPassword() {
        return password;
    }

}

