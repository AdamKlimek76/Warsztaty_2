package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PasswordTest {

    public static void main(String [] args){

        String password="abc123";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        String candidate="abc123";
        if (BCrypt.checkpw(candidate, hashed)) {
            System.out.println("Ok");
        } else {
            System.out.println("It does not match");
        }
    }
}
