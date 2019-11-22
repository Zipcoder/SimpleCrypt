import java.io.Console;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    int hi;

    ROT13(Character cs, Character cf) {
        hi = cf.compareTo(cs);

    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return encrypt(text);
    }
    //This method is working as needed
    public String encrypt(String text) {

        char[] str = text.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char letter = str[i];

            if (letter >= 'a' && letter <= 'z') {


                if (letter > 'm') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            } else if (letter >= 'A' && letter <= 'Z') {


                if (letter > 'M') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            }
            str[i] = letter;
        }

        System.out.println(new String(str));
        return new String(str);
    }

    //This method is working as needed
    public String decrypt(String text) {

        return encrypt(text);
    }
    //This method is working as needed
    public static String rotate(String s, Character c) {

        if(s.charAt(0) == c){
            return s;
        }

        StringBuilder result = new StringBuilder();
        int count = c.compareTo(s.charAt(0));
        for(int i = 0; i < s.length(); i++){
            char letter;
            if(i + count < s.length()){
                letter = s.charAt(i + count);
            }
            else {
                letter = s.charAt(i + count - s.length());
            }
            result.append(letter);
        }
        return result.toString();
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

}
















