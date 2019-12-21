package src
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private int shift;
    ROT13(Character cs, Character cf) {
        this.shift = cs - cf;
    }

    ROT13() {
        shift = 13;
    }


    public static String crypt(String text) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();
        char [] chars = text.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            char c = text.charAt(i);
            if(c >= 'a' && c <= 'm') {
                c += 13;
            }else if  (c >= 'A' && c <= 'M') {
                c += 13;
            } else if  (c >= 'n' && c <= 'z') {
                c -= 13;
            } else if  (c >= 'N' && c <= 'Z') {
                c -= 13;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        //this method will rotate the given String
        //by the character placement
        String sub = s.substring(0,s.indexOf(c));
        String sub1 = s.substring(s.indexOf(c));
        //then concat the two substrings.
        return sub1.concat(sub);
    }
    public static String textFile(String filename){
        StringBuilder sb = new StringBuilder();

        File file = new File(filename);
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String xored = encrypt(line);
                sb.append(xored+"\n");
            }
            sb.deleteCharAt(sb.length()-1);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

}
