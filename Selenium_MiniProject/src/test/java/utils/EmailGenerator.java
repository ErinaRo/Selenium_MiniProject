package utils;

import java.util.Random;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmailGenerator {

    //The generateRandomEmail method creates a random email address by:

    //Defining a set of characters (SALTCHARS) to use for the random part of the email.
    public static String generateRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();

        //Generating a random 10-character string using these characters.
        Random rnd = new Random();

        //Appending the string with "@gmail.com" to create a complete email address.
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        //Returning this randomly generated email address.
        String saltStr = salt.toString();
        return saltStr+ "@gmail.com";
    }

}