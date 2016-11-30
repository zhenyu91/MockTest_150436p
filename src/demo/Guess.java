package demo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// This is a singleton class, which means only one instance of this class will only be created
// This class provides the business logic for the guessing the number app
// To call a method in a Singleton class (eg guess) use this command
// Guess.getInstance().guess(nric, guessInt);
// You don't instantiate it as an object since the constructor is defined as private
public class Guess {
    private static Guess ourInstance = new Guess();
    // random number generator
    private Random random = new Random();
    // the lucky number to be guessed
    private int luckyNumber;
    // store user attempts based on user nric
    private Map<String, Integer> userList;

    public static Guess getInstance() {
        return ourInstance;
    }

    // constructor to initialize the random number, and the userList
    private Guess() {
        if (userList == null) {
            luckyNumber = random.nextInt(100);
            userList = new HashMap<String, Integer>();
        }
        System.out.println("Lucky Number is " + luckyNumber);
    }
    /*
        Use this method to guess the value of the lucky number
        Each user is entitled 3 tries to guess the right number, and this method will also record/verify the attempts
        If return value is
        0 - Bingo, you guess correctly
        1 - Your number is higher than the lucky number
        -1 - Your number is lower than the lucky number
        999 - Your have tried 3 times, you cannot try again
     */
    public int guess(String nric, int value) {
        if (userList.containsKey(nric)) {
            Integer i = userList.get(nric);
            userList.put(nric, ++i);
            if (i > 3) return 999;
            else return checkNumber(value);
        } else {
            userList.put(nric, 1);
            return checkNumber(value);
        }
    }

    /*
        Check your number against the lucky number
        If return value is
        0 - Perfect match!
        1 - Your number is higher
        -1 - Your number is lower
     */

    private int checkNumber(int i) {
        System.out.println(i + ":" + luckyNumber);
        if (i>luckyNumber) {
            return 1;
        } else if (i<luckyNumber) {
            return -1;
        } else {

            return 0;
        }
    }

}
