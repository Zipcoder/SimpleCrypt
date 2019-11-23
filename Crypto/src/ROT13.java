import java.io.*;
import java.util.NoSuchElementException;
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

    //ROT OBJECT crpyt this file
    //file = new File("sonnet18.txt");

//Instantiate ROT13 and take in a file to be encrypted
    public String encrpytFile() throws IOException, NoSuchElementException {
        ROT13 rot = new ROT13();

        StringBuilder output = new StringBuilder();
        String fileName = "sonnet18.enc";
        try {
            File f = new File("/Users/brandonchambers/week5/SimpleCrypt/sonnet18.txt");
            BufferedWriter op = new BufferedWriter(new FileWriter(fileName));

            Scanner out = new Scanner(f);


            while ((out.nextLine()) != null) {
                output.append(out.nextLine() + "\n");
            }
            op.write(rot.crypt(output.toString()));
            op.close();
        }
        catch (NoSuchElementException noSuchException){

        }
        catch (IOException ioException){ } {

        }

        return rot.crypt(output.toString());
    }
}
















